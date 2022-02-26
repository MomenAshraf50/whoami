package com.example.whoami;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PersonalitiesAdapter extends RecyclerView.Adapter<PersonalitiesAdapter.PersonalityHolder> {
    List<PersonalityDetails> list;
    Context context;

    public PersonalitiesAdapter(List<PersonalityDetails> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public PersonalityHolder onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {
        return new PersonalityHolder(LayoutInflater.from(parent.getContext())
        .inflate(R.layout.personalities_items,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull PersonalitiesAdapter.PersonalityHolder holder, int position) {
        PersonalityDetails details = list.get(position);
        holder.personalityImage.setImageResource(details.getImagePath());
        holder.textViewName.setText(details.getPersonalityName());
        holder.textViewInfo.setText(details.getPersonalityInfo());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,PersonalityViewActivity.class);
                intent.putExtra("personalityImage",details.getImagePath());
                intent.putExtra("personalityInfo",details.getPersonalityInfo());
                intent.putExtra("personalityName",details.getPersonalityName());
                intent.putExtra("PersonalityCharacteristicOne",details.getPersonalityCharacteristicOne());
                intent.putExtra("PersonalityCharacteristicTwo",details.getPersonalityCharacteristicTwo());
                intent.putExtra("PersonalityCharacteristicThree",details.getPersonalityCharacteristicThree());
                intent.putExtra("PersonalityCharacteristicFour",details.getPersonalityCharacteristicFour());
                intent.putExtra("PersonalityCharacteristicFive",details.getPersonalityCharacteristicFive());
                intent.putExtra("PersonalityCharacteristicSix",details.getPersonalityCharacteristicSix());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class PersonalityHolder extends RecyclerView.ViewHolder {
        ImageView personalityImage;
        TextView textViewName,textViewInfo;
        public PersonalityHolder(@NonNull @org.jetbrains.annotations.NotNull View itemView) {
            super(itemView);
            personalityImage = itemView.findViewById(R.id.card_view_iv);
            textViewName = itemView.findViewById(R.id.personality_name);
            textViewInfo = itemView.findViewById(R.id.personality_info);

        }
    }
}
