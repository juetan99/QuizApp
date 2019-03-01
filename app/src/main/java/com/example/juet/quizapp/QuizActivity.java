package com.example.juet.quizapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class QuizActivity extends AppCompatActivity {

    private ArrayList<QuizQuestion> alQuizQuestions = null;
    QuizQuestion currentQuestion = null;
    int currentQuestionNumber = 1;

    private int currentScore = 0;
    private int maxScore = 0;

    TextView tvQuestionTitle = null;
    TextView tvQuestion = null;
    TextView tvScore = null;

    RadioGroup radioGroupQuestion = null;
    RadioButton rdChoiceA = null;
    RadioButton rdChoiceB = null;
    RadioButton rdChoiceC = null;
    RadioButton rdChoiceD = null;

    Button btnSubmitAnswer = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_activity);

        this.tvQuestionTitle = (TextView)findViewById(R.id.tvQuestionTitle);
        this.tvQuestion = (TextView)findViewById(R.id.tvQuestion);
        this.tvScore = (TextView)findViewById(R.id.tvScore);

        radioGroupQuestion = (RadioGroup)findViewById(R.id.rbGroup);
        rdChoiceA = (RadioButton)findViewById(R.id.rbAnswerA);
        rdChoiceB = (RadioButton)findViewById(R.id.rbAnswerB);
        rdChoiceC = (RadioButton)findViewById(R.id.rbAnswerC);
        rdChoiceD = (RadioButton)findViewById(R.id.rbAnswerD);

        btnSubmitAnswer = (Button)findViewById(R.id.btnSubmitAnswer);

        this.btnSubmitAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // validate answer
                if (validateAnswer()){
                    if (currentQuestionNumber < maxScore){

                    }
                    else {

                    }

                }

            }
        });


    }

    private boolean validateAnswer(){

        int selectedButtonId = this.radioGroupQuestion.getCheckedRadioButtonId();

        if (selectedButtonId != -1){
            String answerSelected = ((RadioButton)findViewById(selectedButtonId)).getText().toString();

            if (currentQuestion.isCorrectAnswer(answerSelected)){
                Log.d(TAG, "validateAnswer: correct");
                currentScore++;
            }
            else {
                Log.d(TAG, "validateAnswer: incorrect");
            }

            return true;
        }
        else {
            Toast.makeText(getApplicationContext(), "Please Select An Answer", Toast.LENGTH_SHORT).show();
            return false;
        }
    }
}
