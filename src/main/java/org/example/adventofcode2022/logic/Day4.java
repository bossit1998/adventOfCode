package org.example.adventofcode2022.logic;

import org.example.adventofcode2022.models.ElfPairs;
import org.example.adventofcode2022.utils.MigrationUtil;
import org.example.utils.IOUtil;

import java.util.List;

import static org.example.utils.Constant.generalPath;

public class Day4 {

    public static void main(String[] args) {
        try {
            String filePath = generalPath + "Day4";
            List<String> list = IOUtil.readFileIntoList(filePath);

            if (list == null) {
                System.out.println("Can't read from the file");
            } else {
                List<ElfPairs> elfs = MigrationUtil.migrateDay4(list);

                part1(elfs);
                part2(elfs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void part1(List<ElfPairs> elfs) {
        int count = 0;

        for (ElfPairs elfPair : elfs) {
            if (elfPair.getElf1().getBegin() <= elfPair.getElf2().getBegin()
                    && elfPair.getElf1().getEnd() >= elfPair.getElf2().getEnd()) {
                count++;
            } else if (elfPair.getElf1().getBegin() >= elfPair.getElf2().getBegin()
                    && elfPair.getElf1().getEnd() <= elfPair.getElf2().getEnd()) {
                count++;
            }
        }

        System.out.println(count);
    }

    public static void part2(List<ElfPairs> elfs) {
        int count = 0;

        for (ElfPairs elfPair : elfs) {
            if (elfPair.getElf1().getBegin() <= elfPair.getElf2().getBegin()
                    && elfPair.getElf1().getEnd() >= elfPair.getElf2().getEnd()) {
                count++;
            } else if (elfPair.getElf1().getBegin() >= elfPair.getElf2().getBegin()
                    && elfPair.getElf1().getEnd() <= elfPair.getElf2().getEnd()) {
                count++;
            } else if (elfPair.getElf1().getBegin() <= elfPair.getElf2().getBegin()
                    && elfPair.getElf1().getEnd() <= elfPair.getElf2().getEnd()
                    && elfPair.getElf1().getEnd() >= elfPair.getElf2().getBegin()
                    && elfPair.getElf2().getBegin() <= elfPair.getElf1().getEnd()) {
                count++;
            } else if (elfPair.getElf2().getBegin() <= elfPair.getElf1().getBegin()
                    && elfPair.getElf2().getEnd() <= elfPair.getElf1().getEnd()
                    && elfPair.getElf2().getEnd() >= elfPair.getElf1().getBegin()
                    && elfPair.getElf1().getBegin() <= elfPair.getElf2().getEnd()) {
                count++;
            }
        }

        System.out.println(count);
    }
}