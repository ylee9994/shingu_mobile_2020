package com.example.a03button;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button1;
    Button button2;
    Button button3, button4, button5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.sbutton1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mintent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://m.naver.com"));
                startActivity(mintent);
            }
        });

        button2 = findViewById(R.id.sbutton2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mintent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("tel:/119"));
                startActivity(mintent);
            }
        });

        button3 = findViewById(R.id.sbutton3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mintent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("content://media/internal/images/media"));
                startActivity(mintent);
            }
        });

        button4 = findViewById(R.id.sbutton4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        button5 = findViewById(R.id.sbutton5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),
                        "이용희님 안녕하세요", Toast.LENGTH_LONG).show();
            }
        });


    }
}
