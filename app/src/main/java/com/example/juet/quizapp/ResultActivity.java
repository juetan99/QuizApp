package com.example.juet.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ResultActivity extends AppCompatActivity {
    int iCurrentSore = 0;
    int maxScore = 0;

    TextView tvScore = null;
    TextView tvResultDescription = null;

    Button btnPlayAgain = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        tvScore = (TextView)findViewById(R.id.tvScore);
        tvResultDescription = (TextView)findViewById(R.id.tvResult);

        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            return;
        }

        iCurrentSore = extras.getInt(QuizActivity.EXTRA_SCORE);
        maxScore = extras.getInt(QuizActivity.EXTRA_MAX_SCORE);

        String display = String.valueOf(iCurrentSore) + "/" + String.valueOf(maxScore);
        Log.d("Debug", "ResultActivity - onCreate: " + display);

        String display2 = "You answered " + getPercentage(iCurrentSore, maxScore) + " of the quiz questions correctly.";
        tvScore.setText(display);
        tvResultDescription.setText(display2);

        btnPlayAgain = (Button)findViewById(R.id.btnPlayAgain);
        this.btnPlayAgain.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                    Intent intentMain = new Intent(ResultActivity.this, MainActivity.class);
                    startActivity(intentMain);
             }

    });
    }

    private String getPercentage(int currentScore, int total){
        float fPercent = (float)currentScore/total;
        return Integer.toString((int)Math.ceil(fPercent * 100)) + "%";
    }
}
