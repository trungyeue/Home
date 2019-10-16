package com.example.home;

import android.content.pm.ActivityInfo;
import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.home.mode.DepartureAdapter;
import com.example.home.mode.Departurea;
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
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Departure extends AppCompatActivity {
    String urlJson = "https://extranet.sophiapms.com/api/DepartureList?companyId=4&fromDate=2019-10-07";
    DepartureAdapter adapter;
    ArrayList<Departurea> arrayList;
    ListView listView;
    TextView checkout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_departure);
        Toolbar toolbar = findViewById(R.id.toolbar);
        listView=findViewById(R.id.listviewcheck);
        checkout=findViewById(R.id.checkout);
        arrayList=new ArrayList<>();
//        adapter=new DepartureAdapter(this,R.layout.iteamdeparture,arrayList);
//        listView.setAdapter(adapter);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        GetJson(urlJson);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LOCKED);
    }
    private void GetJson(String urlJson) {
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, urlJson, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        for (int i = 0; i < response.length(); i++) {
                            try {
                                JSONObject object = response.getJSONObject(i);
                                checkout.setText("( " + response.length()+ " )");
                                arrayList.add(new Departurea(
                                        object.getString("guestName"),
                                        object.getString("roomType"),
                                        object.getString("arrival"),
                                        object.getString("departure"),
                                        object.getString("roomName"),
                                        object.getString("departureTime"),
                                        object.getString("source"),
                                        object.getString("folioNo"),
                                        object.getInt("adult"),
                                        object.getInt("child"),
                                        object.getInt("nights"),
                                        object.getInt("roomCharge")


                                ));


                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        adapter = new DepartureAdapter(Departure.this, R.layout.iteamdeparture, arrayList);
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
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                try {
                    adapter.filter(newText.trim());
                }catch (Exception e){
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
