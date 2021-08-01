package com.model;

public enum Orientation {


    E ("E") {
        @Override
        public Orientation turnLeft() {
                return Orientation.N;
        }
        @Override
        public Orientation turnRight() {
            return Orientation.S;

        }
    },
    N ("N"){
        @Override
        public Orientation turnLeft() {
            return Orientation.W;
        }
        @Override
        public Orientation turnRight() {
            return Orientation.E;

        }
    },
    W ("W"){
        @Override
        public Orientation turnLeft() {
            return Orientation.S;
        }
        @Override
        public Orientation turnRight() {
            return Orientation.N;

        }
    },
    S ("S"){
        @Override
        public Orientation turnLeft() {
            return Orientation.E;
        }
        @Override
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
