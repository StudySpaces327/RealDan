package com.example.bustudyspots;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.location.Location;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;


public class MapActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnInfoWindowClickListener {

    private GoogleMap mMap;
    private boolean cafe;
    private boolean libraries;
    private boolean BUspaces;
    private boolean all;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            cafe = extras.getBoolean("Cafe");
            libraries = extras.getBoolean("libraries");
            BUspaces = extras.getBoolean("BUonly");
            all = extras.getBoolean("All");
            if (all) {
                cafe = true;
                libraries = true;
                BUspaces = true;
            }
        }

        setContentView(R.layout.map_activity);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        // getSupportActionBar().setDisplayShowHomeEnabled(true);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        if (cafe) {
            //all the cafe markers
            //magenta cuz why not
            LatLng Pavement = new LatLng(42.349802, -71.107192);
            mMap.addMarker(new MarkerOptions().position(Pavement).title("Pavement").snippet("trashy lattes").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)));
        }
        if (libraries) {
            //all the libraries
            // orange marker
            LatLng Mugar = new LatLng(42.350851, -71.108103);
            mMap.addMarker(new MarkerOptions().position(Mugar).title("Mugar").snippet("h\ni\ni\ni\n").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
        }
        if (BUspaces) {
            //all the Bu spaces
            // red marker
            LatLng Photonics = new LatLng(42.349197, -71.106092);
            mMap.addMarker(new MarkerOptions().position(Photonics).title("Photonics").snippet("Let's see if we can make this really cool \n by adding tonnes of lines").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
        }
        // Add a marker in Sydney and move the camera
        LatLng cslab = new LatLng(42.349197, -71.106092);
        mMap.addMarker(new MarkerOptions().position(cslab).title("Yeeto Cheeto"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(cslab, 14));
//        mMap.moveCamera(CameraUpdateFactory.zoomTo(14));
        mMap.setOnInfoWindowClickListener(this);
    }

    @Override
    public void onInfoWindowClick(Marker marker) {
        Toast.makeText(this, "what does this look like", Toast.LENGTH_SHORT).show();
    }
}
