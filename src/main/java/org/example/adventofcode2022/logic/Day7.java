package org.example.adventofcode2022.logic;

import org.example.adventofcode2022.models.File;
import org.example.adventofcode2022.models.Folder;
import org.example.adventofcode2022.models.Node;
import org.example.utils.IOUtil;

import java.util.ArrayList;
import java.util.List;

import static org.example.utils.Constant.generalPath;

public class Day7 {

    public static void main(String[] args) {
        try {
            String filePath = generalPath + "Day7";
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

    public static void solution(List<String> input) {
        Folder root = new Folder();
        root.name = "/";
        Folder currentFold = root;
        for (int i = 1; i < input.size(); i++) {
            String[] parts = input.get(i).split(" ");

            if (parts[0].equals("$")) {
                if (parts[1].equals("cd")) {
                    if (parts[2].equals("..")) {
                        currentFold = currentFold.parent;
                    } else {
                        for (Node n : currentFold.contents) {
                            if (n.name.equals(parts[2])) {
                                currentFold = (Folder) n; // Should check, but meh
                                break;
                            }
                        }
                    }
                }
            } else if (parts[0].equals("dir")) {
                Folder folder = new Folder();
                folder.parent = currentFold;
                folder.name = parts[1];
                currentFold.contents.add(folder);
            } else {
                File file = new File();
                file.parent = currentFold;
                file.name = parts[1];
                file.size = Integer.parseInt(parts[0]);
                currentFold.contents.add(file);
            }
        }

        List<Folder> smallerFolders = new ArrayList<>();
        List<Folder> toCheck = new ArrayList<>(root.getSubFolders());

        while (toCheck.size() > 0) {
            Folder fold = toCheck.remove(0);
            toCheck.addAll(fold.getSubFolders());
            if (fold.getSize() <= 100000)
                smallerFolders.add(fold);
        }

        long sum = 0;
        for (Folder f : smallerFolders)
            sum += f.getSize();
        lap(sum);

        long totalSpace = 70000000;
        long freeSpace = totalSpace - root.getSize();

        long smallestFree = Integer.MAX_VALUE;
        toCheck = new ArrayList<>(root.getSubFolders());

        while (toCheck.size() > 0) {
            Folder fold = toCheck.remove(0);
            toCheck.addAll(fold.getSubFolders());
            long size = fold.getSize();
            if (freeSpace + size > 30000000 && size < smallestFree)
                smallestFree = size;
        }
        lap(smallestFree);
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