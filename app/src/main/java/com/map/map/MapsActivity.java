package com.map.map;


import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.ui.IconGenerator;





public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker within SFO
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        //Add a marker in SFO and move the camera
        LatLng sfo = new LatLng(37.617104, -122.381094);
        mMap.addMarker(new MarkerOptions()
                .position(sfo)
                .title("SFO T2"));

        //set default zoom to SFO zoom level 19
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sfo, 19));

        GoogleMapOptions options = new GoogleMapOptions();

        options.compassEnabled(true)
                .rotateGesturesEnabled(true)
                .tiltGesturesEnabled(false)
                .scrollGesturesEnabled(true)
                .zoomControlsEnabled(true)
                .zoomGesturesEnabled(true);

        IconGenerator iconFactory = new IconGenerator(this);
        iconFactory.setBackground(null);
        iconFactory.setTextAppearance(IconGenerator.STYLE_RED);
        //G50 37.616881, -122.382309
        addIcon(iconFactory, "G50\nVX50,N50VA\nSFO-LAX,1200", new LatLng(37.616881, -122.382309));

        //g51A
        addIcon(iconFactory, "G51A\nVX511,N511VA\nSFO-SAN,1300", new LatLng(37.617003, -122.381834));

        //G51B 37.616788, -122.381452
        addIcon(iconFactory, "G51B\nVX512,N512VA\nSFO-SEA,1400", new LatLng(37.616788, -122.381452));

        //gate 52 37.616690, -122.381101
        addIcon(iconFactory, "G52\nVX52,N52VA\nSFO-PDX,1500", new LatLng(37.616690, -122.381101));

        //G53 37.616754, -122.380740
        addIcon(iconFactory, "G53\nVX53,N53VA\nSFO-DEN,1600", new LatLng(37.616754, -122.380740));

        //G54A 37.617079, -122.380656
        addIcon(iconFactory, "G54A\nVX541,N541VA\nSFO-HNL,1700", new LatLng(37.617079, -122.380656));

        //G54B 37.617485, -122.380827
        addIcon(iconFactory, "G54B\nVX542,N542VA\nSFO-OGG,1800", new LatLng(37.617485, -122.380827));
    }


    private void addIcon(IconGenerator iconFactory, CharSequence text, LatLng position) {
        MarkerOptions markerOptions = new MarkerOptions().
                icon(BitmapDescriptorFactory.fromBitmap(iconFactory.makeIcon(text))).
                position(position).
                anchor(iconFactory.getAnchorU(), iconFactory.getAnchorV());

        getMap().addMarker(markerOptions);
    }

    protected GoogleMap getMap() {
        return mMap;
    }
}
