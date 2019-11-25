package com.example.lasalliansimulator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    private Button btnLeaderboard;
    private Button btnQuest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportActionBar().hide();

        btnLeaderboard = findViewById(R.id.btn_leaderboard);
        btnQuest = findViewById(R.id.btn_quests);

        btnLeaderboard.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                addFragment(new Leaderboard(),false,"one");
            }
        });

        btnQuest.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                addFragment(new Quests(),false,"two");
            }
        });

    }

    public void addFragment(Fragment fragment, boolean addToBackStack, String tag) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();

        if (addToBackStack) {
            ft.addToBackStack(tag);
        }
        ft.replace(R.id.fragmentContainer, fragment, tag);
        ft.commitAllowingStateLoss();
    }


    public void inputCharacterName(View view) {
        Intent intent = new Intent(this, PopUpPlayerName.class);
//        overridePendingTransition(R.anim.slide_in_up, R.anim.slide_out_up); for animation
        startActivity(intent);
        finish();
    }
}
