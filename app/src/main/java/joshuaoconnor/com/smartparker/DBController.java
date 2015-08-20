package joshuaoconnor.com.smartparker;

/**
 * Created by joshuaoconnor on 12/5/14.
 */

import java.util.ArrayList;
import java.util.HashMap;

import android.util.Log;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.TextView;

public class DBController  extends SQLiteOpenHelper {
    private static final String LOGCAT = null;

    public DBController(Context applicationcontext) {
        super(applicationcontext, "androidsqlite.db", null, 8);
        Log.d(LOGCAT,"Created");
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        String query;
        query = "CREATE TABLE animals ( animalId INTEGER PRIMARY KEY autoincrement, animalName TEXT, animalTitle TEXT, animalPicture TEXT, animalLocation TEXT, animalLat TEXT, animalLong TEXT)";
        database.execSQL(query);
        Log.d(LOGCAT,"database Created");
    }


    @Override
    public void onUpgrade(SQLiteDatabase database, int version_old, int current_version) {
        String query;
        query = "DROP TABLE IF EXISTS animals";
        database.execSQL(query);
        onCreate(database);
    }


    public void NewLog(HashMap<String, Integer> queryValues) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("animalId", queryValues.get(1));

        database.insert("animals", null, values);
        Log.v("PicTaken",values.toString());

