package joshuaoconnor.com.smartparker;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.app.ActionBar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.util.HashMap;
/*
  This activity is called upon when a user clicks a "Create New Entry" button in MainActivity.  This
  allows the user to edit their Log for their Parking Entry, which contains location, notes, gallery,
  and Google Maps.

  This the central activity to this application, however, it is not the launch/starting activity.

 */


public class LogActivity extends ActionBarActivity

{

    // for our logs
    public static final String LOG_TAG = "LogActivity.java";

    private ActionBar actionBar;

    DBController controller = new DBController(this);

    private static final String LOGCAT = null;
    Integer animalId;
    public HashMap<String, String> onePlace;
    ImageView animalPicture;
    TextView animalLocation;
    TextView animalTitle;
    TextView animalName;


    //onCreate activity called when activity is first created


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);
        actionBar = getActionBar();


        Intent intent = getIntent();
        animalId = intent.getIntExtra("animalId", 1);
        Log.d(LOGCAT, "Get animalId = " + animalId);
        // get onePlace from database
        onePlace = controller.getAnimalInfo(animalId);
        Log.d(LOGCAT, "Get onePlace from database");

        animalName = (TextView) findViewById(R.id.NotesTextView);
        animalPicture = (ImageView) findViewById(R.id.PictureImageView);
        animalTitle = (TextView) findViewById(R.id.TitleTextView);
        animalLocation = (TextView) findViewById(R.id.LocationTextView);

        String varValues = onePlace.get("animalPicture");
        if (varValues != null) {

            animalPicture.setImageURI(Uri.parse(onePlace.get("animalPicture")));

        } else {
            ImageView image = (ImageView) findViewById(R.id.PictureImageView);
            image.setImageResource(R.drawable.gallery);
        }

        Log.d(LOGCAT, "AFTER IMAGE URI");
        animalLocation.setText(onePlace.get("animalLocation"));
        animalName.setText(onePlace.get("animalName"));
        animalTitle.setText(onePlace.get("animalTitle"));
    }


    public void clickLocation/*id for textfield (located in activity_log.xml) that can be clicked to bring up LocationActivity.*/(View V) {
        // Create an Intent
        Intent intent = new Intent(getApplicationContext(), LocationActivity.class);
        startActivity(intent);
    }

    //ADD NEW NOTES
    public void NewAnimal(View V) {
        // Create an Intent, which will be use for start LogActivity when clicked.
        Intent intent = new Intent(getApplicationContext(), NewAnimal.class);
        startActivity(intent);
    }

    //ADD NEW TITLE
    public void NewTitle1(View V) {
        // Create an Intent, which will be use for start LogActivity when clicked.
        Intent intent = new Intent(getApplicationContext(), NewTitle.class);
        startActivity(intent);
    }


    // ADD NEW PICTURE
    public void clickCamera /*id for image button (located in activity_notes.xml) that can be clicked to bring up Camera Activity.*/(View V) {
        // Create an Intent
        Intent intent = new Intent(getApplicationContext(), CameraActivity.class);
        startActivity(intent);
    }


    //As of 12/8/2014, I am not using this class for the purpose of the assignment, but I will keep the code just in case in the future I choose to use it.
    //create a way so that the user can click the image of a picture in the gallery and view gallery (Create an intent
    //which will link LogActivity to GalleryActivity when the a gallery Image is clicked)
    public void clickGallery(View V) {
        // Create an Intent
        Intent intent = new Intent(getApplicationContext(), GalleryActivity.class);
        startActivity(intent);
    }

    public void clickProfilePic(View V) {
        // Create an Intent
        Intent intent = new Intent(getApplicationContext(), MainPhoto.class);
        startActivity(intent);
    }

    //Google Maps
    public void clickTakeMeToMyCar(View V) {
        // Create an Intent
        Intent intent = new Intent(getApplicationContext(), MapsActivity.class);
        startActivity(intent);
    }

    //onStart method
    //when the app is no longer visible (but not terminated) and reopened, it will go to this screen.
    @Override
    protected void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
    }


    //onResume method will be called after the app has been paused, will direct to this screen
    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onPause();
    }



}
