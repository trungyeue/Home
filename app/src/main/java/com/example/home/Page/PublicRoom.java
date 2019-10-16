package com.example.home.Page;

import android.app.DatePickerDialog;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import com.example.home.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class PublicRoom extends AppCompatActivity {
EditText date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_public_room);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        date=findViewById(R.id.date);
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Chonngay();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void Chonngay() {
        final Calendar calendar=Calendar.getInstance();
        int ngay=calendar.get(Calendar.DATE);
        int thang=calendar.get(Calendar.MONTH);
        int nam=calendar.get(Calendar.YEAR);
        DatePickerDialog datePickerDialog=new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                calendar.set(i,i1,i2);
                SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd/MM/yyyy");
                date.setText(simpleDateFormat.format(calendar.getTime()));
            }
        },nam,thang,ngay);
        datePickerDialog.show();
    }
}
