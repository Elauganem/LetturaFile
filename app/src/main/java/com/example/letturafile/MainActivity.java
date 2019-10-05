package com.example.letturafile;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Obstacle obstacle = new Obstacle(this);

        Obstacle.setContext(this);
        Obstacle.readMap();
        //Obstacle.createObstacles();
        Obstacle.stampMatrix();
        setContentView(new ColorRect(this));
        //setContentView(R.layout.activity_main);


    }

}
