package com.example.friendsapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    EditText e1,e2,e3,e4;
    AppCompatButton b1;
    String apiUrl="https://friendsapi-re5a.onrender.com/adddata";
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        e1=(EditText) findViewById(R.id.name);
        e2=(EditText) findViewById(R.id.fname);
        e3=(EditText) findViewById(R.id.fnname);
        e4=(EditText) findViewById(R.id.des);
        b1=(AppCompatButton)  findViewById(R.id.subbtn);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String getName=e1.getText().toString();
                String getFriendName=e2.getText().toString();
                String getFriendNickName=e3.getText().toString();
                String getFriendDescription=e4.getText().toString();

                //JSON object
                JSONObject friend=new JSONObject();
                try {
                    friend.put("name",getName);
                    friend.put("friendName",getFriendName);
                    friend.put("friendNickName",getFriendNickName);
                    friend.put("DescribeYourFriend",getFriendDescription);
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
                //JSONOBJECTREQUESTCREATION
                     JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(
                             Request.Method.POST,
                             apiUrl,
                             friend,
                             new Response.Listener<JSONObject>() {
                                 @Override
                                 public void onResponse(JSONObject response) {
                                     Toast.makeText(getApplicationContext(), "Added Successfully", Toast.LENGTH_LONG).show();
                                 }
                             },
                             new Response.ErrorListener() {
                                 @Override
                                 public void onErrorResponse(VolleyError error) {
                                     Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                                 }
                             }


                     );
                //request queue
                RequestQueue requestQueue= Volley.newRequestQueue(getApplicationContext());
                requestQueue.add(jsonObjectRequest);

            }
        });
    }
}