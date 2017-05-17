package com.map.map;

import android.*;
import android.Manifest;
import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentActivity;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;

import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.*;
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
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sfo,19));

        GoogleMapOptions options = new GoogleMapOptions();

        options.compassEnabled(true)
                .rotateGesturesEnabled(true)
                .tiltGesturesEnabled(false)
                .scrollGesturesEnabled(true)
                .zoomControlsEnabled(true)
                .zoomGesturesEnabled(true);



        /*
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(37.616724,-122.381060))
                .title("Gate 52")
                .snippet("Gate 52 text"));
*/

    }

}
