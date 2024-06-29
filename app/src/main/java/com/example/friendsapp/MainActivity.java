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

public class MainActivity extends AppCompatActivity {
    EditText e1,e2,e3,e4;
    AppCompatButton b1;
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
                Toast.makeText(getApplicationContext(),getName+" "+getFriendName+" "+getFriendNickName+" "+getFriendDescription,Toast.LENGTH_LONG).show();
            }
        });
    }
}