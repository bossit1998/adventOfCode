package org.example.adventofcode2021.models;

public class Instruction {
    private String command;
    private Integer unit;

    public Instruction(String command, Integer unit) {
        this.command = command;
        this.unit = unit;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public Integer getUnit() {
        return unit;
    }

    public void setUnit(Integer unit) {
        this.unit = unit;
    }
}
