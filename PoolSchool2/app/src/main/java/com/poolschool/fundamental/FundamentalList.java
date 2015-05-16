package com.poolschool.fundamental;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.poolschool.CueBallControlDrills.ProgressiveDrill1;
import com.poolschool.CueBallControlDrills.ProgressivePositionDrill2;
import com.poolschool.CueBallControlDrills.ProgressivePositionDrill3;
import com.poolschool.poolschool.R;

import java.util.ArrayList;

public class FundamentalList extends Activity {
    ArrayList<FundamentI> imageList =  new ArrayList<FundamentI>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fundamental_list);

      populateFundamentalI();
      populateListView();




    }

    private void populateFundamentalI(){
        imageList.add(new FundamentI(R.drawable.drill_positionprogressive, "Something"));
        imageList.add(new FundamentI(R.drawable.duckandcover, "Duck and Cover"));
        imageList.add(new FundamentI(R.drawable.safeornot,"Play safe or not"));
    }



    private void populateListView(){
        ArrayAdapter<FundamentI> adapter = new MyListAdapter();
        ListView list = (ListView) findViewById(R.id.fundListView);
        list.setAdapter(adapter);
    }
private class MyListAdapter extends ArrayAdapter{
    public MyListAdapter(){
        super(FundamentalList.this, R.layout.fundlistviewstruct,imageList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View itemView = convertView;
        if(itemView == null){
            itemView = getLayoutInflater().inflate(R.layout.fundlistviewstruct, parent, false);
        }

        FundamentI  currentFundamental = imageList.get(position);


        //find the view
        ImageView imageView = (ImageView) itemView.findViewById(R.id.fundImageView);
        imageView.setImageResource(currentFundamental.getImage());

        TextView makeText=(TextView) itemView.findViewById(R.id.fundTextView);
        makeText.setText(currentFundamental.getText());
        return itemView;

    }
}

}
