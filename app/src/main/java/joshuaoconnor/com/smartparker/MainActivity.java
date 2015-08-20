package joshuaoconnor.com.smartparker;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.app.ActionBar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
  This class will be the Main Activity, will be the first activity to run when the app is opened for
  the first time.
 */


public class MainActivity extends ActionBarActivity {



    //allows user to create a new activity_log of a parking entry
    private LogActivity mLogActivity = new LogActivity();
    //load action bar
    private ActionBar actionBar;

    DBController controller = new DBController(this);




//onCreate method called when activity is first created.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Load activity_main.xml as layout
        setContentView(R.layout.activity_main);
        actionBar = getActionBar();


    }





    public void newActivityOnClik(View V){

     HashMap<String, String> queryValues =  new  HashMap<String, String>();

     controller.insertAll(queryValues);



        // Create an Intent, which will be use for start LogActivity when clicked.
        Intent intent=new Intent(getApplicationContext(),LogActivity.class);
        startActivity(intent);
    }


    //newActivityOnClik is an id for a button onClickListener (specified in activity_main.xml under <Button)
    public void NewAnimal(View V){
        // Create an Intent, which will be use for start LogActivity when clicked.
        Intent intent=new Intent(getApplicationContext(),NewAnimal.class);
        startActivity(intent);
    }
    //newActivityOnClik is an id for a button onClickListener (specified in activity_main.xml under <Button)
    public void NewTitle(View V){
        // Create an Intent, which will be use for start LogActivity when clicked.
        Intent intent=new Intent(getApplicationContext(),NewTitle.class);
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
