package com.poolschool.poolschool;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.poolschool.drill.CueBallControl;
import com.poolschool.drill.KickDrills;
import com.poolschool.drill.SafetyDrills;
import com.poolschool.drill.ShotMakingDrillList;


/**
 * Created by OWNER-PC on 4/11/2015.
 */
    public class Drills extends Activity {
        private Button cueBallControl, safety, kick, shotMaking;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drills);

        //cueBallControl = (Button) findViewById(R.id.cueBallControl);
       // shotMaking = (Button) findViewById(R.id.shotMaking);
       // kick = (Button) findViewById(R.id.kick);
        //safety = (Button) findViewById(R.id.safety);
        addListenerOnButton();

        //cueBallControl.setOnClickListener(this);
        //shotMaking.setOnClickListener(this);
        //kick.setOnClickListener(this);
        //safety.setOnClickListener(this);

    }
    public void addListenerOnButton(){

        cueBallControl = (Button) findViewById(R.id.cueBallControl);
        cueBallControl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(getApplicationContext(), CueBallControl.class);
                startActivity(intent);
            }
        });

        safety = (Button) findViewById(R.id.safety);
        safety.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(getApplicationContext(), SafetyDrills.class);
                startActivity(intent);
            }
        });
        kick = (Button) findViewById(R.id.kick);
        kick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(getApplicationContext(), KickDrills.class);
                startActivity(intent);
            }
        });
        shotMaking =(Button) findViewById(R.id.shotMaking);
        shotMaking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(getApplicationContext(), ShotMakingDrillList.class);
                startActivity(intent);
            }
        });
    }

}
