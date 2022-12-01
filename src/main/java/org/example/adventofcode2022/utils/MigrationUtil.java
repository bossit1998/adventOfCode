package org.example.adventofcode2022.utils;

import org.example.adventofcode2022.models.ElfInventory;

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
}