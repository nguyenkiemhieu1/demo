package com.example.baith5.Account;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.baith5.R;
import com.google.gson.Gson;

import java.util.ArrayList;

public class bai3 extends AppCompatActivity {
    EditText edt_id, edt_pass;
    Button btn_add;
    TextView txt;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bai3);

        edt_id = (EditText) findViewById(R.id.edt_id);
        edt_pass = (EditText) findViewById(R.id.edt_pass);
        btn_add = (Button) findViewById(R.id.btn_add);
        txt = (TextView) findViewById(R.id.txt);

//        final ArrayList<Model_Acount> model_acounts = new ArrayList<>();
//        btn_add.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                model_acounts.add(new Model_Acount(Integer.parseInt(edt_id.getText().toString()), edt_pass.getText().toString()));
//                Gson gson = new Gson();
//                String text = gson.toJson(model_acounts);
//                txt.setText(text);
//            }
//        });

        Gson gson = new Gson();
        String name, career, phone;

        Employee1 e = new Employee1("Nguyen Hoang Diep", "Teacher", "0923848008");
// String s=gson.toJson(e);//1 object

        ArrayList<Employee1> arr = new ArrayList<>();
        arr.add(e);
        arr.add(new Employee1("Nguyen Thị Hải Năng", "Teacher", "0923848008"));
        arr.add(new Employee1("Nguyen Văn Hậu", "Teacher", "0923848008"));
        arr.add(new Employee1("Nguyen Minh Tiến", "Teacher", "0923848008"));

        String s = gson.toJson(arr);
        Toast.makeText(bai3.this, s.toString(), Toast.LENGTH_LONG).show();
    }
}
