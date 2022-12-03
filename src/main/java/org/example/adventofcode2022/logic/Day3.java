package org.example.adventofcode2022.logic;

import org.example.adventofcode2022.models.ItemPriorities;
import org.example.adventofcode2022.models.RucksackCompartments;
import org.example.adventofcode2022.utils.MigrationUtil;
import org.example.utils.IOUtil;

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
                List<RucksackCompartments> rucksackList = MigrationUtil.migrateDay3(list);

                part1(rucksackList);
                part2(list);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void part1(List<RucksackCompartments> rucksackList) {
        ItemPriorities itemPriorities = new ItemPriorities();
        int sum = 0;

        for (RucksackCompartments rucksack : rucksackList) {
            for (int i = 0; i < rucksack.getCompartment1().length(); i++) {
                if (rucksack.getCompartment1().contains(String.valueOf(rucksack.getCompartment2().charAt(i)))) {
                    sum += itemPriorities.getPriorities().get(itemPriorities.getItems().indexOf(String.valueOf(rucksack.getCompartment2().charAt(i))));
                    break;
                }
            }
        }

        System.out.println(sum);
    }

    public static void part2(List<String> rucksackList) {
        ItemPriorities itemPriorities = new ItemPriorities();

        int sum = 0;

        for (int i = 0; i < rucksackList.size(); i += 3) {
            int length = Math.min(Math.min(rucksackList.get(i).length(), rucksackList.get(i + 1).length()), rucksackList.get(i + 2).length());
            int shortestWordIndex = length == rucksackList.get(i).length() ? i : length == rucksackList.get(i + 1).length() ? i + 1 : length == rucksackList.get(i + 2).length() ? i + 2 : 0;
            String shortestWord = rucksackList.get(shortestWordIndex);

            for (int j = 0; j < length; j++) {
                if (
                        rucksackList.get(i).contains(String.valueOf(shortestWord.charAt(j)))
                                && rucksackList.get(i + 1).contains(String.valueOf(shortestWord.charAt(j)))
                                && rucksackList.get(i + 2).contains(String.valueOf(shortestWord.charAt(j)))) {
                    sum += itemPriorities.getPriorities().get(itemPriorities.getItems().indexOf(String.valueOf(shortestWord.charAt(j))));
                    break;
                }
            }
        }

        System.out.println(sum);
    }
}