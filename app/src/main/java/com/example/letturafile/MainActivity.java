package com.example.letturafile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private String[][] mat= new String[18][18];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        readWeatherData();
    }

    private List<Obstacle> obstacles= new ArrayList<>();

    private void readWeatherData(){
        InputStream is = getResources().openRawResource(R.raw.mappa);
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(is, Charset.forName("UTF-8"))
        );

        String line = "";
        int n=0;
        try{
            while((line = reader.readLine()) != null) {
                String[] tokens = line.split(",");//tipo di carattere che distanzia gli elementi del file csv

                Obstacle sample = new Obstacle();

                for (int i = 0; i < 16; i++){
                sample.setObstacle(Integer.parseInt(tokens[i]));
                mat[i][n]=tokens[i];
                }

                obstacles.add(sample);
                n++;
                Log.d("MyActivity","Just created" + sample);
            }
        } catch (IOException e){
            Log.wtf("MyActivity", "Error reading data file on line" + line, e);
            e.printStackTrace();
        }
    }
}
