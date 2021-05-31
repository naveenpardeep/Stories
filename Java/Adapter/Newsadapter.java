package com.ramsarup.ramsarup.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.ramsarup.ramsarup.R;
import com.ramsarup.ramsarup.Storyshow;

import java.util.List;

public class Newsadapter extends RecyclerView.Adapter<Newsadapter.MyViewHolder> {

    private List<Item> itemList;
    private Context context;



    public Newsadapter(List<Item> itemList, Context context) {

        this.itemList = itemList;
this.context=context;
    }

    @SuppressLint("ResourceType")
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
        View view;
       {
            view = LayoutInflater.from(context).inflate(R.layout.newslayout, parent, false);

            return new MyViewHolder(view);
        }

    }



    @Override
    public void onBindViewHolder(Newsadapter.MyViewHolder holder, int i) {


               layouttwo((MyViewHolder) holder, i);




    }
    private void layouttwo(final MyViewHolder holder,final int pos){
        holder.jokes.setText(itemList.get(pos).getNews());
        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                {
                    Intent callstoryclass = new Intent(context, Storyshow.class);

                    callstoryclass.putExtra("news", itemList.get(pos).getNews());

                    context.startActivity(callstoryclass);

                }
                }
        });
    }


    @Override
    public int getItemCount() {
       return itemList.size();
    }



    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView jokes;

RelativeLayout parent;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);


            jokes=itemView.findViewById(R.id.news);
parent=itemView.findViewById(R.id.newslayout);

        }


    }}




