package com.model;

public enum Orientation {


    E ("E") {
        public Orientation turnLeft() {
                return Orientation.N;
        }
        public Orientation turnRight() {
            return Orientation.S;

        }
    },
    N ("N"){
        public Orientation turnLeft() {
            return Orientation.W;
        }
        public Orientation turnRight() {
            return Orientation.E;

        }
    },
    W ("W"){
        public Orientation turnLeft() {
            return Orientation.S;
        }
        public Orientation turnRight() {
            return Orientation.N;

        }
    },
    S ("S"){
        public Orientation turnLeft() {
            return Orientation.E;
        }
        public Orientation turnRight() {
            return Orientation.W;

        }
    };

    /*
     If an enum class has an abstract method, then each instance of the enum class must implement it
     */
    public abstract Orientation turnLeft();

    public abstract Orientation turnRight();

    private  String OrientationCode;
    Orientation (String OrientationCode) {
        this.OrientationCode=OrientationCode;
    }

    public String getOrientationCode() {
        return this.OrientationCode;
    }


}
