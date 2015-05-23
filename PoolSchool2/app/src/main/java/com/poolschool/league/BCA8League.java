package com.poolschool.league;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.poolschool.poolschool.R;
import com.poolschool.shotMakingDrills.GraphAimToWin;

import org.json.JSONArray;
import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class BCA8League extends Activity {
    private ArrayList<EditText> playerName= new ArrayList<>();
    private ArrayList<ArrayList<EditText>> playerScores = new ArrayList<ArrayList<EditText>>();
    private ArrayList<EditText> playerTotal = new ArrayList<>();
    private ArrayList<EditText> playerAve = new ArrayList<>();
    private EditText homeTeamName ;
    private EditText awayTeamName;
    private TextView homeTeamTotal;
    private TextView awayTeamTotal;
    private Button save;
    private ArrayList<BCA8LeaguePlayer> myPlayer = new ArrayList<>();
    private final int NUMPLAYER=10;
    private FileOutputStream fos;
    private FileInputStream fis;
    private String fileName;
    private String allHomeTeamFile;
    private String allAwayTeamFile;
    private ArrayList<String> homeTeamNameFromFile = new ArrayList<>();
    private ArrayList<String> awayTeamNameFromFile = new ArrayList<>();
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private Date dateNoTime ;
    private EditText date;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bca8league);
        String writeString= "";


        try {
            dateNoTime = sdf.parse(sdf.format(new Date()));
            date= (EditText)findViewById(R.id.BCA8LeagueDate);
            date.setText(dateNoTime.toString().substring(0,10));
        } catch (ParseException e) {
            e.printStackTrace();
        }



        createHomeTeamAndAwayTeamNameAndTotal();
        createPlayerScores();
        createPlayerNameList();
        createPlayerTotal();
        createPlayerAve();
        setPlayerStat();
        addListenerOnButton();



    }

    public void addListenerOnButton() {
        //save the result of the drill
        save = (Button) findViewById(R.id.bca8LeaguePlaySave);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                savePlayer();
                //savePlayerScore();
                //savePlayerTotal();
                //savePlayerAve();
                writeToFile();

            }

        });



    }

    private void writeAllTeamFile(){
        allHomeTeamFile = "BCA8HomeTeamFile1.txt";
        allAwayTeamFile = "BCA8AwayTeamFile1.txt";
        readAllTeamFile(allHomeTeamFile, homeTeamNameFromFile);

        if(!homeTeamNameFromFile.contains(homeTeamName.getText().toString())) {
            try {
                fos = openFileOutput(allHomeTeamFile, MODE_APPEND);
                OutputStreamWriter osw = new OutputStreamWriter(fos);
                osw.write((homeTeamName.getText().toString()+"\n"));
                osw.write("\n");
                osw.close();
                fos.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                System.out.println("File not found. BCA8League");
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Can't write to file BCA8League");
            }
        }

      readAllTeamFile(allAwayTeamFile, awayTeamNameFromFile);
        //get all oppenent team name
        if(!awayTeamNameFromFile.contains(awayTeamName.getText().toString())){
            try {
                fos = openFileOutput(allAwayTeamFile, MODE_APPEND);
                OutputStreamWriter osw = new OutputStreamWriter(fos);
                osw.write((awayTeamName.getText().toString()+"\n"));

                osw.close();
                fos.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                System.out.println("File not found.BCA8League");
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Can't write to file BCA8League");
            }

        }

    }


    private void readAllTeamFile(String allTeamFile, ArrayList<String> teamName){
        String line;


        try {
            fis = openFileInput(allTeamFile);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader buffReader = new BufferedReader(isr);
            line=buffReader.readLine();
            Scanner nextName = new Scanner(line);

            while(nextName.hasNext()){
                teamName.add(nextName.next());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Cant open file for reading BCA8Leageu");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Cant reading from file BCA8Leageu");
        }

    }

    /*
    *method:writeFile()
    * write to file with home team name,all player ave, player, scores, total,
     */
    public void writeToFile(){
        writeAllTeamFile();
        fileName = homeTeamName.getText().toString();

        //JSONArray data = new JSONArray();
        //JSONObject
        try {
            fos = openFileOutput(fileName, MODE_APPEND);
            OutputStreamWriter osw = new OutputStreamWriter(fos);

            //write to file
            osw.write(homeTeamName.getText().toString());
            for (int i = 0; i < myPlayer.size(); i++) {
                osw.write(myPlayer.get(i).getAve());
                osw.write(myPlayer.get(i).getPlayerName());
                osw.write(myPlayer.get(i).getScore1());
                osw.write(myPlayer.get(i).getScore2());
                osw.write(myPlayer.get(i).getScore3());
                Toast.makeText(getBaseContext(), "Drill Saved", Toast.LENGTH_LONG).show();
               // osw.write(myPlayer.get(i).getTotal());

            }
            osw.write(awayTeamName.getText().toString());
            //osw.write(homeTeamTotal.getText().toString());
            //osw.write(awayTeamTotal.getText().toString());

            osw.close();
            fos.close();
            Toast.makeText(getBaseContext(), "Drill Saved", Toast.LENGTH_LONG).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Cant create file BCA8League");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Can't write to file BCA8League ");
        }



    }



    private void savePlayer(){
        for(int i=0;i<10;i++) {
            if (playerName.get(i).getText().toString() != null) {
                myPlayer.add(new BCA8LeaguePlayer());
                myPlayer.get(i).setPlayerName(playerName.get(i).getText().toString());
                System.out.println("saveplayer8888888888888888888888888888"+i);
                if (checkIfNumber(playerAve.get(i).getText().toString()))
                    myPlayer.get(i).setAve(Integer.parseInt(playerAve.get(i).getText().toString()));

                if (checkIfNumber(playerScores.get(i).get(0).getText().toString()))
                    myPlayer.get(i).setScore1(Integer.parseInt(playerScores.get(i).get(0).getText().toString()));
                if (checkIfNumber(playerScores.get(i).get(1).getText().toString()))
                    myPlayer.get(i).setScore2(Integer.parseInt(playerScores.get(i).get(1).getText().toString()));
                if (checkIfNumber(playerScores.get(i).get(2).getText().toString()))
                    myPlayer.get(i).setScore3(Integer.parseInt(playerScores.get(i).get(2).getText().toString()));
            }
        }


    }

    public boolean checkIfNumber(String in) {

        try {

            Integer.parseInt(in);

        } catch (NumberFormatException ex) {
            return false;
        }

        return true;
    }


    private void savePlayerTotal(){
        myPlayer.get(0).setTotal(Integer.parseInt(playerTotal.get(0).getText().toString()));
        myPlayer.get(1).setTotal(Integer.parseInt(playerTotal.get(1).getText().toString()));
        myPlayer.get(2).setTotal(Integer.parseInt(playerTotal.get(2).getText().toString()));
        myPlayer.get(3).setTotal(Integer.parseInt(playerTotal.get(3).getText().toString()));
        myPlayer.get(4).setTotal(Integer.parseInt(playerTotal.get(4).getText().toString()));
        myPlayer.get(5).setTotal(Integer.parseInt(playerTotal.get(5).getText().toString()));
        myPlayer.get(6).setTotal(Integer.parseInt(playerTotal.get(6).getText().toString()));
        myPlayer.get(7).setTotal(Integer.parseInt(playerTotal.get(7).getText().toString()));
        myPlayer.get(8).setTotal(Integer.parseInt(playerTotal.get(8).getText().toString()));
        myPlayer.get(9).setTotal(Integer.parseInt(playerTotal.get(9).getText().toString()));
    }
    private void createHomeTeamAndAwayTeamNameAndTotal(){
        homeTeamName =(EditText)findViewById(R.id.BCA8HomeTeamName);
        awayTeamName = (EditText)findViewById(R.id.BCA8ScoreAwayTeamName);
       // homeTeamTotal=(TextView)findViewById(R.id.BCA8HomeTeamTotalScore);
        //awayTeamTotal=(TextView)findViewById(R.id.BCA8AwayTeamTotalScore);

    }

    //initialize playerTotal
    private void createPlayerTotal(){
        playerTotal.add((EditText)findViewById(R.id.BCA8Player1Total));
        playerTotal.add((EditText)findViewById(R.id.BCA8Player2Total));
        playerTotal.add((EditText)findViewById(R.id.BCA8Player3Total));
        playerTotal.add((EditText)findViewById(R.id.BCA8Player4Total));
        playerTotal.add((EditText)findViewById(R.id.BCA8Player5Total));
        playerTotal.add((EditText)findViewById(R.id.BCA8Player6Total));
        playerTotal.add((EditText)findViewById(R.id.BCA8Player7Total));
        playerTotal.add((EditText)findViewById(R.id.BCA8Player8Total));
        playerTotal.add((EditText)findViewById(R.id.BCA8Player9Total));
        playerTotal.add((EditText)findViewById(R.id.BCA8Player10Total));
    }

    //initialize playerName with 10 player
    private void createPlayerNameList() {
        playerName.add((EditText) findViewById(R.id.BCA8Player1Name));
        playerName.add((EditText) findViewById(R.id.BCA8Player2Name));
        playerName.add((EditText) findViewById(R.id.BCA8Player3Name));
        playerName.add((EditText) findViewById(R.id.BCA8Player4Name));
        playerName.add((EditText) findViewById(R.id.BCA8Player5Name));
        playerName.add((EditText) findViewById(R.id.BCA8Player6Name));
        playerName.add((EditText) findViewById(R.id.BCA8Player7Name));
        playerName.add((EditText) findViewById(R.id.BCA8Player8Name));
        playerName.add((EditText) findViewById(R.id.BCA8Player9Name));
        playerName.add((EditText) findViewById(R.id.BCA8Player10Name));

        for(int i=0;i<playerName.size();i++){
            playerName.get(i).setText(null);
        }

    }

    //initialize playerScore 3 score per player
    private void createPlayerScores(){
        playerScores.add(new ArrayList<EditText>());
        playerScores.get(0).add((EditText)findViewById(R.id.BCA8Player1Score1));
        playerScores.get(0).add((EditText)findViewById(R.id.BCA8Player1Score2));
        playerScores.get(0).add((EditText)findViewById(R.id.BCA8Player1Score3));

        playerScores.add(new ArrayList<EditText>());
        playerScores.get(1).add((EditText) findViewById(R.id.BCA8Player2Score1));
        playerScores.get(1).add((EditText)findViewById(R.id.BCA8Player2Score2));
        playerScores.get(1).add((EditText) findViewById(R.id.BCA8Player2Score3));

        playerScores.add(new ArrayList<EditText>());
        playerScores.get(2).add((EditText) findViewById(R.id.BCA8Player3Score1));
        playerScores.get(2).add((EditText)findViewById(R.id.BCA8Player3Score2));
        playerScores.get(2).add((EditText)findViewById(R.id.BCA8Player3Score3));

        playerScores.add(new ArrayList<EditText>());
        playerScores.get(3).add((EditText) findViewById(R.id.BCA8Player4Score1));
        playerScores.get(3).add((EditText)findViewById(R.id.BCA8Player4Score2));
        playerScores.get(3).add((EditText)findViewById(R.id.BCA8Player4Score3));

        playerScores.add(new ArrayList<EditText>());
        playerScores.get(4).add((EditText) findViewById(R.id.BCA8Player5Score1));
        playerScores.get(4).add((EditText)findViewById(R.id.BCA8Player5Score2));
        playerScores.get(4).add((EditText)findViewById(R.id.BCA8Player5Score3));

        playerScores.add(new ArrayList<EditText>());
        playerScores.get(5).add((EditText) findViewById(R.id.BCA8Player6Score1));
        playerScores.get(5).add((EditText)findViewById(R.id.BCA8Player6Score2));
        playerScores.get(5).add((EditText)findViewById(R.id.BCA8Player6Score3));

        playerScores.add(new ArrayList<EditText>());
        playerScores.get(6).add((EditText) findViewById(R.id.BCA8Player7Score1));
        playerScores.get(6).add((EditText)findViewById(R.id.BCA8Player7Score2));
        playerScores.get(6).add((EditText)findViewById(R.id.BCA8Player7Score3));

        playerScores.add(new ArrayList<EditText>());
        playerScores.get(7).add((EditText) findViewById(R.id.BCA8Player8Score1));
        playerScores.get(7).add((EditText)findViewById(R.id.BCA8Player8Score2));
        playerScores.get(7).add((EditText)findViewById(R.id.BCA8Player8Score3));

        playerScores.add(new ArrayList<EditText>());
        playerScores.get(8).add((EditText) findViewById(R.id.BCA8Player9Score1));
        playerScores.get(8).add((EditText)findViewById(R.id.BCA8Player9Score2));
        playerScores.get(8).add((EditText)findViewById(R.id.BCA8Player9Score3));

        playerScores.add(new ArrayList<EditText>());
        playerScores.get(9).add((EditText) findViewById(R.id.BCA8Player10Score1));
        playerScores.get(9).add((EditText)findViewById(R.id.BCA8Player10Score2));
        playerScores.get(9).add((EditText)findViewById(R.id.BCA8Player10Score3));
    }

    private void createPlayerAve(){
        playerAve.add((EditText)findViewById(R.id.BCA8Player1Avg));
        playerAve.add((EditText)findViewById(R.id.BCA8Player2Avg));
        playerAve.add((EditText)findViewById(R.id.BCA8Player3Avg));
        playerAve.add((EditText)findViewById(R.id.BCA8Player4Avg));
        playerAve.add((EditText)findViewById(R.id.BCA8Player5Avg));
        playerAve.add((EditText)findViewById(R.id.BCA8Player6Avg));
        playerAve.add((EditText)findViewById(R.id.BCA8Player7Avg));
        playerAve.add((EditText)findViewById(R.id.BCA8Player8Avg));
        playerAve.add((EditText)findViewById(R.id.BCA8Player9Avg));
        playerAve.add((EditText)findViewById(R.id.BCA8Player10Avg));
    }

    //for test purpose so i don't have type it in each time
    private void setPlayerStat(){
        playerName.get(0).setText("john");
        playerTotal.get(0).setText("3");
        playerScores.get(0).get(0).setText("1");
        playerScores.get(0).get(1).setText("1");
        playerScores.get(0).get(2).setText("1");

        playerName.get(5).setText("mark");
        homeTeamName.setText("rock");
        awayTeamName.setText("devil");
        playerScores.get(5).get(0).setText("1");
        playerScores.get(5).get(1).setText("1");
        playerScores.get(5).get(2).setText("1");
        playerTotal.get(5).setText("3");


    }


}
