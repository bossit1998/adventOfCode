package org.example.adventofcode2021.utils;

import org.example.adventofcode2021.models.Instruction;

import java.util.ArrayList;
import java.util.List;

public class MigrationUtil {

    public static List<Integer> migrateDay1(List<String> depthListAsString) {
        List<Integer> depthList = new ArrayList<>();

        for (String depth : depthListAsString) {
            depthList.add(Integer.valueOf(depth));
        }

        return depthList;
    }

    public static List<Instruction> migrateDay2(List<String> instructions) {
        List<Instruction> instructionList = new ArrayList<>();

        for (String instruction : instructions) {
            String[] ins = instruction.split(" ");
            instructionList.add(new Instruction(ins[0],Integer.valueOf(ins[1])));
        }

        return instructionList;
    }
}