package com.example.digitclassifier;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;


public class MyActivity extends AppCompatActivity {
    @Override
    protected void onPostResume() {
        super.onPostResume();
        Log.d("MyActivity","onPostResume");
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.d("MyActivity","OnStart");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.d("MyActivity","OnStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.d("MyActivity","onResume");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        Button finishBtn = findViewById(R.id.finish_Btn);
        finishBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Log.d("MyActivity","onCreate");
    }

}