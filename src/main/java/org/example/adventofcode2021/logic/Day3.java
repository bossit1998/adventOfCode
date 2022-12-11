package org.example.adventofcode2021.logic;

import org.example.utils.IOUtil;

import java.util.ArrayList;
import java.util.List;

import static org.example.utils.Constant.generalPath;

public class Day3 {

    public static void main(String[] args) {
        try {
            String filePath = generalPath + "Day3";
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

    public static void part1(List<String> instructions) {
        int numberLength = instructions.get(0).length();

        List<Integer> onesCount = new ArrayList<>();
        List<Integer> zerosCount = new ArrayList<>();

        for (int i=0; i<numberLength; i++) {
            onesCount.add(0);
            zerosCount.add(0);
        }

        for(String number : instructions) {
            for (int i=0; i<numberLength; i++) {
                if (number.charAt(i)=='1') {
                    onesCount.set(i,onesCount.get(i)+1);
                } else {
                    zerosCount.set(i,zerosCount.get(i)+1);
                }
            }
        }

        System.out.println("onesCount: " + onesCount);
        System.out.println("zeroCount: " + zerosCount);


        double gamma = 0;
        double epsilon = 0;

        for (int i=0; i<numberLength; i++) {
            if (onesCount.get(i)>zerosCount.get(i)) {
                gamma += Math.pow(2,numberLength-1-i)*1;
                epsilon += Math.pow(2,numberLength-1-i)*0;
            } else {
                gamma += Math.pow(2,numberLength-1-i)*0;
                epsilon += Math.pow(2,numberLength-1-i)*1;
            }
        }

        System.out.println("gamma = " + gamma);
        System.out.println("epsilon = " + epsilon);
        System.out.println("epsilon*gamma = " + epsilon*gamma);
    }

    public static void part2(List<String> instructions) {
        StringBuilder oxygenGenerator = new StringBuilder();
        String co2Scrubber = "";

        int instructionLength = instructions.get(0).length();

        for (int i = 0; i < instructionLength; i++) {
            int onesCount = 0;
            int zerosCount = 0;
            for (String instruction : instructions) {
                if (instruction.charAt(i) == 1) {
                    onesCount++;
                } else {
                    zerosCount++;
                }
            }

            if(onesCount>=zerosCount) {
                oxygenGenerator.append("1");
            } else {

            }
        }
    }
}