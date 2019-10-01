package com.example.letturafile;

class Obstacle {

    private int obstacle;

    public int getObstacle() {
        return obstacle;
    }

    public void setObstacle(int obstacle) {
        this.obstacle = obstacle;
    }

    @Override
    public String toString() {
        return "obstacle=" + obstacle;
    }
}
