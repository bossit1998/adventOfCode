package org.example.adventofcode2022.models;

public abstract class Node {
    public Folder parent;
    public String name;

    public abstract long getSize();
}