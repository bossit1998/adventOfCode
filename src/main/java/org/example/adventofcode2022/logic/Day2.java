package org.example.adventofcode2022.logic;


import org.example.adventofcode2022.models.ElfInventory;
import org.example.adventofcode2022.models.GameSet;
import org.example.adventofcode2022.utils.MigrationUtil;
import org.example.adventofcode2022.utils.Util;
import org.example.utils.IOUtil;

import java.util.List;

import static org.example.utils.Constant.generalPath;

public class Day2 {

    public static void main(String[] args) {
        try {
            String filePath = generalPath + "Day2";
            List<String> list = IOUtil.readFileIntoList(filePath);

            if (list == null) {
                System.out.println("Can't read from the file");
            } else {
                List<GameSet> gameSet = MigrationUtil.migrateDay2(list);

                part1(gameSet);
                part2(gameSet);

            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void part1(List<GameSet> gameSet) {
        int score = 0;

//    A for Rock, B for Paper, and C for Scissors
//    X for Rock, Y for Paper, and Z for Scissors
//    1 for Rock, 2 for Paper, and 3 for Scissors
//    0 for lose, 3 for draw, and 6 for win


        String inRock = "A";
        String inPaper = "B";
        String inScissors = "C";

        String outRock = "X";
        String outPaper = "Y";
        String outScissors = "Z";

        int rock = 1;
        int paper = 2;
        int scissors = 3;

        int lose = 0;
        int draw = 3;
        int win = 6;


        for(GameSet game : gameSet) {
            if (game.getOpponent().equals(inRock)) {
                if (game.getMe().equals(outRock)) {
                    score+=(rock+draw);
                } else if (game.getMe().equals(outPaper)) {
                    score+=(paper+win);
                } else if (game.getMe().equals(outScissors)) {
                    score+=(scissors+lose);
                }
            } else if (game.getOpponent().equals(inPaper)) {
                if (game.getMe().equals(outRock)) {
                    score+=(rock+lose);
                } else if (game.getMe().equals(outPaper)) {
                    score+=(paper+draw);
                } else if (game.getMe().equals(outScissors)) {
                    score+=(scissors+win);
                }
            } else if (game.getOpponent().equals(inScissors)) {
                if (game.getMe().equals(outRock)) {
                    score+=(rock+win);
                } else if (game.getMe().equals(outPaper)) {
                    score+=(paper+lose);
                } else if (game.getMe().equals(outScissors)) {
                    score+=(scissors+draw);
                }
            }
        }
        System.out.println(score);
    }

    public static void part2(List<GameSet> gameSet) {
        int score = 0;

//    A for Rock, B for Paper, and C for Scissors
//    X for lose, Y for draw, and Z for win
//    1 for Rock, 2 for Paper, and 3 for Scissors
//    0 for lose, 3 for draw, and 6 for win


        String inRock = "A";
        String inPaper = "B";
        String inScissors = "C";

        String outLose = "X";
        String outDraw = "Y";
        String outWin = "Z";

        int rock = 1;
        int paper = 2;
        int scissors = 3;

        int lose = 0;
        int draw = 3;
        int win = 6;


        for(GameSet game : gameSet) {
            if (game.getOpponent().equals(inRock)) {
                if (game.getMe().equals(outWin)) {
                    score+=(paper+win);
                } else if (game.getMe().equals(outDraw)) {
                    score+=(rock+draw);
                } else if (game.getMe().equals(outLose)) {
                    score+=(scissors+lose);
                }
            } else if (game.getOpponent().equals(inPaper)) {
                if (game.getMe().equals(outLose)) {
                    score+=(rock+lose);
                } else if (game.getMe().equals(outDraw)) {
                    score+=(paper+draw);
                } else if (game.getMe().equals(outWin)) {
                    score+=(scissors+win);
                }
            } else if (game.getOpponent().equals(inScissors)) {
                if (game.getMe().equals(outWin)) {
                    score+=(rock+win);
                } else if (game.getMe().equals(outLose)) {
                    score+=(paper+lose);
                } else if (game.getMe().equals(outDraw)) {
                    score+=(scissors+draw);
                }
            }
        }
        System.out.println(score);
    }
}