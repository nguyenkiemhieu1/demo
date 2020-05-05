package com.example.baith5.Student;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.baith5.R;
import com.example.baith5.XMLDOMParser;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Student extends AppCompatActivity {
    TextView txtv;
    Button btn;

    String datashow = "";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student);
        txtv = (TextView) findViewById(R.id.txtv);
        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                domParserXMLtoObject(view);
            }
        });
    }
    private String ReadFile() {
        String text = "";
        try {
            InputStream is = getAssets().open("Student.xml");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line;
            while((line=br.readLine())!=null)
            {
                text+=line;
            }

            br.close();
        } catch (Exception e) {
            String error = "";
            error = e.getMessage();
        }
        return text;
    }
    private ArrayList<Model_Student> parseEmployeesXML(){
        ArrayList<Model_Student> models = new ArrayList<Model_Student>();
        XMLDOMParser parser = new XMLDOMParser();
        try {
            Document document=parser.getDocument(ReadFile());
            NodeList nodeList=document.getElementsByTagName("student");
            for(int i=0;i<nodeList.getLength();i++){
                Element e=(Element)nodeList.item(i);
                String name = parser.getValue(e, "name");
                String year = parser.getValue(e, "year");
                String mark = parser.getValue(e, "mark");
                Model_Student product=new Model_Student(name, Integer.parseInt(year), Double.parseDouble(mark));
                models.add(product);
                Toast.makeText(Student.this,product.toString(),Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return models;

    }
    private void domParserXMLtoObject(View v) {
        datashow = "DL doc duoc:\n";
        for (Model_Student eob : parseEmployeesXML()) {
            datashow += eob.toString() + ";\n";
        }
        txtv.setText(datashow);

    }
}
