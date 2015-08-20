package joshuaoconnor.com.smartparker;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.HashMap;

public class MapsActivity extends FragmentActivity {

    private GoogleMap mMap;
    // Might be null if Google Play services APK is not available.
    Integer animalId;
    public HashMap<String, String> onePlace;
    DBController controller = new DBController(this);

    private static final String LOGCAT = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        setUpMapIfNeeded();

        mMap.moveCamera( CameraUpdateFactory.newLatLngZoom(new LatLng(38.0500,241.0) , 5.5f) );



    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }

    /**
     * Sets up the map if it is possible to do so (i.e., the Google Play services APK is correctly
     * installed) and the map has not already been instantiated.. This will ensure that we only ever
     * call {@link #setUpMap()} once when {@link #mMap} is not null.
     * <p>
     * If it isn't installed {@link SupportMapFragment} (and
     * {@link com.google.android.gms.maps.MapView MapView}) will show a prompt for the user to
     * install/update the Google Play services APK on their device.
     * <p>
     * A user can return to this FragmentActivity after following the prompt and correctly
     * installing/updating/enabling the Google Play services. Since the FragmentActivity may not
     * have been completely destroyed during this process (it is likely that it would only be
     * stopped or paused), {@link #onCreate(Bundle)} may not be called again so we should call this
     * method in {@link #onResume()} to guarantee that it will be called.
     */

    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                mMap.setMyLocationEnabled(true);
                setUpMap();

            }
        }
    }
    /*private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.

        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();
            }
        }
    }
    */

    /**
     * This is where we can add markers or lines, add listeners or move the camera. In this case, we
     * just add a marker near Africa.
     * <p>
     * This should only be called once and when we are sure that {@link #mMap} is not null.
     */


    //FIGURE OUT HOW TO POPULATE MAP WITH A MARKER THAT HAS THE LAT FROM animalLatitude AND THE LONG
    //FROM animalLongitude.

    private void setUpMap() {


     //INSERT LAT AND LNG FROM LAT+LNG!!!!
     //Currently Crashing My app.
    //     onePlace = controller.getLatLng(animalId);
      //  Double LatValue = new Double(onePlace.get("animalLat"));
       // Double LongValue = new Double(onePlace.get("animalLong"));
      //  Intent intent = getIntent();
      //  animalId = intent.getIntExtra("animalId", 1);
      //  Log.d(LOGCAT, "Get animalId = " + animalId);

 //    mMap.addMarker(new MarkerOptions().position(new LatLng(LatValue, LongValue)).title("Marker"));



     //      mMap.addMarker(new MarkerOptions().position(new LatLng(37.0,170.0)).title("Marker"));
    }
}
