package com.example.currencyconverter;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText et1;
    TextView tv2;
    Spinner spn;
    Button b1;
    int pos=0;
    double inp;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.tv1), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        et1 = (EditText) findViewById(R.id.et1);
        tv2 = (TextView) findViewById(R.id.tv2);
        spn = (Spinner) findViewById(R.id.spn);
        b1 = (Button) findViewById(R.id.b1);
        List<String> Currency = new ArrayList<String>();
        Currency.add("Dollar");
        Currency.add("Euro");
        Currency.add("Pounds");
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,Currency);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spn.setAdapter(aa);
        spn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                pos = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(et1.getText().toString().trim().length()>0){
                    inp = Double.parseDouble(et1.getText().toString());
                    double ans = 0;
                    if(pos==0){
                        ans = inp*0.015;
                        tv2.setText("INR to USD : "+ans);
                    }else if(pos==1){
                        ans = inp*0.013;
                        tv2.setText("INR to EURO : "+ans);
                    }else if(pos==2){
                        ans = inp*0.012;
                        tv2.setText("INR to POND : "+ans);
                    }
                }else{
                    et1.setError("Enter Value");
                }
            }
        });
    }
}
