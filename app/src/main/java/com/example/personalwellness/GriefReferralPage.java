package com.example.personalwellness;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.location.Location;
import android.Manifest;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

public class GriefReferralPage extends AppCompatActivity implements OnMapReadyCallback {
    ResourceDB resourceDB = new ResourceDB();
    List<Resource> resources = resourceDB.getResourceList();
    double lat;
    double lng;
    String resourceName;

    private GoogleMap mMap;

    private static final String TAG = GriefReferralPage.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grief_referral_page);

        String extra = getIntent().getStringExtra("buttonid");
        TextView textV = (TextView) findViewById(R.id.griefRef);
        TextView textAbout = (TextView) findViewById(R.id.resourceabout);
        TextView textAddress = (TextView) findViewById(R.id.address);
        initMap();

        for (int i = 0; i < resources.size(); i++) {
            if (extra.equals((i+1)+"")) {
                resourceName = resources.get(i).getName();
                textV.setText(resourceName);
                textAbout.setText(resources.get(i).getSummary());
                lat = resources.get(i).getLat();
                lng = resources.get(i).getLng();
                if (!resources.get(i).getAddress().equals("")) {
                    textAddress.setText("Address:" + resources.get(i).getAddress());
                }

            }
        }
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        Toast.makeText(this, "map is ready", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "-----------creating map");
        moveCam(new LatLng(lat, lng), resourceName);
    }


    // initializes the map
    private void initMap() {
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    private void moveCam(LatLng coords, String title) {
        Log.d(TAG, "moving camera to lat: " + coords.latitude + ", lng " + coords.longitude);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(coords, 16f));
        if (!title.equals("My location")) {
            MarkerOptions options = new MarkerOptions().position(coords).title(title);
            mMap.addMarker(options);
        }
    }
}
