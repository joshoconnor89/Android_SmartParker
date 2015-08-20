package joshuaoconnor.com.smartparker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.app.ActionBar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

/**
 * As of 12/8/2014, I will not be using this class for the Application.  Since it is functional, I will keep this for future usage.

 This class will be used to store pictures taken in a gallery.  The pictures will give the user visual
 reminder of where they have parked.  This class is called upon when the user clicks the gallery box
 in LogActivity, or after a user takes a picture.

 */


public class GalleryActivity extends ActionBarActivity {

    private ActionBar actionBar;


    GridView grid;
    String[] web = {
            "Image1",
            "Image2",
            "Image3",
            "Image4",
            "Image5"

    } ;
    int[] imageId = {
            R.drawable.image1,
            R.drawable.image2,
            R.drawable.image3,
            R.drawable.image4,
            R.drawable.image5,




    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        actionBar = getActionBar();

        GridActivity adapter = new GridActivity(GalleryActivity.this, web, imageId);
        //id grid is in activity_gallery.xml
        grid=(GridView)findViewById(R.id.grid);
        grid.setAdapter(adapter);
        //add on click listener
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            //on click, toast message pops up
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(GalleryActivity.this, "You Clicked at " + web[+position], Toast.LENGTH_SHORT).show();

            }
        });

    }








    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_gallery_actions, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.gallery_select) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

//need gridview for photos to be stored (from CameraActivity)