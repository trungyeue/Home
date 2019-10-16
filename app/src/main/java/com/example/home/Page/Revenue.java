package com.example.home.Page;

import android.content.Intent;
import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.home.mode.RevenueAdapter;
import com.example.home.mode.Revenuea;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.home.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Revenue extends AppCompatActivity {
    TextView txtdoanhthu;
    String urlJson ="https://extranet.sophiapms.com/api/MyRevenue?companyId=4&dateFrom=2019-9-1&dateTo=2019-9-30";
    ListView listView;
    ArrayList<Revenuea> revenueaArrayList;
    RevenueAdapter revenueAdapter;
int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_revenue);
        ImageView imageView=findViewById(R.id.next);
        ImageView imageView1=findViewById(R.id.pres);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               revenueaArrayList.get(position++);

            }
        });
        Toolbar toolbar = findViewById(R.id.toolbar);
        txtdoanhthu = findViewById(R.id.sodoanhthu);
        listView = findViewById(R.id.listviewReven);
        revenueaArrayList=new ArrayList<>();
        revenueAdapter=new RevenueAdapter(this,R.layout.iteamdoanhthu,revenueaArrayList);
        listView.setAdapter(revenueAdapter);
        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        txtdoanhthu.setText(id);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        GetJsonYouTube(urlJson);
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
                                revenueaArrayList.add(new Revenuea(
                                        object.getString("name"),
                                        object.getInt("roomCharge"),
                                        object.getInt("nights"),
                                        object.getInt("extraCharge")
                                ));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        Log.d("AA","size"+response.length());
                        revenueAdapter=new RevenueAdapter(Revenue.this,R.layout.iteamdoanhthu,revenueaArrayList);
                        listView.setAdapter(revenueAdapter);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(jsonArrayRequest);

    }




}
