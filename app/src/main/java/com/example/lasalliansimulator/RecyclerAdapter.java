package com.example.lasalliansimulator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {

    private List<LeaderboardData> leaderboardData;
    private Context context;

    public RecyclerAdapter(Context context, List<LeaderboardData> data) {
        this.context = context;
        this.leaderboardData = data;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.leaderboard_item, parent, false);
        RecyclerViewHolder viewHolder = new RecyclerViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        holder.rank.setText(leaderboardData.get(position).getRank());
        holder.name.setText(leaderboardData.get(position).getName());
        holder.score.setText(leaderboardData.get(position).getScore());
    }

    @Override
    public int getItemCount() {
        return leaderboardData.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder {

        private TextView rank, name, score;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
            rank = (TextView) itemView.findViewById(R.id.rank);
            name = (TextView) itemView.findViewById(R.id.player_name);
            score = (TextView) itemView.findViewById(R.id.score);
        }
    }
}
