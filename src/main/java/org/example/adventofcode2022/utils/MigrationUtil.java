package org.example.adventofcode2022.utils;

import org.example.adventofcode2022.models.ElfInventory;
import org.example.adventofcode2022.models.GameSet;
import org.example.adventofcode2022.models.RucksackCompartments;

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
}