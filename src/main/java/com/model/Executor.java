package com.model;


import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;

public class Executor extends Thread {

    private ConcurrentLinkedDeque<Mower> mowers;
    private Lawn lawn;
    private List<Coordinate> coords;

    public ConcurrentLinkedDeque<Mower> getMowers() {
        return mowers;
    }

    public void setMowers(ConcurrentLinkedDeque<Mower> mowers) {
        this.mowers = mowers;
    }

    public Lawn getLawn() {
        return lawn;
    }

    public void setLawn(Lawn lawn) {
        this.lawn = lawn;
    }

    public List<Coordinate> getCoords() {
        return coords;
    }

    public void setCoords(List<Coordinate> coords) {
        this.coords = coords;
    }

    public Executor(ConcurrentLinkedDeque<Mower> mowers, Lawn lawn) {
        this.mowers=mowers;
        this.lawn=lawn;
    }

    @Override
    public synchronized void run() {
        for (Mower m:mowers) {
            m.move(lawn,m.getInstruction());
        }

    }
}
