package com.ramsarup.ramsarup.fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.ramsarup.ramsarup.Adapter.Item;
import com.ramsarup.ramsarup.Adapter.Newsadapter;
import com.ramsarup.ramsarup.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class News extends Fragment {


    private RecyclerView recyclerView;
    TextView news;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference dbref = database.getReference("News");
    DatabaseReference appid =database.getReference("Appid");
    DatabaseReference adsunitid =database.getReference("Adsunitid");
    private List<Item> itemList = new ArrayList<>();



    public News() {

        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

// Inflate the layout for this fragment
        recyclerView = view.findViewById(R.id.recyclernews);
        news = view.findViewById(R.id.news);




        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL));
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);

        itemList.clear();

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_news, container, false);


        appid.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String appidofad = dataSnapshot.getValue(String.class);
                MobileAds.initialize(getContext(), appidofad);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
            }
        });

        adsunitid.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String adsunit = dataSnapshot.getValue(String.class);

                View adContainer = view.findViewById(R.id.adMobView);

                AdView mAdView = new AdView(getContext());
                mAdView.setAdSize(AdSize.BANNER);

                mAdView.setAdUnitId(adsunit);
                ((RelativeLayout)adContainer).addView(mAdView);
                AdRequest adRequest = new AdRequest.Builder().build();
                mAdView.loadAd(adRequest);

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
            }
        });






        itemList.clear();//so that no repeat data
       setvalue();
        return view;

    }



    public void setvalue(){
        itemList.clear();
        dbref.addChildEventListener(new ChildEventListener() {

            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Item data = dataSnapshot.getValue(Item.class);
                {
                    final Newsadapter adapter = new Newsadapter(itemList, getContext());
                    itemList.add(data);


                    recyclerView.setAdapter(adapter);

                }

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }


        });

    }

}
