package com.example.scoring;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class BestScore extends AppCompatActivity {

    TextView tv_score;

    int lastScore;
    int best1, best2, best3, best4, best5;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.score_best);

        tv_score = (TextView) findViewById(R.id.tv_score);

        //load old scores
        SharedPreferences preferences = getSharedPreferences("PREFS", 0);
        lastScore = preferences.getInt("lastScore", 0);
        best1 = preferences.getInt("best1", 0);
        best2 = preferences.getInt("best2", 0);
        best3 = preferences.getInt("best3", 0);
        best4 = preferences.getInt("best4", 0);
        best5 = preferences.getInt("best5", 0);

        //replace if there is a high score

        if(lastScore > best5){
            best5 = lastScore;
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("best5",best5);
            editor.apply();
        }
        if(lastScore > best4){
            int temp = best4;
            best4 = lastScore;
            best5 = temp;
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("best5",best5);
            editor.putInt("best4",best4);
            editor.apply();
        }

        if(lastScore > best3){
            int temp = best3;
            best3 = lastScore;
            best4 = temp;
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("best4",best4);
            editor.putInt("best3",best3);
            editor.apply();
        }

        if(lastScore > best2){
            int temp = best2;
            best2 = lastScore;
            best3 = temp;
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("best3",best3);
            editor.putInt("best2",best2);
            editor.apply();
        }

        if(lastScore > best1){
            int temp = best1;
            best1 = lastScore;
            best2 = temp;
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("best2",best2);
            editor.putInt("best1",best1);
            editor.apply();
        }

        //display scores
        tv_score.setText("Last Score: " + lastScore + "\n" +
                "BEST 1: " + best1 + "\n" +
                "BEST 2: " + best2 + "\n" +
                "Best 3: " + best3 + "\n" +
                "BEST 4: " + best4 + "\n" +
                "BEST 5: " + best5 + "\n");
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
        finish();
    }
}