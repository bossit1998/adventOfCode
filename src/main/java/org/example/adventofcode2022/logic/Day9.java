package org.example.adventofcode2022.logic;

import org.example.adventofcode2022.models.RopeHeadMove;
import org.example.adventofcode2022.models.RopeKnot;
import org.example.utils.IOUtil;

import java.util.ArrayList;
import java.util.List;

import static org.example.adventofcode2022.utils.MigrationUtil.migrateDay9;
import static org.example.utils.Constant.generalPath;

public class Day9 {

    public static void main(String[] args) {
        try {
            String filePath = generalPath + "Day9";
            List<String> list = IOUtil.readFileIntoList(filePath);

            if (list == null) {
                System.out.println("Can't read from the file");
            } else {
                List<RopeHeadMove> headMoves = migrateDay9(list);

                part1(headMoves);
                part2(headMoves);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void part1(List<RopeHeadMove> headMoves) {
        RopeKnot head = new RopeKnot();
        RopeKnot tail = new RopeKnot();
        List<RopeKnot> tailVisits = new ArrayList<>();
        tailVisits.add(new RopeKnot(tail));

        int moveCount = 0;
        int iteration = 0;

        System.out.print("iteration: " + iteration);
        System.out.print("  ");
        System.out.print("move: " + moveCount);
        System.out.print("  ");
        System.out.print("head: [" + head.getI() + "][" + head.getJ() + "]");
        System.out.print("  ");
        System.out.print("tail: [" + tail.getI() + "][" + tail.getJ() + "]");
        System.out.print("  ");
        System.out.print("tailVisits: " + tailVisits.size());
        System.out.println();

        for (RopeHeadMove move : headMoves) {
            moveCount++;

            for (int i = 0; i < move.getDistance(); i++) {
                iteration++;

                switch (move.getDirection()) {
                    case "U":
                        head.setI(head.getI() + 1);
                        break;
                    case "D":
                        head.setI(head.getI() - 1);
                        break;
                    case "R":
                        head.setJ(head.getJ() + 1);
                        break;
                    case "L":
                        head.setJ(head.getJ() - 1);
                        break;
                }

                if ((Math.abs(head.getI() - tail.getI()) <= 1) && (Math.abs(head.getJ() - tail.getJ()) <= 1)) {

                } else {
                    if (head.getI() > tail.getI()) {
                        tail.setI(tail.getI() + 1);
                    } else if (head.getI() < tail.getI()) {
                        tail.setI(tail.getI() - 1);
                    }

                    if (head.getJ() > tail.getJ()) {
                        tail.setJ(tail.getJ() + 1);
                    } else if (head.getJ() < tail.getJ()) {
                        tail.setJ(tail.getJ() - 1);
                    }

                    if (!findIfExists(tailVisits, tail)) {
                        tailVisits.add(new RopeKnot(tail));
                    }
                }

                System.out.print("iteration: " + iteration);
                System.out.print("  ");
                System.out.print("move: " + moveCount);
                System.out.print("  ");
                System.out.print("head: [" + head.getI() + "][" + head.getJ() + "]");
                System.out.print("  ");
                System.out.print("tail: [" + tail.getI() + "][" + tail.getJ() + "]");
                System.out.print("  ");
                System.out.print("tailVisits: " + tailVisits.size());
                System.out.println();
            }
        }
        lap(tailVisits.size());
    }

    private static void part2(List<RopeHeadMove> headMoves) {
        List<RopeKnot> knots = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            knots.add(new RopeKnot());
        }

        List<RopeKnot> tailVisits = new ArrayList<>();
        tailVisits.add(new RopeKnot(0, 0));

        int moveCount = 0;
        int iteration = 0;

        System.out.print("iteration: " + iteration);
        System.out.print("  ");
        System.out.print("move: " + moveCount);
        System.out.print("  ");
        System.out.print("tailVisits: " + tailVisits.size());
        System.out.println();

        for (RopeHeadMove move : headMoves) {
            moveCount++;

            RopeKnot head = knots.get(0);
            RopeKnot tail = knots.get(9);

            for (int i = 0; i < move.getDistance(); i++) {
                iteration++;

                switch (move.getDirection()) {
                    case "U":
                        head.setI(head.getI() + 1);
                        break;
                    case "D":
                        head.setI(head.getI() - 1);
                        break;
                    case "R":
                        head.setJ(head.getJ() + 1);
                        break;
                    case "L":
                        head.setJ(head.getJ() - 1);
                        break;
                }

                for (int j = 0; j < 9; j++) {
                    RopeKnot currentKnot = knots.get(j);
                    RopeKnot nextKnot = knots.get(j + 1);

                    if ((Math.abs(currentKnot.getI() - nextKnot.getI()) <= 1) && (Math.abs(currentKnot.getJ() - nextKnot.getJ()) <= 1)) {

                    } else {
                        if (currentKnot.getI() > nextKnot.getI()) {
                            nextKnot.setI(nextKnot.getI() + 1);
                        } else if (currentKnot.getI() < nextKnot.getI()) {
                            nextKnot.setI(nextKnot.getI() - 1);
                        }

                        if (currentKnot.getJ() > nextKnot.getJ()) {
                            nextKnot.setJ(nextKnot.getJ() + 1);
                        } else if (currentKnot.getJ() < nextKnot.getJ()) {
                            nextKnot.setJ(nextKnot.getJ() - 1);
                        }

                        if (!findIfExists(tailVisits, knots.get(9))) {
                            tailVisits.add(new RopeKnot(knots.get(9)));
                        }
                    }
                }
                printKnots(knots, iteration, moveCount, tailVisits);
            }
        }
        lap(tailVisits.size());
    }

    public static void printKnots(List<RopeKnot> knots, int iteration, int moveCount, List<RopeKnot> tailVisits) {
        System.out.print("iteration: " + iteration);
        System.out.print("  ");
        System.out.print("move: " + moveCount);
        System.out.print("  ");
        System.out.print("knots: ");
        int cnt = 1;
        for (RopeKnot knot : knots) {
            System.out.print("  ");
            System.out.print(cnt + ": [" + knot.getI() + "][" + knot.getJ() + "]");
            cnt++;
        }
        System.out.print("  ");
        System.out.print("tailVisits: " + tailVisits.size());
        System.out.println();
    }

    private static int[] findArrayDimensions(List<RopeHeadMove> headMoves) {
        int maxUp = 0;
        int maxDown = 0;
        int maxRight = 0;
        int maxLeft = 0;

        int i = 0;
        int j = 0;

        for (RopeHeadMove move : headMoves) {
            switch (move.getDirection()) {
                case "U":
                    i++;
                    if (maxUp < i) {
                        maxUp = i;
                    }
                    break;
                case "D":
                    i--;
                    if (maxDown > i) {
                        maxDown = i;
                    }
                    break;
                case "R":
                    j++;
                    if (maxRight < j) {
                        maxRight = j;
                    }
                    break;
                case "L":
                    j--;
                    if (maxLeft > j) {
                        maxLeft = j;
                    }
                    break;
            }
        }

        System.out.println("maxUp: " + maxUp);
        System.out.println("maxDown: " + maxDown);
        System.out.println("maxRight: " + maxRight);
        System.out.println("maxLeft: " + maxLeft);


        int height = maxDown - maxUp;
        int width = maxLeft - maxRight;
        System.out.println("height: " + height);
        System.out.println("width: " + width);
        return new int[]{height, width};
    }

    private static boolean findIfExists(List<RopeKnot> tailVisits, RopeKnot tail) {
        for (RopeKnot visit : tailVisits) {
            if (visit.getI().equals(tail.getI()) && visit.getJ().equals(tail.getJ())) {
                return true;
            }
        }
        return false;
    }

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";

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