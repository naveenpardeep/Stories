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

public class Factsadapter extends RecyclerView.Adapter<Factsadapter.MyViewHolder> {

    private List<Item> itemList;
    private Context context;



    public Factsadapter(List<Item> itemList, Context context) {

        this.itemList = itemList;
this.context=context;
    }

    @SuppressLint("ResourceType")
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
        View view;
       {
            view = LayoutInflater.from(context).inflate(R.layout.factslayout, parent, false);

            return new MyViewHolder(view);
        }

    }



    @Override
    public void onBindViewHolder(Factsadapter.MyViewHolder holder, int i) {


               layouttwo((MyViewHolder) holder, i);




    }
    private void layouttwo(final MyViewHolder holder,final int pos){
        holder.facts.setText(itemList.get(pos).getFacts());
        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                {
                    Intent callstoryclass = new Intent(context, Storyshow.class);

                    callstoryclass.putExtra("facts", itemList.get(pos).getFacts());

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
        public TextView facts;

RelativeLayout parent;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);


            facts=itemView.findViewById(R.id.facts);
parent=itemView.findViewById(R.id.factslayout);

        }


    }}




