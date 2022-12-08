package org.example.adventofcode2022.logic;

import org.example.adventofcode2022.models.Tree;
import org.example.utils.IOUtil;

import java.util.List;

import static org.example.utils.Constant.generalPath;

public class Day8 {

    public static void main(String[] args) {
        try {
            String filePath = generalPath + "Day8";
            List<String> list = IOUtil.readFileIntoList(filePath);

            if (list == null) {
                System.out.println("Can't read from the file");
            } else {
                solution(list);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

    public static void solution(List<String> list) {
        Tree[][] arr = new Tree[list.size()][list.get(0).length()];
        int countOfVisibleTrees = 0;
        int maxVision = 0;
//        System.out.println(ANSI_YELLOW + "This text has a green background but default text!" + ANSI_RESET);
        for (int i=0; i<list.size();i++) {
            for (int j=0; j<list.get(i).length();j++) {
                arr[i][j] = checkTree(list, j, i);
                if (arr[i][j].getVisible()) {
                    countOfVisibleTrees++;
                }
                if (arr[i][j].getTotalVision()>maxVision) {
                    maxVision=arr[i][j].getTotalVision();
                }
            }
            System.out.println();
        }

        lap(countOfVisibleTrees);
        lap(maxVision);
    }

    public static Tree checkTree(List<String> list, int x, int y) {
        if (y==60 && x ==60) {
            int dx = 0;
        }
        Tree tree = new Tree(list.get(y).charAt(x),x, y);
        if (x==0 || x==list.get(0).length() || y==0 || y==list.size()) {
            tree.setVisible(true);
            System.out.print(ANSI_YELLOW + "*" + ANSI_RESET);
//            System.out.print(ANSI_YELLOW + "tree.getValue()" + ANSI_RESET);
            return tree;
        }

        int cnt=0;
        for (int i=0; i<y;i++) {
            if (list.get(y).charAt(x) >= list.get(i).charAt(x)) {
                tree.setVisionUp(tree.getVisionUp()+1);
            } else {
                if (cnt==0) {
                    tree.setVisionUp(tree.getVisionUp()+1);
                } else {
                    cnt++;
                }
            }

            if (list.get(y).charAt(x)<=list.get(i).charAt(x)) {
                tree.setVisibleUp(false);
                break;
            } else {
//                tree.setVisionUp(tree.getVisionUp()+1);
            }
        }

        cnt=0;
        for (int i=y; i<list.size()-1;i++) {
            if (list.get(y).charAt(x) >= list.get(i + 1).charAt(x)) {
                tree.setVisionDown(tree.getVisionDown()+1);
            } else {
                if (cnt==0) {
                    tree.setVisionDown(tree.getVisionDown()+1);
                } else {
                    cnt++;
                }
            }
            if (list.get(y).charAt(x)<=list.get(i+1).charAt(x)) {
                tree.setVisibleDown(false);
                break;
            } else {
//                tree.setVisionDown(tree.getVisionDown()+1);
            }
        }

        cnt=0;
        for (int i=0; i<x;i++) {
            if (list.get(y).charAt(x) >= list.get(y).charAt(i)) {
                tree.setVisionLeft(tree.getVisionLeft()+1);
            } else {
                if (cnt==0) {
                    tree.setVisionLeft(tree.getVisionLeft()+1);
                } else {
                    cnt++;
                }
            }

            if (list.get(y).charAt(x)<=list.get(y).charAt(i)) {
                tree.setVisibleLeft(false);
                break;
            } else {
//                tree.setVisionLeft(tree.getVisionLeft()+1);
            }
        }

        cnt=0;
        for (int i=x; i<list.get(0).length()-1;i++) {
            if (list.get(y).charAt(x) >= list.get(y).charAt(i + 1)) {
                tree.setVisionRight(tree.getVisionRight()+1);
            } else {
                if (cnt==0) {
                    tree.setVisionRight(tree.getVisionRight()+1);
                } else {
                    cnt++;
                }
            }

            if (list.get(y).charAt(x)<=list.get(y).charAt(i+1)) {
                tree.setVisibleRight(false);
                break;
            } else {
//                tree.setVisionRight(tree.getVisionRight()+1);
            }
        }

        if (tree.getVisibleUp() || tree.getVisibleRight()
                || tree.getVisibleDown() || tree.getVisibleLeft()) {
            tree.setVisible(true);
            System.out.print(ANSI_YELLOW + "*" + ANSI_RESET);
//            System.out.print(ANSI_YELLOW + "tree.getValue()" + ANSI_RESET);
        } else {
            tree.setVisible(false);
            System.out.print(" ");
//            System.out.print(tree.getValue());
        }

        return tree;
    }




    private static long timerStart;
    private static int part = 1;

    public static void lap(long answer) {
        lap(String.valueOf(answer));
    }

    public static String timeToString(long timeSpent) {
        if (timeSpent < 1000)
            return timeSpent + "µs";
        if (timeSpent < 1000000)
            return (timeSpent / 1000.0) + "ms";
        return (timeSpent / 1000000.0) + "s";
    }

    public static void lap(String answer) {
        long timeSpent = (System.nanoTime() - timerStart) / 1000;
        System.out.println("Part " + part + ": " + answer + ", Duration: " + timeToString(timeSpent));
        timerStart = System.nanoTime();
        part++;
    }
}