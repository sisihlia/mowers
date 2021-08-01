package com.model;

public class Mower implements Movement {

    private Orientation orientation;
    private Coordinate coordinate;
    private char[] instruction;
    private Lawn lawn;

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

//    public void turnLeft() {
//        switch (this.orientation) {
//            case N:
//                this.orientation=Orientation.W;
//                break;
//            case E:
//                this.orientation=Orientation.N;
//                break;
//            case S:
//                this.orientation=Orientation.E;
//                break;
//            case W:
//                this.orientation=Orientation.S;
//                break;
//            default:
//                throw new IllegalArgumentException("Invalid direction");
//
//        }
//    }
//
//    public void turnRight() {
//        switch (this.orientation) {
//            case N:
//                this.orientation=Orientation.E;
//                break;
//            case E:
//                this.orientation=Orientation.S;
//                break;
//            case S:
//                this.orientation=Orientation.W;
//                break;
//            case W:
//                this.orientation=Orientation.N;
//                break;
//            default:
//                throw new IllegalArgumentException("Invalid direction");
//        }
//    }


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
        if (!next.isOccupied) {
            if (next.isValidCoordinate(lawn)){
                this.getCoordinate().unsetOccupied();
                this.setCoordinate(next);
            }
        }

    }

    public void move(Lawn lawn, char[] c) {
        this.lawn=lawn;

        for (char i : c ) {
            switch(Instruction.valueOf(String.valueOf(i))) {
                case L:
                    turnLeft();
                    break;
                case R:
                    turnRight();
                    break;
                case F:
                    moveForward();
                    break;
                default:
                    break;

            }
        }
//        for (char i :c) {
//            Instruction in = Instruction.valueOf(String.valueOf(i)){
//
//            }
//        }

    }

}
