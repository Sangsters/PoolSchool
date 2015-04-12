package com.poolschool.drill;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.poolschool.poolschool.R;

/**
 * Created by OWNER-PC on 4/11/2015.
 */
public class CueBallControl extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cueballcontrol);

        populateListView();
    }

    private void populateListView() {
        //create list of Item
        String[] cueBallControlDrills = {"Progressive Drill 1", "Progressive Drill 2", "Progressive Drill 3"};

        //build adapter  context, layout to use, item to display
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.cueballcontrollist,cueBallControlDrills);

        //configure
        ListView list = (ListView) findViewById(R.id.cueBallControlListView);
        list.setAdapter(adapter);
    }





}
