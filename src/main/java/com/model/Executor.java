package com.model;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;

public class Executor extends Thread {

    private ConcurrentLinkedDeque<Mower> mowers;
    private Lawn lawn;
    private static List<Coordinate> coords = new ArrayList<>();

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

    public  List<Coordinate> getCoords() {
        return coords;
    }

    public void setCoords(List<Coordinate> coords) {
        coords = coords;
    }

    public Executor(ConcurrentLinkedDeque<Mower> mowers, Lawn lawn) {
        this.mowers=mowers;
        this.lawn=lawn;
    }

    public static boolean allowedToMove(Coordinate m) {
//        for(Coordinate c:coords){
//            return m.equals(c);
//        }
//       return false;

        return coords.stream().filter(c-> c.equals(m)).findAny().isPresent();
    }

    public synchronized static void addCoordinate(Coordinate c) {
        coords.add(c);
    }

    public synchronized static void removeCoordinate(Coordinate c) {
        coords.remove(c);
    }
    @Override
    public synchronized void run() {
        for (Mower m:mowers) {

            m.move(lawn,m.getInstruction());
        }

    }
}
