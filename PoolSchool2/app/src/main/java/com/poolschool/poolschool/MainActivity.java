package com.poolschool.poolschool;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.poolschool.fundamental.FundamentalList;
import com.poolschool.league.League;

public class MainActivity extends Activity implements View.OnClickListener{
    private Button drill, fundamental,league;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drill = (Button) findViewById(R.id.drill);
        fundamental = (Button) findViewById(R.id.fundamental);
        league = (Button) findViewById(R.id.league);

        drill.setOnClickListener(this);
        fundamental.setOnClickListener(this);
        league.setOnClickListener(this);


    }

    @Override
    public void onClick(View v){

        if(v==drill)
            startActivity(new Intent(this, Drills.class));
        else if(v==fundamental)
            startActivity(new Intent(this, FundamentalList.class));
        else if(v==league)
            startActivity(new Intent(this, League.class));

    }



}
