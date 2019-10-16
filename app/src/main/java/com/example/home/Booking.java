package com.example.home;

import android.content.pm.ActivityInfo;
import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.home.mode.InHomeAdapter;
import com.example.home.mode.InHomea;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Booking  extends AppCompatActivity {
    String urlJson = "https://extranet.sophiapms.com/api/InHouse?companyId=4&fromDate=2019-10-07";
    ListView listView;
    ArrayList<InHomea> inHomess=new ArrayList<>();
    InHomeAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LOCKED);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listView = findViewById(R.id.listview1);
        GetJsonYouTube(urlJson);
//        for (int i = 0; i < animalNameList.length; i++) {
//            InHomea animalNames = new InHomea(animalNameList[i]);
//            // Binds all strings into an array
//            inHomess.add(animalNames);
//        }
    }
    private void GetJsonYouTube(String urlJson) {
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, urlJson, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        for (int i = 0; i < response.length(); i++) {
                            try {
                                JSONObject object = response.getJSONObject(i);

                                inHomess.add(new InHomea(
                                        object.getString("roomType"),
                                        object.getString("roomName"),
                                        object.getString("guestName"),
                                        object.getInt("roomCharge"),
                                        object.getString("arrival"),
                                        object.getString("departure"),
                                        object.getInt("nights"),
                                        object.getString("folioNo"),
                                        object.getString("source"),
                                        object.getInt("child"),
                                        object.getInt("adult"),
                                        object.getInt("balance")


                                ));


                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        adapter = new InHomeAdapter(Booking.this, R.layout.iteam, inHomess,listView);
                        listView.setAdapter(adapter);
                        Log.d("kt", "list size" + response.length());

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(jsonArrayRequest);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        SearchView searchView= (SearchView) menu.findItem(R.id.action_settings).getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(Booking.this, query, Toast.LENGTH_SHORT).show();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                try {
                    adapter.filter(newText.trim());
                }catch (Exception e){
                    Toast.makeText(Booking.this, e.toString(), Toast.LENGTH_SHORT).show();
                    Log.e("AA",e.getMessage());
                }
                return false;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



}
