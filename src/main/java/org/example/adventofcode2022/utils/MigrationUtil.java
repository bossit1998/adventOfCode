package org.example.adventofcode2022.utils;

import org.example.adventofcode2022.models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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

    public static List<Stack<String>> migrateDay5Part1(List<String> stacks) {
        List<Stack<String>> stacksList = new ArrayList<>();

        List<String> arr = new ArrayList<>();
        arr.add("HTZD");
        arr.add("QRWTGCS");
        arr.add("PBFQNRCH");
        arr.add("LCNFHZ");
        arr.add("GLFQS");
        arr.add("VPWZBRCS");
        arr.add("ZFJ");
        arr.add("DLVZRHQ");
        arr.add("BHGNFZLD");

        for (String str : arr) {
            Stack<String> stack = new Stack<>();
            for (int i=0; i<str.length(); i++) {
                stack.push(String.valueOf(str.charAt(i)));
            }
            stacksList.add(stack);
        }

        return stacksList;
    }

    public static List<StackInstructions> migrateDay5Part2(List<String> stacks) {
        List<StackInstructions> stackInstructions = new ArrayList<>();

        int count = 0;
        for (String stack : stacks) {
            if (count>=10) {
                String[] line = stack.split(" ");

                StackInstructions stackInstruction = new StackInstructions();
                stackInstruction.setAmount(Integer.valueOf(line[1]));
                stackInstruction.setFrom(Integer.valueOf(line[3]));
                stackInstruction.setTo(Integer.valueOf(line[5]));

                stackInstructions.add(stackInstruction);
            }
            count++;
        }
        return stackInstructions;
    }

    public static List<RopeHeadMove> migrateDay9(List<String> instructions) {
        List<RopeHeadMove> headMoves = new ArrayList<>();

        for (String stack : instructions) {
            String[] line = stack.split(" ");

            RopeHeadMove ropeHeadMove = new RopeHeadMove();
            ropeHeadMove.setDirection(line[0]);
            ropeHeadMove.setDistance(Integer.valueOf(line[1]));

            headMoves.add(ropeHeadMove);
        }
        return headMoves;
    }
}