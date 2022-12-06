package org.example.adventofcode2022.logic;

import org.example.utils.IOUtil;

import java.util.*;

import static org.example.utils.Constant.generalPath;

public class Day6 {

    public static void main(String[] args) {
        try {
            String filePath = generalPath + "Day6";
            List<String> list = IOUtil.readFileIntoList(filePath);

            if (list == null) {
                System.out.println("Can't read from the file");
            } else {


                part1(list.get(0));
                part2(list.get(0));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void part1(String str) {
        List<String> l = new ArrayList<>();
        int cnt = 0;

        for (int i = 0; i < str.length(); i++) {

            if (l.size() < 4) {
                l.add(String.valueOf(str.charAt(i)));
            } else {
                l.remove(0);
                l.add(String.valueOf(str.charAt(i)));
            }

            if (isUnique(l, 4)) {
                cnt = i;
                break;
            }
        }

        System.out.println(cnt+1);
        System.out.println(Arrays.toString(l.toArray()));
    }

    public static void part2(String str) {
        List<String> l = new ArrayList<>();
        int cnt = 0;

        for (int i = 0; i < str.length(); i++) {

            if (l.size() < 14) {
                l.add(String.valueOf(str.charAt(i)));
            } else {
                l.remove(0);
                l.add(String.valueOf(str.charAt(i)));
            }

            if (isUnique(l, 14)) {
                cnt = i;
                break;
            }
        }

        System.out.println(cnt+1);
        System.out.println(Arrays.toString(l.toArray()));
    }

    public static boolean isUnique(List<String> q, int size) {
        boolean isUnique = true;
        if (q.size() == size) {
            for (int i = 0; i < size-1; i++) {
                for (int j = i+1; j < size; j++) {
                    if (q.get(i).equals(q.get(j))) {
                        return false;
                    }
                }
            }
        } else {
            return false;
        }

        return isUnique;
    }
}