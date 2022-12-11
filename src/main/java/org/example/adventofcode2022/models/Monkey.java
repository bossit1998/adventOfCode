package org.example.adventofcode2022.models;

import java.util.ArrayList;
import java.util.List;

public class Monkey {
    private Integer id;
    private List<Integer> items;
    private String operand;
    private String operation;
    private Integer divisibleNumber;
    private Integer throwsIfTrue;
    private Integer throwsIfFalse;
    private Integer inspectsCount;

    public Monkey() {
        items = new ArrayList<>();
        inspectsCount = 0;
    }

    public Integer operation(int itemId) {
        int newWorryRate = 0;
        switch (operation) {
            case "+":
                if (operand.equals("old")) {
                    newWorryRate = items.get(itemId) + items.get(itemId);
                } else {
                    newWorryRate = items.get(itemId) + Integer.parseInt(operand);
                }
                items.set(itemId, newWorryRate);
                break;
            case "-":
                if (!operand.equals("old")) {
                    newWorryRate = items.get(itemId) - Integer.parseInt(operand);
                }
                items.set(itemId, newWorryRate);
                break;
            case "*":
                if (operand.equals("old")) {
                    newWorryRate = items.get(itemId) * items.get(itemId);
                } else {
                    newWorryRate = items.get(itemId) * Integer.parseInt(operand);
                }
                items.set(itemId, newWorryRate);
                break;
            case "/":
                if (operand.equals("old")) {
                    newWorryRate = 1;
                } else {
                    newWorryRate = items.get(itemId) / Integer.parseInt(operand);
                }
                items.set(itemId, newWorryRate);
                break;
        }

        inspectsCount++;
        return newWorryRate;
    }

    public Integer reduceWorry(int itemId) {
        items.set(itemId, items.get(itemId)/3);
        return items.get(itemId);
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public List<Integer> getItems() {
        return items;
    }

    public void setItems(List<Integer> items) {
        this.items = items;
    }

    public Integer getDivisibleNumber() {
        return divisibleNumber;
    }

    public void setDivisibleNumber(Integer divisibleNumber) {
        this.divisibleNumber = divisibleNumber;
    }

    public Integer getThrowsIfTrue() {
        return throwsIfTrue;
    }

    public void setThrowsIfTrue(Integer throwsIfTrue) {
        this.throwsIfTrue = throwsIfTrue;
    }

    public Integer getThrowsIfFalse() {
        return throwsIfFalse;
    }

    public void setThrowsIfFalse(Integer throwsIfFalse) {
        this.throwsIfFalse = throwsIfFalse;
    }

    public Integer getInspectsCount() {
        return inspectsCount;
    }

    public void setInspectsCount(Integer inspectsCount) {
        this.inspectsCount = inspectsCount;
    }

    public String getOperand() {
        return operand;
    }

    public void setOperand(String operand) {
        this.operand = operand;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }
}
