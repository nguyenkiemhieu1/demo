package com.example.baith5;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.baith5.Account.Employee1;
import com.google.gson.Gson;

import java.util.ArrayList;

public class Demo extends AppCompatActivity {
    EditText edtname, edtcareer, edtphone;
    TextView txt;
    Button button;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo);
        edtname = (EditText) findViewById(R.id.edtname);
        edtcareer = (EditText) findViewById(R.id.edtcareer);
        edtphone = (EditText) findViewById(R.id.edtphone);
        txt = (TextView) findViewById(R.id.tvkq);
        button = (Button) findViewById(R.id.btn2json) ;

        String name=edtname.getText().toString();
        String career=edtname.getText().toString();
        String phone=edtname.getText().toString();
        String s="";
        Gson gson = new Gson();
        if(name.length()==0 && career.length()==0 && phone.length()==0) {
            Employee1 e = new Employee1("Nguyen Hoang Diep", "Teacher", "0923848008");
// String s=gson.toJson(e);//1 object
            ArrayList<Employee1> arr = new ArrayList<>();
            arr.add(e);
            arr.add(new Employee1("Nguyen Thị Hải Năng", "Teacher", "0923848008"));
            arr.add(new Employee1("Nguyen Văn Hậu", "Teacher", "0923848008"));
            arr.add(new Employee1("Nguyen Minh Tiến", "Teacher", "0923848008"));

            s = gson.toJson(arr);
            Toast.makeText(Demo.this, s.toString(), Toast.LENGTH_LONG).show();
        }
        else {
            Employee1 e = new Employee1(name,career,phone);
            s = gson.toJson(e);
            Toast.makeText(Demo.this, s.toString(), Toast.LENGTH_LONG).show();
        }
        txt.setText(s);

    }
}
