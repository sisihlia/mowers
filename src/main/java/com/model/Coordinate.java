package com.model;

public class Coordinate {

    public int x;
    public int y;
    public boolean isOccupied;


    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;

    }

    public void setOccupied() {
        this.isOccupied=true;
    }

    public void unsetOccupied() {
        this.isOccupied=false;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return x + " "+ y;
    }


    public boolean equals(Coordinate b) {
        return (0 == Integer.compare(getX(),b.getX())) && (0 ==Integer.compare(this.getY(), b.getY()));

    }

    public boolean isValidCoordinate(Lawn lawn) {
        return (this.getX() >= 0 && this.getX() <= lawn.getWidth() &&
                this.getY() >= 0 && this.getY() <= lawn.getHeight());
    }
}
