package com.model;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedDeque;

public final class Lawn {
    private static int width;
    private  static int height;
    private List<Executor> executors = new ArrayList<>();
    private List<Coordinate> coords = new ArrayList<>();
    /*
     A ConcurrentLinkedDeque is an appropriate choice when many threads will share access to a common collection.
     Like most other concurrent collection implementations, this class does not permit the use of null elements.
     Concurrent insertion, removal, and access operations execute safely across multiple threads.
      the size method is NOT a constant-time operation. Because of the asynchronous nature of these deques,
      determining the current number of elements requires a traversal of the elements,
      and so may report inaccurate results if this collection is modified during traversal
     */
    public ConcurrentLinkedDeque<Mower> mowers = new ConcurrentLinkedDeque<>();

    public Lawn(int width, int height) {
        if (width<0) throw new IllegalArgumentException("Width is not valid");
        if (height<0) throw new IllegalArgumentException("Height is not valid");
        this.width = width;
        this.height = height;
    }

    public Lawn (String size) {
        String [] lawn_size=size.split("\\s");
        //Lawn lawn = new Lawn(Integer.parseInt(lawn_size[0]), Integer.parseInt(lawn_size[1]));
        if (width<0) throw new IllegalArgumentException("Width is not valid");
        if (height<0) throw new IllegalArgumentException("Height is not valid");
        try {
            this.width = Integer.parseInt(lawn_size[0]);
            this.height = Integer.parseInt(lawn_size[1]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException ("Lawn size is not valid");
        }
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public ConcurrentLinkedDeque<Mower> getMowers() {
        return mowers;
    }

    public void setMowers(ConcurrentLinkedDeque<Mower> mowers) {
        this.mowers = mowers;
    }


    public ConcurrentLinkedDeque<Mower> parse (List<String> lines) {

        final Map<String, String> mowersAndParam = new HashMap<String, String>();
        try {
            for (int i=1; i< lines.size(); i+=2) {
                mowersAndParam.put(lines.get(i), lines.get(i+1));
            }
        } catch (IndexOutOfBoundsException i) {
            throw new IllegalArgumentException("Input file is not correct");
        }

        for (String str:mowersAndParam.keySet()) {
            String[] arr=str.split("\\s");
            Coordinate c = new Coordinate(Integer.parseInt(arr[0]),Integer.parseInt(arr[1]));
            coords.add(c);
            c.setOccupied();
            if (!c.isValidCoordinate(this)) throw new IllegalArgumentException("Invalid Coordinate");
            Orientation o = Orientation.valueOf(arr[2]);
            char [] i = mowersAndParam.get(str).toCharArray();
            Mower entry= new Mower(c,o,i);
            mowers.add(entry);
        }
        return mowers;
    }

    public void start() {
        Executor e= new Executor(mowers, this);
        e.setCoords(coords);
        executors.add(e);
        executors.stream().forEach(ex -> ex.run());
    }

}
