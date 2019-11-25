package com.example.lasalliansimulator;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class Leaderboard extends Fragment {

    private View view;
    private TextView leaderboardLbl;
    private RecyclerView recyclerArea;
    private RecyclerAdapter recyclerAdapter;
    private ArrayList<LeaderboardData> array;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_leaderboard, container, false);
        leaderboardLbl = view.findViewById(R.id.leaderboard_lbl);

//        recyclerArea = (RecyclerView) view.findViewById(R.id.recycler_area);
//        recyclerAdapter = new RecyclerAdapter(getContext(), array);
//        recyclerArea.setAdapter(recyclerAdapter);
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
//        recyclerArea.setLayoutManager(layoutManager);

        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        array = new ArrayList<>();
        array.add(new LeaderboardData(1, "John", "Senior, 2nd Term"));
        array.add(new LeaderboardData(2, "Anne", "Soph, 2nd Term"));
        array.add(new LeaderboardData(3, "Andrew", "Frosh, 3nd Term"));
        array.add(new LeaderboardData(4, "Rae", "Frosh, 2nd Term"));
    }
}
