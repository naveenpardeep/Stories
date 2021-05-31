package com.ramsarup.ramsarup;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.ramsarup.ramsarup.fragments.Horoscope;
import com.ramsarup.ramsarup.fragments.News;
import com.ramsarup.ramsarup.fragments.Stories;
import com.ramsarup.ramsarup.R;
import com.ramsarup.ramsarup.fragments.Birthday;
import com.ramsarup.ramsarup.fragments.Facts;
import com.ramsarup.ramsarup.fragments.Gharelunuskhe;
import com.ramsarup.ramsarup.fragments.Jobs;
import com.ramsarup.ramsarup.fragments.Shayri;
import com.ramsarup.ramsarup.fragments.Jokes;
import com.ramsarup.ramsarup.fragments.Success;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
         {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        android.net.NetworkInfo wifi = cm
                .getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        android.net.NetworkInfo datac = cm
                .getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        if ((wifi != null & datac != null)
                && (wifi.isConnected() | datac.isConnected())) {
            Toast.makeText(this,"Wait Loading from server",Toast.LENGTH_LONG).show();
        }else{
            //no connection
            Toast toast = Toast.makeText(MainActivity.this, "No Internet Connection", Toast.LENGTH_LONG);
            toast.show();
        }

     //   getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
     //tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
     //   FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
     //   fab.setOnClickListener(new View.OnClickListener() {
   //         @Override
    //        public void onClick(View view) {
    //            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
    //                    .setAction("Action", null).show();
    //        }
     //   });

    //    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
   //     ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
   //             this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
   //     drawer.addDrawerListener(toggle);
   //     toggle.syncState();

    //    NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
    //    navigationView.setNavigationItemSelectedListener(this);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new Jokes(),"Jokes");
        adapter.addFragment(new Horoscope(),"Horoscope");
        adapter.addFragment(new News(),"News");
        adapter.addFragment(new Jobs(),"Jobs");
        adapter.addFragment(new Success(), "Success Stories");
        adapter.addFragment(new Facts(),"Facts");
        adapter.addFragment(new Gharelunuskhe(),"Gharelu Nuskhe");
        adapter.addFragment(new Shayri() ,"Shayri ");
        adapter.addFragment(new Stories(), "Stories");
        adapter.addFragment(new Birthday(),"Birthday Wish");





        viewPager.setAdapter(adapter);
    }
    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

  //  @Override
  //  public void onBackPressed() {
  //      DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
   //     if (drawer.isDrawerOpen(GravityCompat.START)) {
   //         drawer.closeDrawer(GravityCompat.START);
   //     } else {
    //        super.onBackPressed();
    //    }
   // }

 //   @Override
  //  public boolean onCreateOptionsMenu(Menu menu) {
  //      // Inflate the menu; this adds items to the action bar if it is present.
  //      getMenuInflater().inflate(R.menu.main, menu);
   //     return true;
   // }

  /*  @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.share) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }*/
}
