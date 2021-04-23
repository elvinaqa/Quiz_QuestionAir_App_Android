package com.example.sdf_try;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    TextView tv, tv2, tv3;
    Button btnRestart, btnbuttonhelp2, btnBookmark, btnSettings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        tv = (TextView)findViewById(R.id.tvres);
        tv2 = (TextView)findViewById(R.id.tvres2);
        tv3 = (TextView)findViewById(R.id.tvres3);
        btnRestart =  findViewById(R.id.btnRestart);
        btnbuttonhelp2 =  findViewById(R.id.btnbuttonhelp2);
        btnBookmark = findViewById(R.id.btnBookmark);
        btnSettings = findViewById(R.id.btnSettings);
        StringBuffer sb = new StringBuffer();
        sb.append("Correct answers: " + QuestionsActivity.correct + "\n");
        StringBuffer sb2 = new StringBuffer();
        sb2.append("Wrong Answers: " + QuestionsActivity.wrong + "\n");
        StringBuffer sb3 = new StringBuffer();
        sb3.append("Final Score: " + QuestionsActivity.correct + "\n");
        tv.setText(sb);
        tv2.setText(sb2);
        tv3.setText(sb3);

        QuestionsActivity.correct=0;
        QuestionsActivity.wrong=0;

        btnRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(),BookmarksActivity.class);
                startActivity(in);
            }
        });
        btnbuttonhelp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(),InstructionsActivity.class);
                startActivity(in);
            }
        });

        btnBookmark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(in);
            }
        });
        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(),SettingsActivity.class);
                startActivity(in);
            }
        });

    }
}
