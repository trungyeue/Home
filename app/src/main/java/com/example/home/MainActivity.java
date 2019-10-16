package com.example.home;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.home.Page.PublicRoom;
import com.example.home.Page.Revenue;
import com.example.home.mode.InHomeAdapter;
import com.example.home.mode.InHomea;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity  {
    String urlJson = "https://extranet.sophiapms.com/api/InHouse?companyId=4&fromDate=2019-10-07";
    TextView txthouse, doanhthu, txtarrival, departure1,booking1;
    ImageView imageView;
    String url = "https://extranet.sophiapms.com/api/ArrivalList?companyId=4&fromDate=2019-10-8";
    String getUrl = "https://extranet.sophiapms.com/api/DepartureList?companyId=4&fromDate=2019-10-07";
    ArrayList<InHomea> inHomess;
    InHomeAdapter adapter;
    private Activity mActivity;

    SwipeRefreshLayout mSwipeRefreshLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txthouse = findViewById(R.id.inhometx);
        doanhthu = findViewById(R.id.doanhthu);
        imageView = findViewById(R.id.imageView);
        departure1 = findViewById(R.id.departure1);
        booking1=findViewById(R.id.booking1);
        mActivity = MainActivity.this;
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LOCKED);
        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeRe);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Toast.makeText(MainActivity.this, "Refresh", Toast.LENGTH_SHORT).show();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        restartActivity(mActivity);
                        mSwipeRefreshLayout.setRefreshing(false);
                    }
                }, 2000);
            }
        });

        txtarrival = findViewById(R.id.txtArrival);
//        final ProgressBar simpleProgressBar = (ProgressBar) findViewById(R.id.simpleProgressBar); // initiate the progress bar
        GetJson(url);
        GetJso(getUrl);
//        imageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                simpleProgressBar.setVisibility(View.VISIBLE);
//                Intent intent = getIntent();
//                overridePendingTransition(300, 300);
//                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
//                simpleProgressBar.setMax(100); // 100 maximum value for the progress value
//                simpleProgressBar.setProgress(50);
//                overridePendingTransition(150, 150);
//
//                imageView.setVisibility(View.INVISIBLE);
//                finish();
//                startActivity(intent);
//
//            }
//
//        });

        GetJsonYouTube(urlJson);


    }


    @Override
    protected void onResume() {
        super.onResume();
    }

    public static void restartActivity(Activity activity) {
        if (Build.VERSION.SDK_INT >= 11) {
            activity.recreate();
        } else {
            activity.finish();
            activity.startActivity(activity.getIntent());
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    private void GetJsonYouTube(String urlJson) {

        RequestQueue requestQueue = Volley.newRequestQueue(this);

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, urlJson, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        int sum = 0;
                        for (int i = 0; i < response.length(); i++) {
                            try {
                                JSONObject object = response.getJSONObject(i);
                                sum += object.getInt("roomCharge");
                                txthouse.setText("" + response.length() + "");
                                booking1.setText(""+response.length());
                                String regex = "((\\\\$?(([0-9]{0,1})?\\\\.[0-9]{1,2}))|(\\\\$?([1-9]{1}[0-9]{0,2}([,][0-9]{3})*)(\\\\.[0-9]{1,2})?))\n";

                                doanhthu.setText(sum + " đ ");
//


                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }

        });
        requestQueue.add(jsonArrayRequest);

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
                                txtarrival.setText("" + response.length());


                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(jsonArrayRequest);

    }

    private void GetJso(String urlJson) {

        RequestQueue requestQueue = Volley.newRequestQueue(this);

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, urlJson, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        for (int i = 0; i < response.length(); i++) {
                            try {
                                JSONObject object = response.getJSONObject(i);
                                departure1.setText("" + response.length() + "");

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(jsonArrayRequest);

    }
//    @Override
//    protected void onStart() {
//        super.onStart();
//        GetJsonYouTube(urlJson);
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        GetJsonYouTube(urlJson);
//    }

    public void InHouse(View view) {
        startActivity(new Intent(MainActivity.this, InHouse.class));
    }

    public void Arrival(View view) {
        startActivity(new Intent(MainActivity.this, Arrival.class));
    }

    public void Booking(View view) {
        startActivity(new Intent(MainActivity.this, Booking.class));
    }

    public void Departure(View view) {
        startActivity(new Intent(MainActivity.this, Departure.class));
    }

    public void Revenue(View view) {
        Intent intent = new Intent(getBaseContext(), Revenue.class);
        intent.putExtra("id", doanhthu.getText().toString());
        startActivity(intent);
    }

    public void PublicRoom(View view) {
        startActivity(new Intent(MainActivity.this, PublicRoom.class));
    }


    public void logout(View view) {
        Toast.makeText(MainActivity.this, "Đăng kí", Toast.LENGTH_SHORT).show();
    }

}
