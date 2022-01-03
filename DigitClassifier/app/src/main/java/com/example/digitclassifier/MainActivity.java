package com.example.digitclassifier;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editText = (EditText)findViewById(R.id.input_Et);
        Button button = (Button)findViewById(R.id.input_Btn);
        TextView textView = (TextView)findViewById(R.id.output_Tv);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = editText.getText().toString();
                textView.setText(text);

//                try {
//                    Thread.sleep(10 * 1000);
//                    Toast.makeText(MainActivity.this, "complete", Toast.LENGTH_SHORT).show();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }

            }
        });

//        button.setOnClickListener(view -> {
//        });

        Button actBtn = findViewById(R.id.activity_launch_Btn);
        actBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, MyActivity.class);
                startActivity(i);
            }
        });

    }
}
