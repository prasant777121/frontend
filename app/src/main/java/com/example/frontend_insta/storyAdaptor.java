package com.example.frontend_insta;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class storyAdaptor extends RecyclerView.Adapter<storyAdaptor.viewholder> {
    Context context;
    ArrayList<storyModel> storyArray;

    storyAdaptor(Context context,  ArrayList<storyModel> storyArray){
        this.context=context;
        this.storyArray=storyArray;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        holder.name.setText(storyArray.get(position).name);

    }

    @Override
    public int getItemCount() {
        return storyArray.size();
    }

    public  class viewholder extends RecyclerView.ViewHolder{
        TextView name;

        public viewholder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name);

        }
    }
}
