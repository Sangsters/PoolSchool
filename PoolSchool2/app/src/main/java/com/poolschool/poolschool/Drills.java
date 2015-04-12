package com.poolschool.poolschool;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;



/**
 * Created by OWNER-PC on 4/11/2015.
 */
    public class Drills extends Activity implements View.OnClickListener{
        private Button cueBallControl, safety, kick, shotMaking;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drills);

        cueBallControl = (Button) findViewById(R.id.cueBallControl);
        shotMaking = (Button) findViewById(R.id.shotMaking);
        kick = (Button) findViewById(R.id.kick);
        safety = (Button) findViewById(R.id.safety);

        cueBallControl.setOnClickListener(this);
        shotMaking.setOnClickListener(this);
        kick.setOnClickListener(this);
        safety.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        if(v==cueBallControl)
            setContentView(R.layout.cueballcontrollist);
        else if(v==safety)
            setContentView(R.layout.safetydrill);
        else if(v==kick)
            setContentView(R.layout.kickdrill);
        else if(v==shotMaking)
            setContentView(R.layout.shotmakingdrill);


    }
}
