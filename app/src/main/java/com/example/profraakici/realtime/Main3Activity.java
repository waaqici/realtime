package com.example.profraakici.realtime;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.androidquery.AQuery;
import com.androidquery.callback.AjaxStatus;

import org.json.JSONObject;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
    }


    public void JsoncallBack(String url, JSONObject json, AjaxStatus status) {

        if (json != null) {
            try {
                String msg = json.getString("msg");

                Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
                if (msg.equals("Your Account has Been Registered")) {

                    Intent i = new Intent(getBaseContext(), MainActivity.class);
                    startActivity(i);
                }

            } catch (Exception ex) {
            }
        } else {


        }
    }

    public void btnlogin(View V) {

        Intent i = new Intent(getBaseContext(), MainActivity.class);
        startActivity(i);
    }

    public void register(View view) {
        EditText name = (EditText) findViewById(R.id.name);
        EditText tell = (EditText) findViewById(R.id.phone);
        EditText pass = (EditText) findViewById(R.id.pass);


        AQuery aq = new AQuery(this);
        String url = "http://172.16.6.94:3000/register?name=" + name.getText() + "&phone=" + tell.getText() + "&pass=" + pass.getText();
        aq.ajax(url, JSONObject.class, this, "JsoncallBack");
    }
}
