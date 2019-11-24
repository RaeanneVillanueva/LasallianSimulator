package com.example.LasallianSimulator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;


import java.lang.reflect.Array;
import java.util.List;

public class AppAdapter extends BaseAdapter{

    public List<Data> data;
    public Context context;

    public AppAdapter(List<Data> apps, Context context) {
        this.data = apps;
        this.context = context;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;

        if (convertView == null) {

            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.item, parent, false);

            // configure view holder
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.charName.setText(data.get(position).getCharacterName() + "");
        viewHolder.cardImage.setImageResource(data.get(position).getImagePath());
        viewHolder.choiceLeft.setText(data.get(position).getChoiceLeft());
        viewHolder.choiceRight.setText(data.get(position).getChoiceRight());
        viewHolder.txtScenario.setText(data.get(position).getScenario());
        Glide.with(context).load(data.get(position).getImagePath()).into(viewHolder.cardImage);

        return convertView;
    }

    private class ViewHolder {

        FrameLayout card;
        TextView charName;
        ImageView cardImage;
        TextView choiceLeft;
        TextView choiceRight;
        TextView txtScenario;

        public ViewHolder(View view) {
            charName = (TextView) view.findViewById(R.id.characterName);
            cardImage = (ImageView) view.findViewById(R.id.cardImage);
            card = (FrameLayout) view.findViewById(R.id.card);
            choiceLeft = view.findViewById(R.id.item_swipe_left_indicator);
            choiceRight = view.findViewById(R.id.item_swipe_right_indicator);
            txtScenario = view.findViewById(R.id.txtScenario);
        }
    }

}
