package com.example.sdf_try;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Bundle;

public class QuestionsActivity extends AppCompatActivity {
    TextView tv;
    Button submitbutton, quitbutton;
    RadioGroup radio_g;
    RadioButton rb1,rb2,rb3,rb4;
    private ProgressBar progressBar;
    String questions[] = {
            "Who is your favorite teacher?",
            "How many students/groupmates do you have?",
            "How many students study with scholarship in our group?",
            "What is average age of overall class?",
            "How many students finished last term with 90+ GPA?",
            "How many students comes from Non-Computer Science Bachelor?",
            "Why we have classes every day?",
            "Where is the University located actually:))?",
            "When will pandemic be over?",
            "Nə vaxt görüşürük uşaqlar?"
    };
    String answers[] = {"Yusif Y.","8","2","24","4","4","None of the mentioned","Khirdalan","Soon","Mən razı nə vaxt istəsəz"};
    String opt[] = {
            "Rasim M.","Yusif Y.","Azer I.","Amil M.",
            "8","7","9","10",
            "1","2","3","4",
            "21","23","24","25",
            "3","4","5","6+",
            "2","4","3*","5",
            "Because we need to","Because we want to","Because we ask to","None of the mentioned",
            "US","Khirdalan","Europe","None",
            "Soon","After our graduation","After our youth","After us",
            "Mən razı nə vaxt istəsəz","Vaxtım yoxdur","Pandemiya bitsin, normal oturaq","Görüşməyək"
    };
    int flag=0;
    public static int marks=0,correct=0,wrong=0;
    private int totalQuestions;
    private Button nextButton;
    private Button prevButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        final TextView score = (TextView)findViewById(R.id.textView4);
        TextView textView=(TextView)findViewById(R.id.DispName);
        Intent intent = getIntent();
        String name= intent.getStringExtra("myname");

        if (name.trim().equals(""))
            textView.setText(" Hello");
        else
            textView.setText(" Hi " + name);

        submitbutton=(Button)findViewById(R.id.button3);
        quitbutton=(Button)findViewById(R.id.buttonquit);
        tv=(TextView) findViewById(R.id.tvque);
        progressBar = findViewById(R.id.determinantProgressBar);
        Button helpbutton = (Button) findViewById(R.id.buttonhelp);
        radio_g=(RadioGroup)findViewById(R.id.answersgrp);
        rb1=(RadioButton)findViewById(R.id.radioButton);
        rb2=(RadioButton)findViewById(R.id.radioButton2);
        rb3=(RadioButton)findViewById(R.id.radioButton3);
        rb4=(RadioButton)findViewById(R.id.radioButton4);
        tv.setText(questions[flag]);
        rb1.setText(opt[0]);
        rb2.setText(opt[1]);
        rb3.setText(opt[2]);
        rb4.setText(opt[3]);


        //set progress bar max value
        totalQuestions = questions.length;
        progressBar.setMax(totalQuestions);

        submitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //int color = mBackgroundColor.getColor();
                //mLayout.setBackgroundColor(color);

                if(radio_g.getCheckedRadioButtonId()==-1)
                {
                    Toast.makeText(getApplicationContext(), "Please select one choice", Toast.LENGTH_SHORT).show();
                    return;
                }
                RadioButton uans = (RadioButton) findViewById(radio_g.getCheckedRadioButtonId());
                String ansText = uans.getText().toString();
//                Toast.makeText(getApplicationContext(), ansText, Toast.LENGTH_SHORT).show();
                if(ansText.equals(answers[flag])) {
                    correct++;
                    progressBar.setProgress(correct);

                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                }
                else {
                    wrong++;
                    Toast.makeText(getApplicationContext(), "Wrong", Toast.LENGTH_SHORT).show();
                }

                flag++;

                if (score != null)
                    score.setText(""+correct);

                if(flag<questions.length)
                {
                    tv.setText(questions[flag]);
                    rb1.setText(opt[flag*4]);
                    rb2.setText(opt[flag*4 +1]);
                    rb3.setText(opt[flag*4 +2]);
                    rb4.setText(opt[flag*4 +3]);
                }
                else
                {
                    marks=correct;
                    Intent in = new Intent(getApplicationContext(),ResultActivity.class);
                    startActivity(in);
                }
                radio_g.clearCheck();
            }
        });


        quitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),ResultActivity.class);
                startActivity(intent);
            }
        });
        helpbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),InstructionsActivity.class);
                startActivity(intent);
            }
        });

    }
}
