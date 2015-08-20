package joshuaoconnor.com.smartparker;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

/**
 * As of 12/8/2014, I will not be using this class for the application.  I will keep it however, just in case I choose to use it in the future.
 * http://stackoverflow.com/questions/10019331/using-google-maps-directions-in-android-app
 *
 *
 * Figure out how to use stored location (latlng) and input it to directions on Google Maps
 *
  This class is used to give the user directions to their car via Google Maps.  The directions that
  Google Maps will choose will be what is in the Location Field in LogActivity.  This is called upon
  when the "Take Me To My Car" button is clicked.
 */
//
/**String geoUriString = "http://maps.google.com/maps?" +
"saddr=" + srcLat + "," + srcLng + "&daddr=" + dstLat + "," + dstLng;

        Intent mapCall = new Intent(Intent.ACTION_VIEW, Uri.parse(geoUriString));


 */
public class DirectionsActivity extends ActionBarActivity {
    //load action bar
    private ActionBar actionBar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Load activity_directions.xml as layout
        setContentView(R.layout.activity_directions);

        actionBar = getActionBar();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
