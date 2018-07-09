package com.example.profraakici.realtime;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.androidquery.AQuery;
import com.androidquery.callback.AjaxStatus;

import org.json.JSONObject;

public class Main4Activity extends AppCompatActivity {
    String s;
    TextView txtb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        SharedPreferences sh = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        s = sh.getString("userphone", "defaultValue");

        AQuery aq = new AQuery(this);
        String url = "http://172.16.6.94:3000/select?phone=" + s;
        aq.ajax(url, JSONObject.class, this, "JsoncallBack");

        txtb = (TextView) findViewById(R.id.txtbalance);


    }

    public void JsoncallBack(String url, JSONObject json, AjaxStatus status) {

        if (json != null) {
            try {
                String msg = json.getString("msg");

                Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
                txtb.setText("Your Realtime Account Balance is: $:" + msg);


            } catch (Exception ex) {
            }
        } else {


        }
    }

}
