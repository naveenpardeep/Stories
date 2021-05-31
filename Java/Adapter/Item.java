package com.ramsarup.ramsarup.Adapter;

import android.content.Context;
import android.widget.ImageView;

import com.ramsarup.ramsarup.R;

public class Item {
    private String storyheading,shayri,gharelunuskhe,jobs,facts,Jokes,horoscope,news,success,birthday;


    Context context;

    public Item() {

    }

    public String getStoryheading() {
        return storyheading;
    }

    public void setStoryheading(String storyheading) {
        this.storyheading = storyheading;
    }

    public String getJokes() {
        return Jokes;
    }

    public void setJokes(String jokes) {
        Jokes = jokes;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getShayri() {
        return shayri;
    }
    public void setShayri(String shayri) {
        this.shayri = shayri;
    }
    public String getGharelunuskhe() {
        return gharelunuskhe;
    }

    public String getJobs() {
        return jobs;
    }

    public String getFacts() {
        return facts;
    }

    public String getHoroscope() {
        return horoscope;
    }

    public String getNews() {
        return news;
    }

    public String getSuccess() {
        return success;
    }



    public void setGharelunuskhe(String gharelunuskhe) {
        this.gharelunuskhe = gharelunuskhe;
    }

    public void setJobs(String jobs) {
        this.jobs = jobs;
    }

    public void setFacts(String facts) {
        this.facts = facts;
    }

    public void setHoroscope(String horoscope) {
        this.horoscope = horoscope;
    }

    public void setNews(String news) {
        this.news = news;
    }

    public void setSuccess(String success) {
        this.success = success;
    }
}
