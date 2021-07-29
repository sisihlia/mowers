package com.model;


import java.util.concurrent.ConcurrentLinkedDeque;

public class Executor extends Thread {

    private ConcurrentLinkedDeque<Mower> mowers;
    private Lawn lawn;

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
