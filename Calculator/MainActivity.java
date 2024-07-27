package com.example.shivacalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button ad,mul,sb,dv,per,c,pow;
    TextView tv1,tv2;
    EditText et1,et2;

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
        ad = (Button) findViewById(R.id.ad);
        mul = (Button) findViewById(R.id.mul);
        sb = (Button) findViewById(R.id.sb);
        dv = (Button) findViewById(R.id.dv);
        per = (Button) findViewById(R.id.per);
        c = (Button) findViewById(R.id.c);
        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
        ad.setOnClickListener(this);
        mul.setOnClickListener(this);
        c.setOnClickListener(this);
        dv.setOnClickListener(this);
        per.setOnClickListener(this);
        sb.setOnClickListener(this);
        pow.setOnClickListener(this);
    }
        @Override
        public void onClick (View v)
        {
            int num1, num2, res = 0;
            String s1 = et1.getText().toString();
            String s2 = et2.getText().toString();
            char op = ' ';
            if (s1.isEmpty() || s2.isEmpty()) {
                return;
            }
            num1 = Integer.parseInt(s1);
            et1.requestFocus();
            num2 = Integer.parseInt(s2);
            et2.requestFocus();
            if (v.getId() == R.id.ad) {
                op = '+';
                res = num1 + num2;
            } else if (v.getId() == R.id.mul) {
                op = 'X';
                res = num1 * num2;
            } else if (v.getId() == R.id.dv) {
                op = '/';
                res = num1 / num2;
            } else if (v.getId() == R.id.sb) {
                op = '-';
                res = num1 - num2;
            } else if (v.getId() == R.id.per) {
                op = '%';
                res = num1 % num2;
            } else if (v.getId() == R.id.pow) {
                op = '^';
                res = (int) Math.pow(num1, num2);
            } else{
                tv1.setText("");
                tv2.setText("");
                et1.setText("");
                et2.setText("");
            }
            tv1.setText(op);
            tv2.setText(res);
    }
}
