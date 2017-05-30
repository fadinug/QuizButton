package com.example.fajar.quizfix;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class HighScore extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_score);

        //inisialisasi komponen
        TextView score_text = (TextView) findViewById(R.id.score_text);
        TextView highscore_text = (TextView) findViewById(R.id.highscore_text);

        //menerima skor dari activity sebelumnya melalui intent
        Intent i = getIntent();
        int score = i.getIntExtra("score", 0);
        //menampilkan skor dari actrivity sebelumnya
        score_text.setText("Your score is: " + score);

        //untuk menyimpan skor terbaik
        SharedPreferences high = getPreferences(MODE_PRIVATE);
        int HighScore = high.getInt("high score", 0);
        if (HighScore >= score)
            highscore_text.setText("High score is: " + HighScore);
        else {
            highscore_text.setText("Highest score: " + score);
            SharedPreferences.Editor editor = high.edit();
            editor.putInt("high score", score);
            editor.commit();
        }
    }

    public void onclick (View view) {
        Intent i = new Intent(HighScore.this, Quiz.class);
        startActivity(i);
    }
}
