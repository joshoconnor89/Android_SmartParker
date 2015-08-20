package joshuaoconnor.com.smartparker;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;

/**
 * Created by joshuaoconnor on 12/12/14.
 *
 * */
   public class MainPhoto extends Activity {
    private ActionBar actionBar;

    DBController controller = new DBController(this);

    private static final String LOGCAT = null;
    Integer animalId;
    public HashMap<String, String> onePlace;
    ImageView animalPicture;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainpic);




        Intent intent = getIntent();
        animalId = intent.getIntExtra("animalId", 1);
        Log.d(LOGCAT, "Get animalId = " + animalId);
        // get onePlace from database
        onePlace = controller.getAnimalInfo(animalId);
        Log.d(LOGCAT, "Get onePlace from database");

        animalPicture = (ImageView) findViewById(R.id.PictureImageView);

        //THIS IS MAKING MY APP CRASH IF I DO NOT HAVE ANYTHING IN animalPicture COLUMN IN THE ROW1 OF DATABASE
        //set a default placeholder for row one,  in the animalPicture Column?  Ideally, I would like to set
        // @drawable/gallery.gif as the placeholder.
        String varValues = onePlace.get("animalPicture");
        if (varValues != null) {

            animalPicture.setImageURI(Uri.parse(onePlace.get("animalPicture")));

        } else {
            ImageView image = (ImageView) findViewById(R.id.PictureImageView);
            image.setImageResource(R.drawable.gallery);
        }

        Log.d(LOGCAT, "AFTER IMAGE URI");

    }
 }





