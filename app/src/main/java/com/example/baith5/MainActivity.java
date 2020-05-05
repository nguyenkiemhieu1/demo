package com.example.baith5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.baith5.Account.Account;
import com.example.baith5.Account.bai3;
import com.example.baith5.Product.Product;
import com.example.baith5.Student.Student;

public class MainActivity extends AppCompatActivity {
    Button btn_id, btn_product, btn_student, btn_bai3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ax();
        btn_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Account.class);
                startActivity(intent);
            }
        });
        btn_product.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Product.class);
                startActivity(intent);
            }
        });
        btn_student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Student.class);
                startActivity(intent);
            }
        });
        btn_bai3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Demo.class);
                startActivity(intent);
            }
        });
    }

    private void ax() {
        btn_id = (Button)findViewById(R.id.btn_id);
        btn_product = (Button)findViewById(R.id.btn_product);
        btn_student = (Button) findViewById(R.id.btn_student);
        btn_bai3 = (Button) findViewById(R.id.btn_bai3);
    }
}
