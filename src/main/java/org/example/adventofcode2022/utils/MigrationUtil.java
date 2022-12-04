package org.example.adventofcode2022.utils;

import org.example.adventofcode2022.models.*;

import java.util.ArrayList;
import java.util.List;

public class MigrationUtil {

    public static List<ElfInventory> migrateDay1(List<String> caloriesList) {
        List<ElfInventory> elfInventoryList = new ArrayList<>();

        ElfInventory elf = new ElfInventory();

        for (String calorie : caloriesList) {
            if (calorie.equals("\n") || calorie.equals("")) {
                elf.setSum(null);
                elfInventoryList.add(elf);
                elf = new ElfInventory();
            } else {
                elf.addCalorie(Integer.valueOf(calorie));
            }
        }
        return elfInventoryList;
    }

    public static List<GameSet> migrateDay2(List<String> gameChoices) {
        List<GameSet> gameSet = new ArrayList<>();

        for (String set : gameChoices) {
            String[] setAsArray = set.split(" ");

            GameSet game = new GameSet();
            game.setOpponent(setAsArray[0]);
            game.setMe(setAsArray[1]);

            gameSet.add(game);
        }
        return gameSet;
    }


    public static List<RucksackCompartments> migrateDay3(List<String> rucksackItems) {
        List<RucksackCompartments> rucksackList = new ArrayList<>();

        for (String item : rucksackItems) {
            int itemsLength = item.length();
            String rucksackPart1 = item.substring(0, itemsLength / 2);
            String rucksackPart2 = item.substring(itemsLength / 2, itemsLength);

            RucksackCompartments rucksack = new RucksackCompartments();
            rucksack.setCompartment1(rucksackPart1);
            rucksack.setCompartment2(rucksackPart2);

            rucksackList.add(rucksack);
        }
        return rucksackList;
    }

    public static List<ElfPairs> migrateDay4(List<String> elfPairs) {
        List<ElfPairs> elfs = new ArrayList<>();

        for (String elf : elfPairs) {
            String[] line = elf.split(",");
            String[] scope1 = line[0].split("-");
            String[] scope2 = line[1].split("-");

            AssignmentScope assignmentScope1 = new AssignmentScope();
            assignmentScope1.setBegin(Integer.valueOf(scope1[0]));
            assignmentScope1.setEnd(Integer.valueOf(scope1[1]));

            AssignmentScope assignmentScope2 = new AssignmentScope();
            assignmentScope2.setBegin(Integer.valueOf(scope2[0]));
            assignmentScope2.setEnd(Integer.valueOf(scope2[1]));

            ElfPairs elfPair = new ElfPairs();
            elfPair.setElf1(assignmentScope1);
            elfPair.setElf2(assignmentScope2);

            elfs.add(elfPair);
        }
        return elfs;
    }
}