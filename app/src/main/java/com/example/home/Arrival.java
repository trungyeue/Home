package com.example.home;

import android.content.pm.ActivityInfo;
import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.home.mode.Arricala;
import com.example.home.mode.ArrivalAdapter;
import com.example.home.mode.DepartureAdapter;
import com.example.home.mode.Departurea;
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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Arrival extends AppCompatActivity {
    String urlJson = "https://extranet.sophiapms.com/api/ArrivalList?companyId=4&fromDate=2019-10-8";
    ArrivalAdapter adapter;
    ArrayList<Arricala> arrayList1;
    ListView listView;
    TextView checkin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arrival);
        Toolbar toolbar = findViewById(R.id.toolbar);
        checkin = findViewById(R.id.checkin);
        listView = findViewById(R.id.listchichin);
        GetJson(urlJson);
        setSupportActionBar(toolbar);
        arrayList1=new ArrayList<>();
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LOCKED);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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
                                checkin.setText("" + response.length() + "");
                                arrayList1.add(new Arricala(
                                        object.getString("guestName"),
                                        object.getString("roomType"),
                                        object.getString("arrival"),
                                        object.getString("departure"),
                                        object.getString("roomName"),
                                        object.getString("arrivalTime"),
                                        object.getString("source"),
                                        object.getString("resNo"),
                                        object.getInt("adult"),
                                        object.getInt("child"),
                                        object.getInt("nights"),
                                        object.getInt("roomCharge")


                                ));
                                Log.d("AA", "onResponse: "+arrayList1);

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        adapter = new ArrivalAdapter(Arrival.this, R.layout.iteamarrival, arrayList1);
                        listView.setAdapter(adapter);

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
