package com.example.bustudyspots;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
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
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;


public class MapActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnInfoWindowClickListener {

    private boolean cafe;
    private boolean libraries;
    private boolean BUspaces;
    private boolean all;
    private final String Description = "Tap for more info";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        locationTries =0;
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
        getLocationPermission();
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
    // All the locations
    private Marker ingalls;
    private Marker mugar;
    private Marker stuvi2;
    private Marker gsu;
    private Marker pho;
    private Marker sci;
    private Marker law;
    private Marker cas;
    private Marker yawkey;
    private Marker hojo;
    private Marker sed;
    private Marker scienglib;
    private Marker sth;
    private Marker sar;
    private Marker stuvi1;
    private Marker cfa;
    private Marker khc;
    private Marker com;
    private Marker warren;
    private Marker elie;
    private Marker clafin;
    private Marker sleeper;
    private Marker rich;
    private Marker towers;
    private Marker cgs;
    private Marker qst;
    private Marker buswellfoureight;
    private Marker elliot;
    private Marker commtennineteen;
    private Marker beach;
    private Marker hillel;
    private Marker south;
    private Marker fitrec;
    private Marker engl;
    private Marker barnes;
    private Marker psych;
    private Marker danielsen;

    private Marker pardee;

    private Marker pavement;
    private Marker nero;
    private Marker swarren;
    private Marker swest;
    private Marker squest;
    private Marker skenmore;
    private Marker tatte;
    private Marker limered;
    private Marker buickst;
    private Marker tbaar;
    private Marker panera;
    private Marker bluestate;
    private Marker trident;

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        if (mLocationPermissionsGranted) {
            getDeviceLocation();

            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                    != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this,
                    Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                return;
            }
            mMap.setMyLocationEnabled(true);
            mMap.getUiSettings().setMyLocationButtonEnabled(false);

        }

        if (cafe) {
            //all the cafe markers
            //magenta cuz why not

            MarkerOptions cafes = new MarkerOptions().snippet(Description).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA));

            LatLng pavementl = new LatLng(42.349802, -71.107192);
            pavement = mMap.addMarker(cafes.position(pavementl).title("Pavement"));
            pavement.setTag(ID.PAVEMENT);

            LatLng nerol = new LatLng(42.352234, -71.122626);
            nero = mMap.addMarker(cafes.position(nerol).title("Cafe Nero"));
            nero.setTag(ID.NERO);

            LatLng swarrenl = new LatLng(42.349350, -71.103092);
            swarren = mMap.addMarker(cafes.position(swarrenl).title("Central Campus Starbucks"));
            swarren.setTag(ID.SWARREN);

            LatLng swestl = new LatLng(42.350704, -71.114545);
            swest = mMap.addMarker(cafes.position(swestl).title("West Campus Starbucks"));
            swest.setTag(ID.SWEST);

            LatLng squestl = new LatLng(42.349629, -71.099548);
            squest = mMap.addMarker(cafes.position(squestl).title("Questrom Starbucks"));
            squest.setTag(ID.SQUEST);

            LatLng skenmorel = new LatLng(42.348501, -71.095930);
            skenmore = mMap.addMarker(cafes.position(skenmorel).title("East Campus Starbucks"));
            skenmore.setTag(ID.SKENMORE);

            LatLng tattel = new LatLng(42.345765, -71.106860);
            tatte = mMap.addMarker(cafes.position(tattel).title("Tatte Bakery"));
            tatte.setTag(ID.TATTE);


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
        mMap.setOnInfoWindowClickListener(this);

    }
    private static final String TAG = "MapActivity";

    private static final String FINE_LOCATION = Manifest.permission.ACCESS_FINE_LOCATION;
    private static final String COURSE_LOCATION = Manifest.permission.ACCESS_COARSE_LOCATION;
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1234;
    private static final float DEFAULT_ZOOM = 15f;

    //vars
    private Boolean mLocationPermissionsGranted = false;
    private GoogleMap mMap;
    private FusedLocationProviderClient mFusedLocationProviderClient;
    private int locationTries;

    private void getDeviceLocation(){
        Log.d(TAG, "getDeviceLocation: getting the devices current location");

        mFusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);

        try{
            if(mLocationPermissionsGranted){

                final Task location = mFusedLocationProviderClient.getLastLocation();
                location.addOnCompleteListener(new OnCompleteListener() {
                    @Override
                    public void onComplete(@NonNull Task task) {
                        if(task.isSuccessful()){
                            Log.d(TAG, "onComplete: found location!");
                            Location currentLocation = (Location) task.getResult();

                                moveCamera(new LatLng(currentLocation.getLatitude(), currentLocation.getLongitude()),
                                        DEFAULT_ZOOM);
                        }else{
                            Log.d(TAG, "onComplete: current location is null");
                            Toast.makeText(MapActivity.this, "unable to get current location", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        }catch (SecurityException e){
            Log.e(TAG, "getDeviceLocation: SecurityException: " + e.getMessage() );
        }

    }

    private void moveCamera(LatLng latLng, float zoom){
        Log.d(TAG, "moveCamera: moving the camera to: lat: " + latLng.latitude + ", lng: " + latLng.longitude );
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, zoom));
    }

    private void initMap(){
        Log.d(TAG, "initMap: initializing map");
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);

        mapFragment.getMapAsync(MapActivity.this);
    }

    private void getLocationPermission(){
        Log.d(TAG, "getLocationPermission: getting location permissions");
        String[] permissions = {Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION};

        if(ContextCompat.checkSelfPermission(this.getApplicationContext(),
                FINE_LOCATION) == PackageManager.PERMISSION_GRANTED){
            if(ContextCompat.checkSelfPermission(this.getApplicationContext(),
                    COURSE_LOCATION) == PackageManager.PERMISSION_GRANTED){
                mLocationPermissionsGranted = true;
                initMap();
            }else{
                ActivityCompat.requestPermissions(this,
                        permissions,
                        LOCATION_PERMISSION_REQUEST_CODE);
            }
        }else{
            ActivityCompat.requestPermissions(this,
                    permissions,
                    LOCATION_PERMISSION_REQUEST_CODE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        Log.d(TAG, "onRequestPermissionsResult: called.");
        mLocationPermissionsGranted = false;

        switch(requestCode){
            case LOCATION_PERMISSION_REQUEST_CODE:{
                if(grantResults.length > 0){
                    for(int i = 0; i < grantResults.length; i++){
                        if(grantResults[i] != PackageManager.PERMISSION_GRANTED){
                            mLocationPermissionsGranted = false;
                            Log.d(TAG, "onRequestPermissionsResult: permission failed");
                            return;
                        }
                    }
                    Log.d(TAG, "onRequestPermissionsResult: permission granted");
                    mLocationPermissionsGranted = true;
                    //initialize our map
                    initMap();
                }
            }
        }
    }


    @Override
    public void onInfoWindowClick(Marker marker) {
       // Toast.makeText(this, "what does this look like", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "Info window clicked");
        Intent showMoreInfo = new Intent(this, ScrollingActivity.class);
        showMoreInfo.putExtra("ID", (Integer) marker.getTag());
        startActivity(showMoreInfo);
    }
}
