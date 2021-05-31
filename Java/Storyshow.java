package com.ramsarup.ramsarup;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.ramsarup.ramsarup.R;

import java.net.URISyntaxException;

public class Storyshow extends AppCompatActivity {
    FirebaseDatabase database = FirebaseDatabase.getInstance();


    DatabaseReference appid =database.getReference("Appid");
    DatabaseReference adsunitid =database.getReference("Adsunitid");
    String storycontentstring;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storyshow);

        appid.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String appidofad = dataSnapshot.getValue(String.class);
                MobileAds.initialize(Storyshow.this, appidofad);
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

                View adContainer = findViewById(R.id.adMobView);

                AdView mAdView = new AdView(Storyshow.this);
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



        if (getIntent().hasExtra("storyname")) {


             storycontentstring = getIntent().getStringExtra("storyname");

            TextView storycontent = findViewById(R.id.storycontent);
            storycontent.setText(storycontentstring);


        }
         if(getIntent().hasExtra("jokes")){
            storycontentstring=getIntent().getStringExtra("jokes");
            TextView jokes=findViewById(R.id.storycontent);
            jokes.setText(storycontentstring);
        }

        if(getIntent().hasExtra("facts")){
            storycontentstring=getIntent().getStringExtra("facts");
            TextView facts=findViewById(R.id.storycontent);
            facts.setText(storycontentstring);
        }   if(getIntent().hasExtra("jobs")){
            storycontentstring=getIntent().getStringExtra("jobs");
            TextView jobs=findViewById(R.id.storycontent);
            jobs.setText(storycontentstring);
        }   if(getIntent().hasExtra("horoscope")){
            storycontentstring=getIntent().getStringExtra("horoscope");
            TextView horoscope=findViewById(R.id.storycontent);
            horoscope.setText(storycontentstring);
        }   if(getIntent().hasExtra("success")){
            storycontentstring=getIntent().getStringExtra("success");
            TextView success=findViewById(R.id.storycontent);
            success.setText(storycontentstring);
        }   if(getIntent().hasExtra("shayri")){
            storycontentstring=getIntent().getStringExtra("shayri");
            TextView shayri=findViewById(R.id.storycontent);shayri.setText(storycontentstring);
        }   if(getIntent().hasExtra("gharelunuskhe")){
            storycontentstring=getIntent().getStringExtra("gharelunuskhe");
            TextView gharelunuskhe=findViewById(R.id.storycontent);
            gharelunuskhe.setText(storycontentstring);
        }   if(getIntent().hasExtra("news")){
            storycontentstring=getIntent().getStringExtra("news");
            TextView news=findViewById(R.id.storycontent);
            news.setText(storycontentstring);
        }
        if(getIntent().hasExtra("birthday")){
            storycontentstring=getIntent().getStringExtra("birthday");
            TextView birth=findViewById(R.id.storycontent);
            birth.setText(storycontentstring);
        }

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.share) {
            Intent sharestory=new Intent();


            sharestory.setAction(Intent.ACTION_SEND);
            sharestory.putExtra(Intent.EXTRA_TEXT,
                    storycontentstring + "\n\n "+"Samraat app");
            sharestory.setType("text/plain");
            startActivity(sharestory);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}