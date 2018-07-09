package com.example.profraakici.realtime;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.androidquery.AQuery;
import com.androidquery.callback.AjaxStatus;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Main6Activity extends AppCompatActivity {
    String s;
    ListView ls;
    ArrayList<String> ar;
    private ArrayAdapter<String> adp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        ls = (ListView) findViewById(R.id.anls);
        SharedPreferences sh = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        s = sh.getString("userphone", "defaultValue");
        ar = new ArrayList<>();
        AQuery aq = new AQuery(this);
        String url = "http://172.16.6.94:3000/history?received_id=" + s;
        aq.ajax(url, JSONObject.class, this, "JsoncallBack");
        adp = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, ar);
        ls.setAdapter(adp);
        // txtb=(TextView)findViewById(R.id.txtbalance);


    }

    public void JsoncallBack(String url, JSONObject json, AjaxStatus status) throws JSONException {

        JSONArray userArray = json.getJSONArray("msg");
        // implement for loop for getting users list data
        for (int i = 0; i < userArray.length(); i++) {
            // create a JSONObject for fetching single user data
            JSONObject userDetail = userArray.getJSONObject(i);
            // fetch email and name and store it in arraylist
            // personNames.add(userDetail.getString("name"));
            // emailIds.add(userDetail.getString("email"));
            ar.add("YOU HAVE   " + userDetail.getString("Status") + " " + " $" + userDetail.getString("amount") + "to   " + " " + userDetail.getString("received_id") + " " + " Transaction ID" + " " + userDetail.getString("trans_id"));
            adp.notifyDataSetChanged();
            // Toast.makeText(this,userDetail.getString("trans_id") ,Toast.LENGTH_LONG).show();
        }


       /*

        if(json !=null){
            try {
                String msg=json.getString("msg");

                Toast.makeText(this,msg ,Toast.LENGTH_LONG).show();
              //  txtb.setText("Your Realtime Account Balance is: $:" + msg);




            }
            catch (Exception ex){}
        }else{


        }*/
    }

}
