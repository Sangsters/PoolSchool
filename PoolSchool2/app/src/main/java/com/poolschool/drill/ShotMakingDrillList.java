package com.poolschool.drill;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.poolschool.SafetyDrill.DuckAndCover;
import com.poolschool.SafetyDrill.HalfTableSafety;
import com.poolschool.SafetyDrill.SafetyOrNot;
import com.poolschool.poolschool.R;
import com.poolschool.shotMakingDrills.AimToWin;
import com.poolschool.shotMakingDrills.Pocket9Drill;
import com.poolschool.shotMakingDrills.RailShot;

public class ShotMakingDrillList extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shotmakingdrill);

        populateListView();
        registerClickCallback();

    }
    private void registerClickCallback() {
        ListView list = (ListView) findViewById(R.id.shotMakingListView);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView textView = (TextView) view;
                if(position==0){
                    Intent intent;
                    intent = new Intent(getApplicationContext(),RailShot.class);
                    startActivity(intent);
                }
                else if(position==1){
                    Intent intent;
                    intent = new Intent(getApplicationContext(),Pocket9Drill.class);
                    startActivity(intent);
                }
                else if(position==2){
                    Intent intent;
                    intent = new Intent(getApplicationContext(),AimToWin.class);
                    startActivity(intent);
                }

            }
        });
    }

    private void populateListView() {
        //create list of Item
        String[] cueBallControlDrills = {"Aim To Win", "Pocket the 9", "Rail Shot"};

        //build adapter  context, layout to use, item to display
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.cueballcontrollist, cueBallControlDrills);

        //configure
        ListView list = (ListView) findViewById(R.id.shotMakingListView);
        list.setAdapter(adapter);
    }


}
