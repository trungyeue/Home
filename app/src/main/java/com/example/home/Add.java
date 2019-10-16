package com.example.home;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.home.mode.DaTaHome;
import com.example.home.mode.DemoAdapter;
import com.google.gson.JsonObject;
import com.loopj.android.http.AsyncHttpClient;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class Add extends AppCompatActivity {
    EditText godate, fromdate, name, aduls, children;
    Button cancel, addthem;
    EditText room1;
    Spinner spinner;
    ListView addlis;
    ArrayList<DaTaHome> arrayList;
    DemoAdapter adapter;
    String name1, room11, room22, godate1, fromdate1, aduls1, children1;
    private AsyncHttpClient client;
    String urlJson = "https://extranet.sophiapms.com/api/Room?companyId=4&fromDate=2019-11-01&toDate=2019-11-02";
    String urlJson1 ="http://extranet.sophiapms.com/api/Client/4";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.themdiglog);
        ImageView imageView = findViewById(R.id.imgadd);
        godate = findViewById(R.id.godate);
        cancel = findViewById(R.id.cancel);
        arrayList = new ArrayList<DaTaHome>();
        addlis = findViewById(R.id.listviewad);
        name = findViewById(R.id.name1);
        aduls = findViewById(R.id.adulst);
        client = new AsyncHttpClient();
        children = findViewById(R.id.children);
        spinner = findViewById(R.id.sproom2);
        GetJson(urlJson);
        GetJson1();
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        addthem = findViewById(R.id.addthem);
        room1 = findViewById(R.id.room1);
        addthem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name1 = name.getText().toString().trim();
                room11 = room1.getText().toString().trim();
                godate1 = godate.getText().toString().trim();
                fromdate1 = fromdate.getText().toString().trim();
                aduls1 = aduls.getText().toString().trim();
                children1 = children.getText().toString().trim();

            }
        });

        godate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Chonngay();
            }
        });
        fromdate = findViewById(R.id.fromdate);
        fromdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Chonngay();
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


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
//                                String add=object.getString("roomName");
//                                arrayList.add(add);
                                arrayList.add(new DaTaHome(
                                        object.getString("roomId"),
                                        object.getString("roomName"),
                                        object.getString("roomTypeId")

                                ));

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                      adapter=new DemoAdapter(Add.this,R.layout.iteamdemo,arrayList);
                        spinner.setAdapter(adapter);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Add.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue.add(jsonArrayRequest);

    }
    private void GetJson1() {


    }


}


//    public void Chonngay() {
//        final Calendar calendar = Calendar.getInstance();
//        int ngay = calendar.get(Calendar.DATE);
//        int thang = calendar.get(Calendar.MONTH);
//        int nam = calendar.get(Calendar.YEAR);
//        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
//            @Override
//            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
//                calendar.set(i, i1, i2);
//                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
//                fromdate.setText(simpleDateFormat.format(calendar.getTime()));
//                godate.setText(simpleDateFormat.format(calendar.getTime()));
//            }
//        }, nam, thang, ngay);
//        datePickerDialog.show();
//    }

//    private void DangKi(String url) {
//        RequestQueue requestQueue = Volley.newRequestQueue(this);
//        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
//                new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//                        if (response.trim().equals("success")) {
//                            Toast.makeText(Add.this, "Thêm  thành Công", Toast.LENGTH_SHORT).show();
////                            startActivity(new Intent(A.this, DulichActivity.class));
//
//                        } else
//                            if (name.getText().toString().equals("") && room1.getText().toString().equals("") && godate.getText().toString().equals("") && fromdate.getText().toString().equals("") && children.getText().toString().equals("") && aduls.getText().toString().equals("")) {
//                            Toast.makeText(Add.this, "Thêm thành công", Toast.LENGTH_SHORT).show();
//
//                        } else {
//                            Toast.makeText(Add.this, "Vui  lòng  nhập đày đủ thông tin", Toast.LENGTH_SHORT).show();
//
//                        }
//                    }
//                }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Toast.makeText(Add.this, error.toString(), Toast.LENGTH_SHORT).show();
//            }
//        }) {
//            @Override
//            protected Map<String, String> getParams() throws AuthFailureError {
//                Map<String, String> params = new HashMap<>();
//                params.put("guestName", name.getText().toString().trim());
//                params.put("roomName", room1.getText().toString().trim());
//
//                params.put("arrival", fromdate.getText().toString().trim());
//                params.put("departure", godate.getText().toString().trim());
//                params.put("child", children.getText().toString().trim());
//                params.put("adult", aduls.getText().toString().trim());
//
//                return params;
//            }
//        };
//        requestQueue.add(stringRequest);
//    }
//    private void GetJson(String urlJson) {
//        RequestQueue requestQueue = Volley.newRequestQueue(this);
//
//        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, urlJson, null,
//                new Response.Listener<JSONArray>() {
//                    @Override
//                    public void onResponse(JSONArray response) {
//                        Log.d("abc", "onResponse: "+response.length());
//                        for (int i = 0; i < response.length(); i++) {
//                            try {
//                                JSONObject object = response.getJSONObject(i);
//
//
//                            } catch (JSONException e) {
//                                e.printStackTrace();
//                            }
//                        }
////                        adapter = new DepartureAdapter(Departure.this, R.layout.iteamdeparture, arrayList);
////                        listView.setAdapter(adapter);
//                        Log.d("kt", "list size" + response.length());
//
//                    }
//                }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//
//            }
//        });
//        requestQueue.add(jsonArrayRequest);
//
//    }



