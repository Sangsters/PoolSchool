package com.poolschool.league;

import android.app.Activity;
import android.os.Bundle;
import com.poolschool.poolschool.R;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class LeagueSearchResult extends Activity {
    //private FileInputStream fis;
    //private String fileName;
    // private String [] teamName;


     @Override
    protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.league_search_result);

         // Bundle extras = getIntent().getExtras();
         //if(extras != null){
         //teamName = extras.getStringArray("key");
         //}

         // }
     }

}