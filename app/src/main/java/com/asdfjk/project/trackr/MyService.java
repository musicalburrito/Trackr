package com.asdfjk.project.trackr;

import android.*;
import android.app.Service;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MyService extends Service {

    private static final int MY_PERMISSIONS_REQUEST_LOCATION= 99;
    LocationListener locationListener = new MyService.MyLocationListener();
    private static final String TAG = "something";
    FirebaseDatabase db = FirebaseDatabase.getInstance();
    DatabaseReference ref;

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent,int flags, int startId){
        super.onStartCommand(intent,flags, startId);
        return START_STICKY;
    }

    @Override
    public void onCreate(){
        getLocation();
    }

    private void getLocation() {
//        Toast.makeText(getBaseContext(),"getLocation",
//                Toast.LENGTH_SHORT).show();
        // Get the location manager
        LocationManager locationManager = (LocationManager)
                getSystemService(LOCATION_SERVICE);
        if(ContextCompat.checkSelfPermission(this,
                android.Manifest.permission. ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            locationManager.requestLocationUpdates(LocationManager
                    .GPS_PROVIDER, 5000, 0, locationListener);
            Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            double lat;
            double lon;
            try {
                lat = location.getLatitude();
                lon = location.getLongitude();
            } catch (NullPointerException e) {
                lat = -1.0;
                lon = -1.0;
            }
            ref = db.getReference("lat");
            ref.setValue(lat);
            ref = db.getReference("lon");
            ref.setValue(lon);
        }
        else{
            Toast.makeText(getBaseContext(), "Do not have sufficient permissions.",Toast.LENGTH_SHORT).show();
        }
    }

    private class MyLocationListener implements LocationListener {

        @Override
        public void onLocationChanged(Location loc){
//            Toast.makeText(getBaseContext(), "Service Location changed : Lat: " +
//                            loc.getLatitude() + " Lng: " + loc.getLongitude(),
//                    Toast.LENGTH_SHORT).show();
//            String longitude = "Longitude: " + loc.getLongitude();
//            Log.v(TAG, longitude);
//            String latitude = "Latitude: " + loc.getLatitude();
//            Log.v(TAG, latitude);// TODO Auto-generated method stub
            ref = db.getReference("lat");
            ref.setValue(loc.getLongitude());
            ref = db.getReference("lon");
            ref.setValue(loc.getLatitude());
        }

        @Override
        public void onStatusChanged(String provider,int status,Bundle extras){
            // TODO Auto-generated method stub
        }

        @Override
        public void onProviderDisabled(String provider) {
            // TODO Auto-generated method stub
        }

        @Override
        public void onProviderEnabled(String provider) {
            // TODO Auto-generated method stub
        }

    }
}
