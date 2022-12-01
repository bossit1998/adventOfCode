package org.example.adventofcode2021.logic;

import org.example.adventofcode2021.utils.MigrationUtil;
import org.example.utils.IOUtil;

import java.util.List;

import static org.example.utils.Constant.generalPath;

public class Day1 {

    public static void main(String[] args) {
        try {
            String filePath = generalPath + "Day1";
            List<String> list = IOUtil.readFileIntoList(filePath);

            if (list == null) {
                System.out.println("Can't read from the file");
            } else {
                List<Integer> depthList = MigrationUtil.migrateDay1(list);

                part1(depthList);
                part2(depthList);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void part1(List<Integer> depthList) {

        int numberOfIncreases = 0;

        for (int i = 1; i < depthList.size(); i++) {
            if (depthList.get(i - 1) < depthList.get(i)) {
                numberOfIncreases++;
            }
        }

        System.out.println("number of increases = " + numberOfIncreases);
    }

    public static void part2(List<Integer> depthList) {

        int numberOf3SumIncreases = 0;
        int previous3Sum = depthList.get(0) + depthList.get(1) + depthList.get(2);

        for (int i = 3; i < depthList.size(); i++) {
            if (depthList.get(i) + depthList.get(i - 1) + depthList.get(i - 2) > previous3Sum) {
                numberOf3SumIncreases++;
            }
            previous3Sum = depthList.get(i) + depthList.get(i - 1) + depthList.get(i - 2);
        }

        System.out.println("number of 3 sum increases = " + numberOf3SumIncreases);
    }
}