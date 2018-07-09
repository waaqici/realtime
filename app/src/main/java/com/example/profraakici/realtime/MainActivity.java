package com.example.profraakici.realtime;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.androidquery.AQuery;
import com.androidquery.callback.AjaxStatus;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    EditText tell;
    EditText pass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tell = (EditText) findViewById(R.id.phone);
        pass = (EditText) findViewById(R.id.pass);


    }

    public void JsoncallBack(String url, JSONObject json, AjaxStatus status) {

        if (json != null) {
            try {
                String msg = json.getString("msg");

                Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
                if (msg.equals("Thanks Login Info is Correct")) {


                    Intent i = new Intent(getApplicationContext(), Main2Activity.class);

                    startActivity(i);
                }

            } catch (Exception ex) {
            }
        } else {


        }
    }

    public void btnlogin(View view) {
        //Toast.makeText(getApplicationContext(),pass.getText(),Toast.LENGTH_SHORT).show();

        AQuery aq = new AQuery(this);
        String url = "http://172.16.6.94:3000/users?phone=" + tell.getText() + "&pass=" + pass.getText();
        aq.ajax(url, JSONObject.class, this, "JsoncallBack");
        //SharedPreferences pref  = getSharedPreferences("user", MODE_PRIVATE);

        SharedPreferences sh = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor edito = sh.edit();
        edito.putString("userphone", tell.getText().toString());
        edito.commit();


    }

    public void register(View V) {

        Intent i = new Intent(getBaseContext(), Main3Activity.class);
        startActivity(i);

    }

}
