package com.example.letturafile;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

class Obstacle {
    private int[][] mat= new int[30][16];

    private Context context;

    Obstacle(Context current){
        this.context = current;

    }

    void readMap(){
        InputStream is = context.getResources().openRawResource(R.raw.mappa);
        //getResources is a method that belongs to Activity class and it's used to read files from res file
        //we need to use context because Obstacle doesn't extend Activity
        BufferedReader reader = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));

        String line = "";
        int i = 0;

        try{
            while((line = reader.readLine()) != null) {
                String[] tokens = line.split(",");
                //serve per dividere le righe del file csv.
                // Gli passo come parametro il carattere che utilizza come divisione

                for (int j = 0; j < 16; j++){
                    if(Integer.parseInt(tokens[j]) == -1)
                        mat[i][j] = 0;
                    else
                        mat[i][j] = 1;
                }

                i++;

            }
        } catch (IOException e){
            Log.wtf("MyActivity", "Error reading data file on line" + line, e);
            e.printStackTrace();
        }
    }

    void stampMatrix(){
        for (int[] ints : this.mat) { //foreach
            for (int j = 0; j < this.mat[0].length; j++)
                System.out.print(ints[j]);
            System.out.println("");
        }
    }


}
