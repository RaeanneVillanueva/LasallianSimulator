package com.example.lasalliansimulator;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.lorentzos.flingswipe.SwipeFlingAdapterView;

import java.util.ArrayList;

//hello im on git!
public class MainActivity extends AppCompatActivity {

    public AppAdapter appAdapter;
    private ArrayList<Data> array;
    private SwipeFlingAdapterView flingContainer;
    private ProgressBar health_bar, social_bar, grades_bar, money_bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppConstants.init();

        flingContainer = (SwipeFlingAdapterView) findViewById(R.id.swipeFrame);

        health_bar = findViewById(R.id.healthBar);
        social_bar = findViewById(R.id.socialBar);
        grades_bar = findViewById(R.id.gradesBar);
        money_bar = findViewById(R.id.moneyBar);

        array = new ArrayList<>();


        array.add(new Data(R.drawable.mom, "Mom", "DCAT is coming, you should study!", "Study", "Stock Knowledge", new Consequence(0, 10, 15, 0), new Consequence(0,-10,-20,0)));
        array.add(new Data(0, "Narrator", "Congratulations! you passed DCAT. Welcome to DLSU", "Wow", "Yay!", new Consequence(), new Consequence()));
        array.add(new Data(0, "Andrew", "Let's code! Want me to reserve a discussion room?", "Sure!", "No thanks..", new Consequence(0, 10, 15, 0), new Consequence(0,-10,-20,0)));


        array.add(new Data(R.drawable.andrew, "Andrew", "Let's code! Want me to reserve a discussion room?", "Sure!", "No thanks..", new Consequence(0, 10, 15, 0), new Consequence(0,-10,-20,0)));
        array.add(new Data(R.drawable.dad, "Dad", "Go drink and have fun! I won't tell mom..", "You're the best dad!", "I'm scared..", new Consequence(20,20,0,-20), new Consequence(20,-10,0,10)));
        array.add(new Data(R.drawable.mom, "Mom", "Go home now! If you don't go home, I kill you!", "OK!", "GOING NOW!", new Consequence(0,-10,0,10), new Consequence(0,-10,0,10)));
        array.add(new Data(R.drawable.bob, "Bob", "Hi there! I like playing LoL, wanna play with me?", "Sure?","Loser..", new Consequence(-10,10,-5,0), new Consequence(10,-30,5,0)));
        array.add(new Data(R.drawable.bek, "Bek", "Lemme draw you!", "That would be great!", "Hell no!", new Consequence(10,15,0,0), new Consequence(-20,-30,0,0)));
        array.add(new Data(R.drawable.james, "James", "Meet me at the gym! Let's lift weights!", "Gainz!!", "I'm tired..", new Consequence(30,30,0,0), new Consequence(-40,15,0,0)));
        array.add(new Data(R.drawable.girl, "Random Girl", "Hi im nothing", "Hi?", "Ew", new Consequence(0,0,0,0), new Consequence(-50,-50,-50,-50)));

         appAdapter = new AppAdapter(array, MainActivity.this);

        flingContainer.setAdapter(appAdapter);

        flingContainer.setFlingListener(new SwipeFlingAdapterView.onFlingListener() {
            @Override
            public void removeFirstObjectInAdapter() {

            }

            @Override
            public void onLeftCardExit(Object dataObject) {

                AppConstants.player.setChanges(array.get(0).getConsequenceRight());

                updateProgressBar();

                array.remove(0);
                appAdapter.notifyDataSetChanged();

                if(!AppConstants.player.isSurviving()){
                    Intent intent = new Intent(MainActivity.this, StartActivity.class);
                    startActivity(intent);
                    finish();
                }
                //Do something on the left!
                //You also have access to the original object.
                //If you want to use it just cast it (String) dataObject



            }

            @Override
            public void onRightCardExit(Object dataObject) {

                AppConstants.player.setChanges(array.get(0).getConsequenceLeft());

                updateProgressBar();


                array.remove(0);
                appAdapter.notifyDataSetChanged();

                if(!AppConstants.player.isSurviving()){
                    Intent intent = new Intent(MainActivity.this, StartActivity.class);
                    startActivity(intent);
                    finish();
                }
            }

            private void updateProgressBar(){
                health_bar.setProgress(AppConstants.player.getHealth());
                social_bar.setProgress(AppConstants.player.getSocial());
                grades_bar.setProgress(AppConstants.player.getGrades());
                money_bar.setProgress(AppConstants.player.getMoney());
            }

            @Override
            public void onAdapterAboutToEmpty(int itemsInAdapter) {

            }

            @Override
            public void onScroll(float scrollProgressPercent) {

                View view = flingContainer.getSelectedView();
                view.findViewById(R.id.item_swipe_right_indicator).setAlpha(scrollProgressPercent < 0 ? -scrollProgressPercent : 0);
                view.findViewById(R.id.item_swipe_left_indicator).setAlpha(scrollProgressPercent > 0 ? scrollProgressPercent : 0);
            }
        });


        // Optionally add an OnItemClickListener
        flingContainer.setOnItemClickListener(new SwipeFlingAdapterView.OnItemClickListener() {
            @Override
            public void onItemClicked(int itemPosition, Object dataObject) {

                View view = flingContainer.getSelectedView();
                appAdapter.notifyDataSetChanged();
            }
        });

    }
}
