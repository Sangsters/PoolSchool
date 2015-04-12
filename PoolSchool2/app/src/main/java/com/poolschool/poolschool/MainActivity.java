package com.poolschool.poolschool;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener {
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
            setContentView(R.layout.drills);
        else if(v==fundamental)
            setContentView(R.layout.fundamental);
        else if(v==league)
            setContentView(R.layout.league);

    }



}
