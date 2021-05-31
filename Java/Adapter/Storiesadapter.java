package com.ramsarup.ramsarup.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ramsarup.ramsarup.R;
import com.ramsarup.ramsarup.Storyshow;

import java.util.List;

public class Storiesadapter extends RecyclerView.Adapter<Storiesadapter.MyViewHolder> {

    private List<Item> itemList;
    private Context context;


    public Storiesadapter(List<Item> itemList, Context context) {

        this.itemList = itemList;
this.context=context;
    }

    @SuppressLint("ResourceType")
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
        View view;
       {
            view = LayoutInflater.from(context).inflate(R.layout.storieslayout, parent, false);

            return new MyViewHolder(view);
        }

    }



    @Override
    public void onBindViewHolder(Storiesadapter.MyViewHolder holder, int i) {


               initLayoutOne((MyViewHolder) holder, i);




    }


    private void initLayoutOne(final MyViewHolder holder, final int pos) {
        holder.storyheading.setText(itemList.get(pos).getStoryheading());


        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                Intent callstoryclass=new Intent(context, Storyshow.class);

                callstoryclass.putExtra("storyname",itemList.get(pos).getStoryheading());

                context.startActivity(callstoryclass);
                    }





        });

    }



    @Override
    public int getItemCount() {
       return itemList.size();
    }



    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView storyheading;
        public ImageView go;
RelativeLayout parent;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            storyheading = itemView.findViewById(R.id.storyheading);

parent=itemView.findViewById(R.id.parentlayout);

        }


    }}




