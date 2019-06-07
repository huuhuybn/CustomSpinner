package com.dotplays.customspinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatSpinner;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import java.security.spec.PSSParameterSpec;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private AppCompatSpinner spPart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spPart = findViewById(R.id.spPart);


        final List<Part> partList = new ArrayList<>();


        // tao ra 1 doi tuong empty de hien thi mac dinh cho spinner

        Part empty = new Part();
        empty.id = "-1";
        empty.name = "Select One";
        partList.add(empty);


        for (int i = 0; i < 20; i++) {
            Part part = new Part();
            part.id = String.valueOf(i);
            part.name = "Huy".concat(String.valueOf(i));

            partList.add(part);

        }


        MySpinnerAdapter mySpinnerAdapter = new MySpinnerAdapter(this, partList);

        spPart.setAdapter(mySpinnerAdapter);


        // su kien chon 1 hang trong spinner
        spPart.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            // nguoi dung click va chon 1 hang trong danh sach
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                Part part = partList.get(position);
                Toast.makeText(MainActivity.this, part.name, Toast.LENGTH_SHORT).show();

            }


            // neu nguoi dung mo spinner ma ko chon gi
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

    public void showSelectedItem(View view) {

        Part part = (Part) spPart.getSelectedItem();

        Toast.makeText(this, part.name, Toast.LENGTH_SHORT).show();


    }
}
