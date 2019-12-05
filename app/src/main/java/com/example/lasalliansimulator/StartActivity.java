package com.example.lasalliansimulator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        getSupportActionBar().hide();
    }

    public void startGame(View view) {
        Intent intent = new Intent(this, PopUpPlayerName.class);
        startActivity(intent);
        finish();
    }

    public void openLeaderboard(View view) {

    }

    public void openQuests(View view) {

    }
}
