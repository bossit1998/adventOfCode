package org.example.adventofcode2022.logic;

import org.example.adventofcode2022.models.RopeHeadMove;
import org.example.adventofcode2022.models.RopeKnot;
import org.example.utils.IOUtil;

import java.util.ArrayList;
import java.util.List;

import static org.example.adventofcode2022.utils.MigrationUtil.migrateDay9;
import static org.example.utils.Constant.generalPath;

public class Day10 {

    public static void main(String[] args) {
        try {
            String filePath = generalPath + "Day10";
            List<String> list = IOUtil.readFileIntoList(filePath);

            if (list == null) {
                System.out.println("Can't read from the file");
            } else {
                part1(list);
                part2(list);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void part1(List<String> list) {
        int registerX = 1;
        int cycle = 0;
        int sum = 0;
        int instructionCount = 0;
        for(String instruction : list) {
            instructionCount++;
//            System.out.println(instructionCount);

            if (instruction.contains("noop")) {
                cycle++;

                if ((cycle-20)%40==0) {
                    sum=sum+(registerX*cycle);
                }
            } else {
                for (int i=0; i<2; i++) {
                    cycle++;

                    if (registerX==18) {
                        System.out.println(registerX);
                    }

                    if ((cycle-20)%40==0) {
                        sum=sum+(registerX*cycle);
                    }

                    if (i==1) {
                        String[] parts = instruction.split(" ");
                        registerX+=Integer.parseInt(parts[1]);
                    }
                }
            }
        }

        lap(sum);
    }

    public static void part2(List<String> list) {

    }

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";

    private static long timerStart;
    private static int part = 1;

    public static void lap(long answer) {
        lap(String.valueOf(answer));
    }

    public static String timeToString(long timeSpent) {
        if (timeSpent < 1000)
            return timeSpent + "µs";
        if (timeSpent < 1000000)
            return (timeSpent / 1000.0) + "ms";
        return (timeSpent / 1000000.0) + "s";
    }

    public static void lap(String answer) {
        long timeSpent = (System.nanoTime() - timerStart) / 1000;
        System.out.println("Part " + part + ": " + answer + ", Duration: " + timeToString(timeSpent));
        timerStart = System.nanoTime();
        part++;
    }
}