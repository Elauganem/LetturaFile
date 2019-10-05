package com.example.letturafile;

import android.content.Context;
import android.graphics.Rect;
import android.util.Log;

import androidx.constraintlayout.solver.widgets.Rectangle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;

class Obstacle {
    private static int[][] mat= new int[30][17];
    //private int rectCounter;

    //static ArrayList<Rect> plot = new ArrayList<>();

    private static Context context;
/*
    Obstacle(Context current){
        this.context = current;

    }*/

    static void setContext(Context cont){
        context = cont;
    }

    static void readMap(){
        InputStream is = context.getResources().openRawResource(R.raw.livello);
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

                for (int j = 0; j < 17; j++){
                    if(Integer.parseInt(tokens[j]) == -1)
                        mat[i][j] = 0; //nono ci stanno oggetti
                    else
                        mat[i][j] = 1;//c'è un ostacolo
                        //rectCounter++;
                }

                i++;

            }
        } catch (IOException e){
            Log.wtf("MyActivity", "Error reading data file on line" + line, e);
            e.printStackTrace();
        }
    } //legge il file csv e mette i numeri dentri mat[][]

    static void stampMatrix(){
        for (int i = 0; i < mat.length; i++) { //foreach
            for (int j = 0; j < mat[0].length; j++)
                System.out.print(mat[i][j]);
            System.out.println("");
        }
    } //stampa nel terminale la matrice di 0 e 1
/*
    static void createObstacles(){
        for(int i = 0; i < mat.length; i++)
            for(int j = 0; j < mat[0].length; j++){
                if(mat[i][j] == 1){
                    Rect rect = new Rect(i*16,j*16, (i*16)+16,(j*16)+16);
                    plot.add(rect);
                }
            }


    }*/

     static int[][] getMat(){
        int[][] matrix = new int[mat.length][mat[0].length];
        for(int i = 0; i < mat.length; i++)
            for(int j = 0; j < mat[0].length; j++){
                matrix[i][j] = mat[i][j];
        }

        return matrix;
    } //ritorna la matrice mat[][]


}
