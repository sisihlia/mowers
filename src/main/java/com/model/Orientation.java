package com.model;

public enum Orientation {
    E ("E"),
    N ("N"),
    W ("W"),
    S ("S");

    private  String OrientationCode;
    Orientation (String OrientationCode) {
        this.OrientationCode=OrientationCode;
    }

    public String getOrientationCode() {
        return this.OrientationCode;
    }


}
