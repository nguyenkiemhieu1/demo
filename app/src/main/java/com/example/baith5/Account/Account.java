package com.example.baith5.Account;

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

public class Account extends AppCompatActivity {
    TextView txtv;
    Button btn;

    String datashow = "";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account);
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
            InputStream is = getAssets().open("account.xml");
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
    private ArrayList<Model_Acount> parseEmployeesXML(){
        ArrayList<Model_Acount> models = new ArrayList<Model_Acount>();
        XMLDOMParser parser = new XMLDOMParser();
        try {
            Document document=parser.getDocument(ReadFile());
            NodeList nodeList=document.getElementsByTagName("account");
            for(int i=0;i<nodeList.getLength();i++){
                Element e=(Element)nodeList.item(i);
                String id = parser.getValue(e, "id");
                String pass = parser.getValue(e, "pass");
                Model_Acount account=new Model_Acount(Integer.valueOf(id), pass);
                models.add(account);
                Toast.makeText(Account.this,account.toString(),Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return models;

    }
    private void domParserXMLtoObject(View v) {
        datashow = "DL doc duoc:\n";
        for (Model_Acount eob : parseEmployeesXML()) {
            datashow += eob.toString() + ";\n";
        }
        txtv.setText(datashow);

    }

}
