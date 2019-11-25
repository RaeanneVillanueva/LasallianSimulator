package com.example.lasalliansimulator;

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

        flingContainer = (SwipeFlingAdapterView) findViewById(R.id.swipeFrame);

        health_bar = findViewById(R.id.healthBar);
        social_bar = findViewById(R.id.socialBar);
        grades_bar = findViewById(R.id.gradesBar);
        money_bar = findViewById(R.id.moneyBar);

        array = new ArrayList<>();

        array.add(new Data(R.drawable.andrew, "Andrew", "Let's code! Want me to reserve a discussion room?", "Sure!", "No thanks..", 0, 5, 10, 0));
        array.add(new Data(R.drawable.dad, "Dad", "Go drink and have fun! I won't tell mom..", "You're the best dad!", "I'm scared..", 10,5, 0, 10));
        array.add(new Data(R.drawable.mom, "Mom", "Go home now! If you don't go home, I kill you!", "OK!", "GOING NOW!", 15,4,6,5));
        array.add(new Data(R.drawable.bob, "Bob", "Hi there! I like playing LoL, wanna play with me?", "Sure?","Loser..", 10,6,8,9));
        array.add(new Data(R.drawable.bek, "Bek", "Lemme draw you!", "That would be great!", "Hell no!", 5,8,6,5));
        array.add(new Data(R.drawable.james, "James", "Meet me at the gym! Let's lift weights!", "Gainz!!", "I'm tired..", 30,6,0,5));
        array.add(new Data(R.drawable.girl, "Random Girl", "Hi im nothing", "Hi?", "Hi?", 1,0,0,0));

        appAdapter = new AppAdapter(array, MainActivity.this);
        flingContainer.setAdapter(appAdapter);

        flingContainer.setFlingListener(new SwipeFlingAdapterView.onFlingListener() {
            @Override
            public void removeFirstObjectInAdapter() {

            }

            @Override
            public void onLeftCardExit(Object dataObject) {

                health_bar.setProgress(health_bar.getProgress() + array.get(0).getHealthPts());
                social_bar.setProgress(social_bar.getProgress() + array.get(0).getSocialPts());
                grades_bar.setProgress(grades_bar.getProgress() + array.get(0).getGradesPts());
                money_bar.setProgress(money_bar.getProgress() + array.get(0).getMoneyPts());

                array.remove(0);
                appAdapter.notifyDataSetChanged();

                //Do something on the left!
                //You also have access to the original object.
                //If you want to use it just cast it (String) dataObject
            }

            @Override
            public void onRightCardExit(Object dataObject) {

                health_bar.setProgress(health_bar.getProgress() - array.get(0).getHealthPts());
                social_bar.setProgress(social_bar.getProgress() - array.get(0).getSocialPts());
                grades_bar.setProgress(grades_bar.getProgress() - array.get(0).getGradesPts());
                money_bar.setProgress(money_bar.getProgress() - array.get(0).getMoneyPts());

                array.remove(0);
                appAdapter.notifyDataSetChanged();
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
