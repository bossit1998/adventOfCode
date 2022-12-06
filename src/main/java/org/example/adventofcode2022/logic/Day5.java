package org.example.adventofcode2022.logic;

import org.example.adventofcode2022.models.StackInstructions;
import org.example.adventofcode2022.utils.MigrationUtil;
import org.example.utils.IOUtil;

import java.util.List;
import java.util.Stack;

import static org.example.utils.Constant.generalPath;

public class Day5 {

    public static void main(String[] args) {
        try {
            String filePath = generalPath + "Day5";
            List<String> list = IOUtil.readFileIntoList(filePath);

            if (list == null) {
                System.out.println("Can't read from the file");
            } else {
                List<Stack<String>> stacks = MigrationUtil.migrateDay5Part1(list);
                List<StackInstructions> stackInstructions = MigrationUtil.migrateDay5Part2(list);

                part1(stacks, stackInstructions);

                stacks = MigrationUtil.migrateDay5Part1(list);
                part2(stacks, stackInstructions);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void part1(List<Stack<String>> stacks, List<StackInstructions> stackInstructions) {
        for (StackInstructions stackInstruction : stackInstructions) {
            for (int i = 0; i < stackInstruction.getAmount(); i++) {
                stacks.get(stackInstruction.getTo()-1).push(stacks.get(stackInstruction.getFrom()-1).pop());
            }
        }

        StringBuilder result = new StringBuilder();
        for (Stack<String> s : stacks) {
            result.append(s.peek());
        }

        System.out.println(result);
    }

    public static void part2(List<Stack<String>> stacks, List<StackInstructions> stackInstructions) {
        int cnt = 0;
        for (StackInstructions stackInstruction : stackInstructions) {
            Stack<String> tempStack = new Stack<>();

            System.out.println(cnt);
            for (int i = 0; i < stackInstruction.getAmount(); i++) {
                tempStack.push(stacks.get(stackInstruction.getFrom()-1).pop());
            }

            int tempStackSize = tempStack.size();
            for (int i = 0; i < tempStackSize; i++) {
                stacks.get(stackInstruction.getTo()-1).push(tempStack.pop());
            }

            cnt++;
        }

        StringBuilder result = new StringBuilder();
        for (Stack<String> s : stacks) {
            result.append(s.peek());
        }

        System.out.println(result);
    }

}