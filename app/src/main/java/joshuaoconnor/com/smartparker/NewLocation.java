package joshuaoconnor.com.smartparker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.HashMap;

/**
 * Created by joshuaoconnor on 12/6/14.
 */



public class NewLocation extends Activity {
    EditText animalLocation;
    DBController controller = new DBController(this);

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_new_location);
        animalLocation = (EditText) findViewById(R.id.animalLocation1);
    }
    public void addNewLocation(View view) {
        HashMap<String, String> queryValues =  new  HashMap<String, String>();
        queryValues.put("animalLocation", animalLocation.getText().toString());
        controller.updateLocation(queryValues);
        this.callHomeActivity(view);
    }
    public void callHomeActivity(View view) {
        Intent objIntent = new Intent(getApplicationContext(), LogActivity.class);
        startActivity(objIntent);
    }




}
