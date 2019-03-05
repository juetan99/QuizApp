package com.example.juet.quizapp;

import android.content.Intent;
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

    public static final String EXTRA_SCORE = "com.example.juet.quizapp.SCORE";
    public static final String EXTRA_MAX_SCORE = "com.example.juet.quizapp.MAXSCORE";
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
                        currentQuestionNumber = currentQuestionNumber + 1;
                        currentQuestion = alQuizQuestions.get(currentQuestionNumber - 1);
                        setQuestionView(currentQuestion);
                    }
                    else {
                        Intent intentResult = new Intent(QuizActivity.this, ResultActivity.class);
                        intentResult.putExtra(EXTRA_SCORE, currentScore );
                        intentResult.putExtra(EXTRA_MAX_SCORE, maxScore );
                        startActivity(intentResult);
                    }

                }

            }
        });


        initiateQuestions();

        this.currentQuestion = alQuizQuestions.get(this.currentQuestionNumber - 1);
        setQuestionView(this.currentQuestion);
    }

    private boolean validateAnswer(){

        int selectedButtonId = this.radioGroupQuestion.getCheckedRadioButtonId();

        if (selectedButtonId != -1){
            String answerSelected = ((RadioButton)findViewById(selectedButtonId)).getText().toString();

            if (currentQuestion.isCorrectAnswer(answerSelected)){
                Log.d("Validate Answer", "validateAnswer: correct");
                currentScore++;
            }
            else {
                Log.d("Validate Answer", "validateAnswer: incorrect");
            }

            return true;
        }
        else {
            Toast.makeText(getApplicationContext(), "Please Select An Answer", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    private void initiateQuestions(){
        alQuizQuestions = new ArrayList<QuizQuestion>();

        QuizQuestion tmpQuestion1 = new QuizQuestion();
        tmpQuestion1.setQuestion(getResources().getString(R.string.Question1));
        tmpQuestion1.setChoiceA(getResources().getString(R.string.Question1AnswerChoiceA));
        tmpQuestion1.setChoiceB(getResources().getString(R.string.Question1AnswerChoiceB));
        tmpQuestion1.setChoiceC(getResources().getString(R.string.Question1AnswerChoiceC));
        tmpQuestion1.setChoiceD(getResources().getString(R.string.Question1AnswerChoiceD));
        tmpQuestion1.setCorrectAnswer(getResources().getString(R.string.Question1CorrectAnswer));

        alQuizQuestions.add(0, tmpQuestion1);

        QuizQuestion tmpQuestion2 = new QuizQuestion();
        tmpQuestion2.setQuestion(getResources().getString(R.string.Question2));
        tmpQuestion2.setChoiceA(getResources().getString(R.string.Question2AnswerChoiceA));
        tmpQuestion2.setChoiceB(getResources().getString(R.string.Question2AnswerChoiceB));
        tmpQuestion2.setChoiceC(getResources().getString(R.string.Question2AnswerChoiceC));
        tmpQuestion2.setChoiceD(getResources().getString(R.string.Question2AnswerChoiceD));
        tmpQuestion2.setCorrectAnswer(getResources().getString(R.string.Question2CorrectAnswer));

        alQuizQuestions.add(1, tmpQuestion2);

        QuizQuestion tmpQuestion3 = new QuizQuestion();
        tmpQuestion3.setQuestion(getResources().getString(R.string.Question3));
        tmpQuestion3.setChoiceA(getResources().getString(R.string.Question3AnswerChoiceA));
        tmpQuestion3.setChoiceB(getResources().getString(R.string.Question3AnswerChoiceB));
        tmpQuestion3.setChoiceC(getResources().getString(R.string.Question3AnswerChoiceC));
        tmpQuestion3.setChoiceD(getResources().getString(R.string.Question3AnswerChoiceD));
        tmpQuestion3.setCorrectAnswer(getResources().getString(R.string.Question3CorrectAnswer));

        alQuizQuestions.add(2, tmpQuestion3);

        this.maxScore = alQuizQuestions.size();

    }

    private void setQuestionView(QuizQuestion question){
        if (question == null){
            Log.d("setQuestionView", "Question is null ");
            return;
        }

        radioGroupQuestion.clearCheck();

        this.tvQuestionTitle.setText("Question #" + this.currentQuestionNumber);
        this.tvQuestion.setText(question.getQuestion());
        this.rdChoiceA.setText(question.getChoiceA());
        this.rdChoiceB.setText(question.getChoiceB());
        this.rdChoiceC.setText(question.getChoiceC());
        this.rdChoiceD.setText(question.getChoiceD());

    }
}
