package com.model;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
public class MowerTest {

    Lawn lawn = new Lawn(5,5);

    @Test
    public void should_create_mower(){
        char [] ins = {'L','F','F'};
        Mower mower= new Mower(new Coordinate(1,2), Orientation.N, ins);

        assertEquals(mower.getCoordinate().toString(),"1 2");
        assertEquals(""+mower.getOriantation(),""+Orientation.N);
        assertEquals(new String(mower.getInstruction()), "LFF" );
    }
    @Test
    public void should_turn_mower_to_left_right(){
        Mower mower= new Mower(new Coordinate(1,2), Orientation.N);

        mower.turnLeft();
        assertEquals(mower.getOriantation(),Orientation.W);
        mower.turnLeft();
        assertEquals(mower.getOriantation(),Orientation.S);
        mower.turnRight();
        assertEquals(mower.getOriantation(),Orientation.W);
    }
    @Test
    public void should_move_mower_forward() {
        char [] ins = {'L','F','L','F','L','F','L','F','F'};
        Mower mower= new Mower(new Coordinate(1,2), Orientation.N);
        mower.move(lawn,ins);
        assertEquals(mower.getCoordinate().toString(),"1 3");
        assertEquals(""+mower.getOriantation(),""+Orientation.N);

        char [] ins2 = {'F','F','R','F','F','R','F','R','R','F'};
        Mower mower2= new Mower(new Coordinate(3,3), Orientation.E);
        mower2.move(lawn,ins2);
        assertEquals(mower2.getCoordinate().toString(),"5 1");
        assertEquals(""+mower2.getOriantation(),""+Orientation.E);
    }


}
