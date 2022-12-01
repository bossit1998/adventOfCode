package org.example.adventofcode2022.utils;

import org.example.adventofcode2022.models.ElfInventory;

import java.util.List;

public class Util {
    public static Integer findMax(List<ElfInventory> list, Integer numberOfMaxes) {
        Integer sum = 0;

        list.sort((o1, o2) -> o2.getSum().compareTo(o1.getSum()));

        for (int i = 0; i < numberOfMaxes; i++) {
            sum += list.get(i).getSum();
        }
        return sum;
    }
}