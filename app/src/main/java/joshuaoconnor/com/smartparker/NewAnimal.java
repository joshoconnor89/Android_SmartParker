package joshuaoconnor.com.smartparker;

/**
 * Created by joshuaoconnor on 12/5/14.
 */

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
//this was functional on test so I didnt rename the class and the values.  This class' purpose is
//to add a NewNote, not a NewAnimal (There is nothing about my app that has anything to do with animals)



public class NewAnimal extends Activity{
    EditText animalName;
    DBController controller = new DBController(this);

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_new_animal);
        animalName = (EditText) findViewById(R.id.animalName);
    }
    public void addNewAnimal(View view) {
        HashMap<String, String> queryValues =  new  HashMap<String, String>();
        queryValues.put("animalName", animalName.getText().toString());
        controller.updateNotes(queryValues);
        this.callHomeActivity(view);
    }
    public void callHomeActivity(View view) {
        Intent objIntent = new Intent(getApplicationContext(), LogActivity.class);
        startActivity(objIntent);
    }




}
