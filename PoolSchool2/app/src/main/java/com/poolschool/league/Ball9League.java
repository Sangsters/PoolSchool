package com.poolschool.league;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.poolschool.fundamental.FundamentI;
import com.poolschool.poolschool.R;

import java.util.ArrayList;

public class Ball9League extends Activity {
    ArrayList<Ball9LeagueScoreClass> myLeague = new ArrayList<Ball9LeagueScoreClass>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ball9_league);

        populateFundamentalI();
        populateListView();
    }
    private void populateFundamentalI(){

    }



    private void populateListView(){
        ArrayAdapter<FundamentI> adapter = new MyListAdapter();
        ListView list = (ListView) findViewById(R.id.fundListView);
        list.setAdapter(adapter);
    }
    private class MyListAdapter extends ArrayAdapter{
        public MyListAdapter(){
            super(Ball9League.this, R.layout.ball9leaguescorestruct,myLeague);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent){
            View itemView = convertView;
            if(itemView == null){
                itemView = getLayoutInflater().inflate(R.layout.ball9leaguescorestruct, parent, false);
            }

            Ball9LeagueScoreClass  currentLeague = myLeague.get(position);


            //find the view
            //ImageView imageView = (ImageView) itemView.findViewById(R.id.fundImageView);
            //imageView.setImageResource(currentLeague.getName());

            //TextView makeText=(TextView) itemView.findViewById(R.id.fundTextView);
            //makeText.setText(currentFundamental.getText());
            return itemView;

        }
    }

}
