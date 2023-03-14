using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.XR.ARFoundation;
using UnityEngine.XR.ARSubsystems;
using Google.XR.ARCoreExtensions;
using System;
using UnityEngine.UI;

 
public class DropdownHandler  MonoBehaviour
{
    public Text TextBox;
    public Text TextBool;

 

    public VPSManager VPSManager;
    // Start is called before the first frame update
    void Start()
    {
        var dropdown = transform.GetComponent<Dropdown>();
        dropdown.options.Clear();
        dropdown.options.Sort();

 

        List<string> items = new List<string>();
        items.Add("Administrativo");
        items.Add("ATH");
        items.Add("Comercial");
        items.Add("Cuarto de servidores");
        items.Add("Help care");
        items.Add("Presidencia");
        items.Add("Sala de innovaci?n");
        items.Add("Sala de descanso");
        items.Add("Sala principal de reuniones");
        items.Add("Soporte");
        items.Add("Talento y cultura");
        items.Add("Torre QA");
        items.Add("Torre Big Data");
        items.Add("Torre de desarrollo");
        items.Add("Torre DEVOps");
        items.Add("Torre Profetas");
        items.Add("Comedor");
        items.Add("Cocina");
        items.Add("Sala");

 

        foreach (var item in items)
        {
            dropdown.options.Add(new Dropdown.OptionData() { text = item});
        }

 

        dropdown.onValueChanged.AddListener(delegate { DropdownItemSelected(dropdown); });

 

    }

 

    void DropdownItemSelected(Dropdown dropdown)
    {
        int index = dropdown.value;

 

        var nom = VPSManager.geospatialObjects[index].ObjectPrefab.name;
        TextBox.text = nom;
        //TextBox.text = dropdown.options[index].text;
        int cont = 0;
        foreach (var obj in VPSManager.geospatialObjects)
        {
            VPSManager.geospatialObjects[cont].Visible.Equals(false);
            cont++;
        }

 

        VPSManager.GeospatialObject objeto = VPSManager.geospatialObjects[index];
        objeto.Visible = true;
        VPSManager.geospatialObjects[index].Visible.Equals(objeto);

 

        var opc = VPSManager.geospatialObjects[index].Visible;
        TextBool.text = opc.ToString();
        //VPSManager.PlaceObjects(index);

 

    }
}

 

////////////////////////////////

 

public class VPSManager : MonoBehaviour
{
    [SerializeField] private AREarthManager earthManager;

 

    [Serializable]
    public struct GeospatialObject : IEquatable<GeospatialObject>
    {
        public GameObject ObjectPrefab;
        public bool Visible;
        public EarthPosition EarthPosition;

 

        public bool Equals(GeospatialObject other)
        {
            return Visible == other.Visible;
        }
    }

 

    [Serializable]
    public struct EarthPosition
    {
        public double Latitude;
        public double Longitude;
        public double Altitude;
    }

 

    [SerializeField] private ARAnchorManager aRAnchorManager;
    [SerializeField] public List<GeospatialObject> geospatialObjects = new List<GeospatialObject>();

 

    public Text TextBox;

 

    void Start()
    {
        VerifyGeospatialSupport();
    }

 

    private void VerifyGeospatialSupport()
    {
        var result = earthManager.IsGeospatialModeSupported(GeospatialMode.Enabled);

 

        switch (result)
        {
            case FeatureSupported.Supported:
                Debug.Log("Ready to use VPS");
                PlaceObjects();
                break;
            case FeatureSupported.Unknown:
                Debug.Log("Unknown...");
                Invoke("VerifyGeospatialSupport", 5.0f);
                break;
            case FeatureSupported.Unsupported:
                Debug.Log("VPS Unsupported");
                break;
        }
    }

 

    private void PlaceObjects()
    {
        if (earthManager.EarthTrackingState == TrackingState.Tracking)
        {
            var geospatialPose = earthManager.CameraGeospatialPose;
            var altitud = geospatialPose.Altitude;
            foreach (var obj in geospatialObjects)
            {
                if (obj.Visible == true)
                {
                    var earthPosition = obj.EarthPosition;
                    var objAnchor = ARAnchorManagerExtensions.AddAnchor(aRAnchorManager, earthPosition.Latitude, earthPosition.Longitude, altitud, Quaternion.identity);
                    Instantiate(obj.ObjectPrefab, objAnchor.transform);
                    obj.ObjectPrefab.SetActive(obj.Visible);
                }
                else
                {
                    var earthPosition = obj.EarthPosition;
                    var objAnchor = ARAnchorManagerExtensions.AddAnchor(aRAnchorManager, 0, 0, altitud, Quaternion.identity);
                    Instantiate(obj.ObjectPrefab, objAnchor.transform);
                    obj.ObjectPrefab.SetActive(obj.Visible);
                }
            }
        }
        else if(earthManager.EarthTrackingState == TrackingState.None)
        {
            Invoke("PlaceObjects", 5.0f);
        }
    }
    public void PlaceObjects(int index)
    {
        if (earthManager.EarthTrackingState == TrackingState.Tracking)
        {
            GeospatialObject objeto;
            int cont = 0;
            foreach (var obj in geospatialObjects)
            {
                objeto = obj;
                objeto.Visible = false;
                geospatialObjects[cont] = objeto;
                cont++;
            }
            objeto = geospatialObjects[index];
            objeto.Visible = true;
            geospatialObjects[index] = objeto;
        }
        else if (earthManager.EarthTrackingState == TrackingState.None)
        {
            Invoke("placeObjects", 5.0f);
        }
    }

 

    private void OnGUI()
    {
        var geospatialPose = earthManager.CameraGeospatialPose;
        var altitud = geospatialPose.Altitude;
        foreach (var obj in geospatialObjects)
        {
            var earthPosition = obj.EarthPosition;
            string mensaje = "Latitud : " + earthPosition.Latitude +
                "\nGeospatialPoseLatitud : " + geospatialPose.Longitude +
                "\nLongitud : " + earthPosition.Longitude +
                "\nGeospatialPoseLongitud : " + geospatialPose.Latitude +
                "\nAltitud :" + earthPosition.Altitude + 
                "\nAltitud dispositivo : " + altitud +
                "\nGeospatialPose :" + geospatialPose.Heading +
                "\nHeadingAccuracy : " + geospatialPose.HeadingAccuracy;
            GUI.contentColor = Color.red;
            GUI.skin.label.fontSize = 30;
            GUI.Label(new Rect(50, 40, 1000, 1000), mensaje);
        }
    }

 

    void update(int index)
    {
        foreach (var obj in geospatialObjects)
        {
            obj.Visible.Equals(false);
        }
        geospatialObjects[index].Visible.Equals(true);

 

        TextBox.text = index.ToString();
    }
}