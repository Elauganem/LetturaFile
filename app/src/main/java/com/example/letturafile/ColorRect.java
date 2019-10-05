package com.example.letturafile;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

import java.util.ArrayList;

import static android.graphics.Color.BLACK;


public class ColorRect extends View {

    private Context context;

    int[][] mat;
    static ArrayList<Rect> plot = new ArrayList<>();

    private Paint paint;

    public ColorRect(Context context) {
        super(context);
        mat = Obstacle.getMat();
        createObstacles();
        // create the Paint and set its color
        paint = new Paint();
        paint.setColor(Color.GRAY);
    }

    void createObstacles(){
        for(int i = 0; i < mat.length; i++)
            for(int j = 0; j < mat[0].length; j++){
                if(mat[i][j] == 1){
                    Rect rect = new Rect(j*64,i*64, (j*64)+64,(i*64)+64);
                    plot.add(rect);
                }
            }


    }

    void setContext(Context cont){
        context = cont;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(BLACK);
        @SuppressLint("DrawAllocation") Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.livello_1080x1920);

        canvas.drawBitmap(bitmap,5,0, paint);
        for(int i = 0; i < plot.size(); i++) {
            canvas.drawRect(plot.get(i), paint);
        }
    }

}
