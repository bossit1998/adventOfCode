package org.example.adventofcode2021.logic;

import org.example.adventofcode2021.models.Instruction;
import org.example.adventofcode2021.utils.MigrationUtil;
import org.example.utils.IOUtil;

import java.util.List;

import static org.example.utils.Constant.generalPath;

public class Day2 {

    public static void main(String[] args) {
        try {
            String filePath = generalPath + "Day2";
            List<String> list = IOUtil.readFileIntoList(filePath);

            if (list == null) {
                System.out.println("Can't read from the file");
            } else {
                List<Instruction> instructions = MigrationUtil.migrateDay2(list);

                part1(instructions);
                part2(instructions);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void part1(List<Instruction> instructions) {
        int depth = 0;
        int position = 0;

        for (Instruction instruction : instructions) {
            switch (instruction.getCommand()) {
                case "forward":
                    position+=instruction.getUnit();
                    break;
                case "down":
                    depth+=instruction.getUnit();
                    break;
                case "up":
                    depth-=instruction.getUnit();
                    break;
            }
        }

        System.out.println("depth = " + depth);
        System.out.println("position = " + position);
        System.out.println("depth*position = " + depth*position);
    }

    public static void part2(List<Instruction> instructions) {
        int depth = 0;
        int position = 0;
        int aim = 0;

        for (Instruction instruction : instructions) {
            switch (instruction.getCommand()) {
                case "forward":
                    position+=instruction.getUnit();
                    depth+=aim*instruction.getUnit();
                    break;
                case "down":
                    aim+=instruction.getUnit();
                    break;
                case "up":
                    aim-=instruction.getUnit();
                    break;
            }
        }

        System.out.println("depth = " + depth);
        System.out.println("position = " + position);
        System.out.println("depth*position = " + depth*position);
    }
}