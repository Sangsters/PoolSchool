package com.poolschool.league;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.poolschool.drill.CueBallControl;
import com.poolschool.drill.KickDrills;
import com.poolschool.drill.SafetyDrills;
import com.poolschool.drill.ShotMakingDrillList;
import com.poolschool.poolschool.R;

public class League extends ActionBarActivity {
    private Button BCA8Ball, BCA9Ball;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_league);

        addListenerOnButton();
    }
    public void addListenerOnButton(){

        BCA8Ball = (Button) findViewById(R.id.BCA8ballLeagueButton);
        BCA8Ball.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(getApplicationContext(), BCA8League.class);
                startActivity(intent);
            }
        });

        BCA9Ball = (Button) findViewById(R.id.BCA9BallLeagueButton);
        BCA9Ball.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(getApplicationContext(), Ball9League.class);
                startActivity(intent);
            }
        });

    }



}
