package com.example.home.mode;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.TextView;

import com.example.home.R;

import java.util.Date;

import static com.example.home.mode.InHomeAdapter.arrival;
import static com.example.home.mode.InHomeAdapter.balance;
import static com.example.home.mode.InHomeAdapter.departure1;
import static com.example.home.mode.InHomeAdapter.folioNo1;
import static com.example.home.mode.InHomeAdapter.roomName1;
import static com.example.home.mode.InHomeAdapter.roomType1;
import static com.example.home.mode.InHomeAdapter.totcharge1;

public class Chitiet extends AppCompatActivity {
    TextView txt1, txt2, txt3, txt4, txt5, booking, totcharge,balance2,arriav2,txt8,txt6,txt7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chitiet);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        totcharge = findViewById(R.id.totalcharge);
        booking = findViewById(R.id.bookingh);
        balance2=findViewById(R.id.balance2);
        arriav2=findViewById(R.id.arrival2);
        txt5 = findViewById(R.id.balance);
        txt1 = findViewById(R.id.folioNo2);
        txt2 = findViewById(R.id.arrival2);
        txt3 = findViewById(R.id.departure2);
        txt4 = findViewById(R.id.roomType2);
        txt6=findViewById(R.id.totalcharge2);
        txt7=findViewById(R.id.roomType3);
        txt8=findViewById(R.id.roomType4);
        txt1.setText("Folio No : " + folioNo1);
        txt2.setText(arrival);
        txt3.setText(departure1);
        txt4.setText(roomType1);
        txt5.setText("" + balance);
        txt6.setText(""+totcharge1);
        txt7.setText(""+roomName1);
        txt8.setText(""+roomName1);
        totcharge.setText("" + totcharge1);
        balance2.setText(""+balance);
        arriav2.setText(""+arrival);
        Date date = new Date();
        java.text.DateFormat dateFormat = android.text.format.DateFormat.getDateFormat(this);
        txt3.setText(dateFormat.format(date));
        txt2.setText(dateFormat.format(date));
        Intent intent = getIntent();
        String id = intent.getStringExtra("idd");
        booking.setText(id);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
