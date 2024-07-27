package com.example.w6;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText name, phone;
    TextView tv;
    Button submit;
    DBHelper dbh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        name = (EditText) findViewById(R.id.name);
        phone = (EditText) findViewById(R.id.phone);
        tv = (TextView) findViewById(R.id.tv);
        submit = (Button) findViewById(R.id.submit);
        dbh = new DBHelper(this);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Execution started", Toast.LENGTH_SHORT).show();
                dbh.insertdata(name.getText().toString(), phone.getText().toString());
                Toast.makeText(MainActivity.this,"Data Inserted Successfully", Toast.LENGTH_SHORT).show();
                displayData();
            }
        });
    }
    private void displayData(){
        Cursor res = dbh.getAllData();
        if(res.getCount()==0){
            tv.setText("No Contacts has entered. Add contacts");
            return;
        }
        StringBuilder buffer = new StringBuilder();
        while(res.moveToNext()){
            buffer.append("Name : ").append(res.getString(0)).append("\n");
            buffer.append("Phone : ").append(res.getString(1)).append("\n\n");
        }
        tv.setText(buffer.toString());
    }
}