        database.close();
    }


    public void insertAll(HashMap<String, String> queryValues) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("animalPicture", queryValues.get("animalPicture"));
        values.put("animalName", queryValues.get("animalName"));
        values.put("animalLocation", queryValues.get("animalLocation"));
        values.put("animalTitle", queryValues.get("animalTitle"));
        database.insert("animals", null, values);
        Log.v("PicTaken",values.toString());

        database.close();
    }

    public int updateNotes(HashMap<String, String> queryValues) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("animalName", queryValues.get("animalName"));



        //UPDATING THE TABLE, ONLY WHERE THE ID IS 1
        return database.update("animals", values, "animalId" + "="+1, null);

    }

    public int updateTitle(HashMap<String, String> queryValues) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("animalTitle", queryValues.get("animalTitle"));


        //UPDATING THE TABLE, ONLY WHERE THE ID IS 1
        return database.update("animals", values, "animalId" + "="+1, null);

    }


    public int updateLocation(HashMap<String, String> queryValues) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("animalLocation", queryValues.get("animalLocation"));

        //UPDATING THE TABLE, ONLY WHERE THE ID IS 1
        return database.update("animals", values, "animalId" + "="+1, null);

    }

    public int updateLatLng(HashMap<String, String> queryValues) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("animalLat", queryValues.get("animalLat"));
        values.put("animalLong", queryValues.get("animalLong"));

        //UPDATING THE TABLE, ONLY WHERE THE ID IS 1
        return database.update("animals", values, "animalId" + "="+1, null);

    }

    public int updatePicture(HashMap<String, String> queryValues) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("animalPicture", queryValues.get("animalPicture"));

        //UPDATING THE TABLE, ONLY WHERE THE ID IS 1
        return database.update("animals", values, "animalId" + "="+1, null);
        //String updateQuery = "Update  words set txtWord='"+word+"' where txtWord='"+ oldWord +"'";
        //Log.d(LOGCAT,updateQuery);
        //database.rawQuery(updateQuery, null);
        //return database.update("words", values, "txtWord  = ?", new String[] { word });
    }

    public void insertPicture(HashMap<String, String> queryValues) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("animalPicture", queryValues.get("animalPicture"));
        database.insert("animals", null, values);
        Log.v("PicTaken",values.toString());

        database.close();
    }

    public void insertAnimal(HashMap<String, String> queryValues) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("animalName", queryValues.get("animalName"));

        database.insert("animals", null, values);
        database.close();
    }

    public void insertLocation(HashMap<String, String> queryValues) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("animalLatitude", queryValues.get("animalLatitude"));
        values.put("animalLongitude", queryValues.get("animalLongitude"));

        database.insert("animals", null, values);
        database.close();

    }




    public void insertLongitude(HashMap<String, String> queryValues) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("animalLong", queryValues.get("animalLong"));
        database.insert("animals", null, values);
        database.close();

    }




    public void insertTitle(HashMap<String, String> queryValues) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("animalTitle", queryValues.get("animalTitle"));
        database.insert("animals", null, values);
        database.close();

    }

    public int updateAnimal(HashMap<String, String> queryValues) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("animalName", queryValues.get("animalName"));
        values.put("animalLocation", queryValues.get("animalLocation"));
        values.put("animalTitle", queryValues.get("animalTitle"));
        values.put("animalPicture", queryValues.get("animalPicture"));
        return database.update("animals", values, "animalId" + " = ?", new String[] { queryValues.get("animalId") });
        //String updateQuery = "Update  words set txtWord='"+word+"' where txtWord='"+ oldWord +"'";
        //Log.d(LOGCAT,updateQuery);
        //database.rawQuery(updateQuery, null);
        //return database.update("words", values, "txtWord  = ?", new String[] { word });
    }

    public void deleteAnimal(String id) {
        Log.d(LOGCAT,"delete");
        SQLiteDatabase database = this.getWritableDatabase();
        String deleteQuery = "DELETE FROM  animals where animalId='"+ id +"'";
        Log.d("query",deleteQuery);
        database.execSQL(deleteQuery);
    }
    //hashmap is a list
    public ArrayList<HashMap<String, String>> getAllAnimals() {
        ArrayList<HashMap<String, String>> wordList;
        wordList = new ArrayList<HashMap<String, String>>();
        String selectQuery = "SELECT  * FROM animals";
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                HashMap<String, String> map = new HashMap<String, String>();
                map.put("animalId", cursor.getString(0));
                map.put("animalName", cursor.getString(1));
                wordList.add(map);
            } while (cursor.moveToNext());
        }

        // return contact list
        return wordList;
    }


    public HashMap<String, String> getTitleInfo(String id) {
        HashMap<String, String> textView = new HashMap<String, String>();
        SQLiteDatabase database = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM animals where animalId='"+id+"'";
        Cursor cursor = database.rawQuery(selectQuery, null);

            if (cursor.moveToFirst()) {
            do {
                //HashMap<String, String> map = new HashMap<String, String>();
                textView.put("animalTitle", cursor.getString(2));
                //wordList.add(map);
            } while (cursor.moveToNext());
        }
        return textView;
    }


    public HashMap<String, String> getLatestPhoto(String id) {
        HashMap<String, String> wordList = new HashMap<String, String>();
        SQLiteDatabase database = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM animals where animalId="+id+" desc limit 1";
        Log.d(LOGCAT, "Debug -- sql query: " + selectQuery);
        Cursor cursor = database.rawQuery(selectQuery, null);
        Log.d(LOGCAT, "Debug -- query done");

        if (cursor.moveToFirst()) {
            do {
                //HashMap<String, String> map = new HashMap<String, String>();
                wordList.put("animalPicture", cursor.getString(3));

                //wordList.add(map);
            } while (cursor.moveToNext());
        }
        return wordList;
    }


    public HashMap<String, String> getLatLng(Integer id) {
        HashMap<String, String> wordList = new HashMap<String, String>();
        SQLiteDatabase database = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM animals where animalId="+id+" desc limit 1";
        Log.d(LOGCAT, "Debug -- sql query: " + selectQuery);
        Cursor cursor = database.rawQuery(selectQuery, null);
        Log.d(LOGCAT, "Debug -- query done");

        if (cursor.moveToFirst()) {
            do {
                //HashMap<String, String> map = new HashMap<String, String>();
                wordList.put("animalLat", cursor.getString(5));
                wordList.put("animalLong", cursor.getString(6));

                //wordList.add(map);
            } while (cursor.moveToNext());
        }
        return wordList;
    }




    public HashMap<String, String> getAnimalInfo(Integer id) {
        HashMap<String, String> wordList = new HashMap<String, String>();
        SQLiteDatabase database = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM animals where animalId="+id+"";
        Cursor cursor = database.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                //HashMap<String, String> map = new HashMap<String, String>();
                wordList.put("animalName", cursor.getString(1));
                Log.d(LOGCAT, "debug " + "animalName" + ": " + cursor.getString(0));
                wordList.put("animalTitle", cursor.getString(2));

                wordList.put("animalPicture", cursor.getString(3));
                wordList.put("animalLocation", cursor.getString(4));
                //wordList.add(map);
            } while (cursor.moveToNext());
        }
        return wordList;
    }
}
