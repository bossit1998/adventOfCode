package org.example.adventofcode2022.logic;

import org.example.adventofcode2022.models.Monkey;
import org.example.utils.IOUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.example.adventofcode2022.utils.MigrationUtil.migrateDay11;
import static org.example.utils.Constant.generalPath;

public class Day11 {

    public static void main(String[] args) {
        try {
            String filePath = generalPath + "Day11";
            List<String> list = IOUtil.readFileIntoList(filePath);

            if (list == null) {
                System.out.println("Can't read from the file");
            } else {
                List<Monkey> monkeys = migrateDay11(list);
                part1(monkeys);
//                part2(list);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void part1(List<Monkey> monkeys) {

        for (int round = 1; round <=20; round++) {
            for (Monkey monkey : monkeys) {
                if (!monkey.getItems().isEmpty()) {
                    for (int i=0; i<monkey.getItems().size(); i++) {
                        int newWorryValue = monkey.operation(i);
                        newWorryValue = monkey.reduceWorry(i);
                        if (newWorryValue%monkey.getDivisibleNumber()==0) {
                            monkeys.get(monkey.getThrowsIfTrue()).getItems().add(monkey.getItems().get(i));
                        } else {
                            monkeys.get(monkey.getThrowsIfFalse()).getItems().add(monkey.getItems().get(i));
                        }
                    }
                    monkey.getItems().clear();
                }
            }


            System.out.println("round: " + round);

            for (Monkey monkey : monkeys) {
                System.out.println(monkey.getId() + " " + monkey.getInspectsCount());
            }
        }

        System.out.println();
        List<Integer> inspectionsList = new ArrayList<>();
        for (Monkey monkey : monkeys) {
            inspectionsList.add(monkey.getInspectsCount());
            System.out.println(monkey.getId() + " " + monkey.getInspectsCount());
        }

        int max = Collections.max(inspectionsList);
        inspectionsList.remove((Integer) max);
        int preMax = Collections.max(inspectionsList);

        System.out.println(max*preMax);
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