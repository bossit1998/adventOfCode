package org.example.adventofcode2022.models;

import java.util.ArrayList;
import java.util.List;

public class ItemPriorities {
    private final List<String> items;
    private final List<Integer> priorities;

    public ItemPriorities() {
        this.items = new ArrayList<>(List.of(
                "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"
                , "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"
        ));

        this.priorities = new ArrayList<>(List.of(
                1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26
                , 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52
        ));
    }

    public List<String> getItems() {
        return items;
    }

    public List<Integer> getPriorities() {
        return priorities;
    }
}
