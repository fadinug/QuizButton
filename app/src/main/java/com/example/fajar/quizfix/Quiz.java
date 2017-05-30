package com.example.fajar.quizfix;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Quiz extends AppCompatActivity {

    //deklarasi variable
    private QuizBank mQuizLibrary = new QuizBank();
    private TextView sScore;
    private TextView sQuestionText;
    private Button mchoice1;
    private Button mchoice2;
    private Button mchoice3;
    private Button mchoice4;

    private String manswer;
    private int mScore = 0;
    private int mQuestionNumber = 0;
    private int [] mQuestionFinish = {1,2,3,4,5} ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        //inisialisasi variable
        sScore = (TextView) findViewById(R.id.score);
        sQuestionText = (TextView) findViewById(R.id.question);
        mchoice1 = (Button) findViewById(R.id.choice1);
        mchoice2 = (Button) findViewById(R.id.choice2);
        mchoice3 = (Button) findViewById(R.id.choice3);
        mchoice4 = (Button) findViewById(R.id.choice4);

        updateQuestion();
        //menampilkan skor dari berapa pertanyaan
        updateScore(mScore);
    }

    //method untuk mengatur pertanyaan
    private void updateQuestion() {
        if (mQuestionNumber < mQuizLibrary.getLength()) {
            //mengeset disetiap komponen untuk jadi pertanyaan dan opsional
            sQuestionText.setText(mQuizLibrary.getQuestion(mQuestionNumber));
            mchoice1.setText(mQuizLibrary.getChoice(mQuestionNumber, 1));
            mchoice2.setText(mQuizLibrary.getChoice(mQuestionNumber, 2));
            mchoice3.setText(mQuizLibrary.getChoice(mQuestionNumber, 3));
            mchoice4.setText(mQuizLibrary.getChoice(mQuestionNumber, 4));
            manswer = mQuizLibrary.getCorret(mQuestionNumber);
            mQuestionNumber++;
        } else {
            Toast.makeText(Quiz.this, "Ini pertanyaan terakhir", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(Quiz.this, HighScore.class);
            i.putExtra("score", mScore);
            startActivity(i);
        }
    }


    private  void setRandom(){
        mQuestionNumber = (int) Math.round(Math.random() *mQuizLibrary.getLength());
        for(int i =0; i< mQuestionFinish.length; i++){
            if(mQuestionNumber==mQuestionFinish[i] && mQuestionFinish[i]!=0){
                updateQuestion();
                mQuestionFinish[i]=0;
                break;
            }
        }
    }

    //method untuk mengatur skor
    private void updateScore(int point) {
        sScore.setText("" + mScore + "/" +  mQuizLibrary.getLength());
    }

    //method untuk button ketika diklik
    public void onclick (View view){
        Button answer = (Button) view;
        if (answer.getText() == manswer) {
            mScore = mScore + 1;
            Toast.makeText(Quiz.this, "Jawaban benar!", Toast.LENGTH_SHORT).show();
        } else
            Toast.makeText(Quiz.this, "Jawaban salah!", Toast.LENGTH_SHORT).show();
        updateScore(mScore);
        updateQuestion();
    }
}
