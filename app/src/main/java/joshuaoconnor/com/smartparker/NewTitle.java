
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


public class NewTitle extends Activity {
    EditText animalTitle;
    DBController controller = new DBController(this);

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_new_title);
        animalTitle = (EditText) findViewById(R.id.animalTitle);



    }
    public void addNewTitle(View view) {
        HashMap<String, String> queryValues =  new  HashMap<String, String>();
        queryValues.put("animalTitle", animalTitle.getText().toString());
        controller.updateTitle(queryValues);
        this.callHomeActivity(view);
    }
    public void callHomeActivity(View view) {
        Intent objIntent = new Intent(getApplicationContext(), LogActivity.class);
        startActivity(objIntent);
    }




}
