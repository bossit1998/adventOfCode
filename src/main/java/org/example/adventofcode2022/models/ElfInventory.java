package org.example.adventofcode2022.models;

import java.util.ArrayList;
import java.util.List;

public class ElfInventory {
    private List<Integer> calories;
    private Integer sum;

    public ElfInventory() {
        this.calories = new ArrayList<>();
        this.sum = 0;
    }

    public List<Integer> getCalories() {
        return this.calories;
    }

    public void setCalories(List<Integer> calories) {
        this.calories = calories;
    }

    public void addCalorie(Integer calorie) {
        this.calories.add(calorie);
    }

    public void clearCalories() {
        this.calories.clear();
    }

    public Integer getSum() {
        return this.sum;
    }

    public void setSum(Integer sum) {
        if (sum == null) {
            this.sum = calculateSum();
        } else {
            this.sum = sum;
        }
    }

    public Integer calculateSum() {
        Integer sum = 0;
        for (Integer calorie : calories) {
            sum += calorie;
        }
        return sum;
    }
}
