package joshuaoconnor.com.smartparker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

/**
 *
 * Need code for a dialogue box -- Select Location ->  1)  Current Location (latlng) 2) New Location (new screen)
 *
  This class is used to create a new Location from LogActivity.  When the text field next to
  the Location icon in LogActivity is clicked, a pop-up selection menu will come up and allow the
  user to pick from a selection:
    1) To either use current location (automatically generated),
    2) A previously saved location,
    3) A new location.  A new location brings up Google Maps (GoogleMapsActivity) in which the
       user can select a location.
 */


public class LocationActivity extends ActionBarActivity {
    //onCreate activity called when activity is first created
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Load activity_location.xml as layout
        setContentView(R.layout.activity_location);
    }


    public void clickLocationTracker /*id for image button (located in activity_location_tracker.xml) that can be clicked to bring up Google Maps.*/(View V){
        // Create an Intent
        Intent intent=new Intent(getApplicationContext(),LocationTracker.class);
        startActivity(intent);
    }

    public void toNewLocation /*id for image button (located in activity_location_tracker.xml) that can be clicked to bring up Google Maps.*/(View V){
        // Create an Intent
        Intent intent=new Intent(getApplicationContext(),NewLocation.class);
        startActivity(intent);
    }



}
