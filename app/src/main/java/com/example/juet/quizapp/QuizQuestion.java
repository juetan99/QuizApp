package com.example.juet.quizapp;

public class QuizQuestion {
    private String question;
    private String choiceA;
    private String choiceB;
    private String choiceC;
    private String choiceD;
    private String correctAnswer;

    public QuizQuestion(){

    }

    protected String getQuestion(){
        return this.question;
    }

    protected String getChoiceA(){
        return this.choiceA;
    }

    protected String getChoiceB(){
        return this.choiceB;
    }

    protected String getChoiceC(){
        return this.choiceC;
    }

    protected String getChoiceD(){
        return this.choiceD;
    }

    protected String getCorrectAnswer(){
        return this.correctAnswer;
    }

    protected void setQuestion(String question){
        this.question = question;
    }

    protected void setChoiceA(String answer){
        this.choiceA = answer;
    }

    protected void setChoiceB (String answer){
        this.choiceB = answer;
    }

    protected void setChoiceC(String answer){
        this.choiceC = answer;
    }

    protected void setChoiceD(String answer){
        this.choiceD = answer;
    }

    protected void setCorrectAnswer(String answer){
        this.correctAnswer = answer;
    }

    protected boolean isCorrectAnswer(String answer){
        if (this.correctAnswer == null){
            return false;
        } else if (this.correctAnswer == answer){
            return true;
        } else {
            return false;
        }
    }
}
