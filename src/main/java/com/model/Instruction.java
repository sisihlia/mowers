package com.model;

import java.util.Arrays;

public enum Instruction {
    /*
    get rid of the switch statement used before and implement method for each enum:
     */
    L ("L") {
        public void execute(Mower m) {
              m.turnLeft();
        }
    },
    R ("R") {
        public void execute(Mower m) {
            m.turnRight();
        }
    },
    F ("F") {
        public void execute(Mower m) {
            m.moveForward();
        }
    };


    public void execute(Mower m){

    }


    private  String instructionCode;
    Instruction (String InstructionCode) {
        this.instructionCode=InstructionCode;
    }

    public static Instruction getInstruction(String instructionCode) {
        for (Instruction i : values()) {
            if (i.getInstructionCode().equals(instructionCode)){
                return i;
            }
        }
        throw new IllegalArgumentException();
    }
    public String getInstructionCode() {
        return this.instructionCode;
    }




}
