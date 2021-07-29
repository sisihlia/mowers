package com.model;

import java.util.Arrays;

public enum Instruction {
    L ("L"),
    R ("R"),
    F ("F");

    private  String InstructionCode;
    Instruction (String InstructionCode) {
        this.InstructionCode=InstructionCode;
    }


    public String getInstructionCode() {
        return this.InstructionCode;
    }



}
