package org.example.adventofcode2022.models;

import java.util.ArrayList;
import java.util.List;

public class Folder extends Node {
    public List<Node> contents = new ArrayList<>();

    public List<Folder> getSubFolders() {
        List<Folder> folders = new ArrayList<>();
        for (Node n : contents)
            if (n instanceof Folder)
                folders.add((Folder) n);
        return folders;
    }

    public long getSize() {
        long size = 0;
        for (Node n : contents)
            size += n.getSize();
        return size;
    }
}