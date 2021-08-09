package com.example.retroapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class Adaptery  extends RecyclerView.Adapter<Adaptery.MyViewHolder> {

    private Context mContext;
    private List<Hero> heroeslist;

    public Adaptery(Context mcontext,List<Hero> heroeslist){
        this.mContext = mcontext;
        this.heroeslist= heroeslist;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v;
        LayoutInflater layoutInflater= LayoutInflater.from(mContext);
        v= layoutInflater.inflate(R.layout.hero_item,parent,false);
        return new MyViewHolder(v);

    }

    @Override
    public void onBindViewHolder(Adaptery.MyViewHolder holder, int position) {


        holder.id.setText(heroeslist.get(position).getId());
        Glide.with(mContext)
            .load("https://cdn.jsdelivr.net/gh/akabab/superhero-api@0.3.0/api/images/lg/1-a-bomb.jpg")
                .into(holder.img);


        }

    @Override
    public int getItemCount() {
        return heroeslist.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView id;
        ImageView img;

        public MyViewHolder(View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.image_hero);
            id=itemView.findViewById(R.id.textview_id);

        }
    }
}
