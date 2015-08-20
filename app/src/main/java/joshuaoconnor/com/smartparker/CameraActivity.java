package joshuaoconnor.com.smartparker;

import android.app.ActionBar;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


import java.io.File;
import java.util.HashMap;

/**
  This activity will bring up the default camera so the user can take a picture of their car, the location,
  nearby landmarks, parking signs, etc.  After the picture is taken, it will be stored on the phone's SD card.
 */


//Bring up the camera so that the user can take a picture
public class CameraActivity extends ActionBarActivity {
    //know content request
    EditText animalName;
    DBController controller = new DBController(this);
    private static final int CONTENT_REQUEST = 1337;
    private File output = null;
    static int TAKE_PICTURE = 1;
    public String picName;
    Uri outputFileUri;

    final Context context = this;
    public String lastId;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //i is the variable that holds our intent for Media Store
        Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);


        long seconds = System.currentTimeMillis() / 1000;
        String pic = Long.toString(seconds);
        picName = pic + ".jpg";
        File file = new File(Environment.getExternalStorageDirectory(), picName);
        outputFileUri = Uri.fromFile(file);
        i.putExtra(MediaStore.EXTRA_OUTPUT, outputFileUri);

        Log.v("MYPIC", outputFileUri.toString());

        startActivityForResult(i, CONTENT_REQUEST);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent data) {
        if (requestCode == CONTENT_REQUEST) {
            if (resultCode == RESULT_OK) {
                Toast.makeText(this, outputFileUri.toString(), Toast.LENGTH_LONG).show();
                //controller.InsertData(picName,  outputFileUri.toString());
                HashMap<String, String> queryValues = new HashMap<String, String>();
                queryValues.put("animalPicture", outputFileUri.toString());
                controller.updatePicture(queryValues);

                finish();
            }
        }
        Intent objIntent = new Intent(getApplicationContext(), LogActivity.class);
        startActivity(objIntent);

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

