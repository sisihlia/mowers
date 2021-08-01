package com.model;

import java.util.List;

public class Mower implements Movement {

    private Orientation orientation;
    private Coordinate coordinate;
    private char[] instruction;
    private Lawn lawn;
    private List<Coordinate> coords;

    public Mower(Coordinate coordinate, Orientation orientation, char [] instruction) {
        this.orientation=orientation;
        this.coordinate = coordinate;
        this.instruction=instruction;
    }


    public Mower(Coordinate coordinate, Orientation orientation) {
        this.orientation=orientation;
        this.coordinate = coordinate;
    }

    public Orientation getOriantation() {
        return orientation;
    }

    public void setOriantation(Orientation orientation) {
        this.orientation = orientation;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public char [] getInstruction() {
        return instruction;
    }

    public void setInstruction(char [] instruction) {
        this.instruction = instruction;
    }


    public void turnLeft() {
        this.setOriantation(this.getOriantation().turnLeft());
    };


    public void turnRight(){
        this.setOriantation(this.getOriantation().turnRight());
    }

    public void moveForward(){
        Coordinate next=null;
        switch(this.orientation) {
            case N:
                next=new Coordinate(this.getCoordinate().getX(),this.getCoordinate().getY()+1);
                break;
            case E:
                next=new Coordinate(this.getCoordinate().getX()+1,this.getCoordinate().getY());
                break;
            case S:
                next=new Coordinate(this.getCoordinate().getX(),this.getCoordinate().getY()-1);
                break;
            case W:
                next=new Coordinate(this.getCoordinate().getX()-1,this.getCoordinate().getY());
                break;
            default:
                throw new IllegalArgumentException("Invalid direction");
        }
        System.out.println(Executor.allowedToMove(this.getCoordinate()));
        if (!Executor.allowedToMove(next)) {
            if (next.isValidCoordinate(lawn)){
                Executor.removeCoordinate(this.getCoordinate());
                this.setCoordinate(next);
                Executor.addCoordinate(this.getCoordinate());
            }
        }
    }

    public void move(Lawn lawn, char[] c) {
        this.lawn=lawn;
        for (char i :c) {
            Instruction in = Instruction.getInstruction(String.valueOf(i));
            in.execute(this);

        }

    }

}
