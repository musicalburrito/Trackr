package com.asdfjk.project.trackr;

import android.Manifest;
import android.app.Application;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.renderscript.Double2;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class MainActivity extends AppCompatActivity {

    private static final int MY_PERMISSIONS_REQUEST_LOCATION= 99;
//    LocationListener locationListener = new MyLocationListener();
    private static final String TAG = "something";
    FirebaseDatabase db = FirebaseDatabase.getInstance();
    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        LocationListener locationListener = new MyLocationListener();
        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission. ACCESS_FINE_LOCATION},
                MY_PERMISSIONS_REQUEST_LOCATION);
        startService(new Intent(this, MyService.class));
//        getLocation();

//        String []values = {"fdsf","dfdf"};
//        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.persons_list, values);
//        ListView persons = (ListView) findViewById(R.id.persons);
//        persons.setAdapter(adapter);
    }

//    public static String deviceId(Context c){
//        TelephonyManager tManager = (TelephonyManager)c.getSystemService(Context.TELEPHONY_SERVICE);
//        String deviceId = tManager.getDeviceId();
//        return deviceId;
//    }



//    private void getLocation() {
//        // Get the location manager
//        LocationManager locationManager = (LocationManager)
//                getSystemService(LOCATION_SERVICE);
//        if(ContextCompat.checkSelfPermission(this,
//                Manifest.permission. ACCESS_FINE_LOCATION)
//                == PackageManager.PERMISSION_GRANTED) {
//            locationManager.requestLocationUpdates(LocationManager
//                    .GPS_PROVIDER, 5000, 0, locationListener);
//            Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
//            double lat = 0;
//            double lon = 0;
//            try {
//                lat = location.getLatitude();
//                lon = location.getLongitude();
//            } catch (NullPointerException e) {
//                lat = -1.0;
//                lon = -1.0;
//            }
//            ref = db.getReference("lat");
//            ref.setValue(lat);
//            ref = db.getReference("lon");
//            ref.setValue(lon);
////            TextView a = (TextView) findViewById(R.id.longitude);
////            a.setText(Double.toString(lon));
////            TextView b = (TextView) findViewById(R.id.latitude);
////            b.setText(Double.toString(lat));
//        }
//        else{
//            Toast.makeText(getBaseContext(), "Do not have sufficient permissions.",Toast.LENGTH_SHORT).show();
//        }
//    }
//
//    private class MyLocationListener implements LocationListener{
//
//        @Override
//        public void onLocationChanged(Location loc){
//            Toast.makeText(getBaseContext(), "Location changed : Lat: " +
//                            loc.getLatitude() + " Lng: " + loc.getLongitude(),
//                    Toast.LENGTH_SHORT).show();
//            String longitude = "Longitude: " + loc.getLongitude();
//            Log.v(TAG, longitude);
//            String latitude = "Latitude: " + loc.getLatitude();
//            Log.v(TAG, latitude);// TODO Auto-generated method stub
//        }
//
//        @Override
//        public void onStatusChanged(String provider,int status,Bundle extras){
//            // TODO Auto-generated method stub
//        }
//
//        @Override
//        public void onProviderDisabled(String provider) {
//            // TODO Auto-generated method stub
//        }
//
//        @Override
//        public void onProviderEnabled(String provider) {
//            // TODO Auto-generated method stub
//        }
//
//    }

}
