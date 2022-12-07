package org.example.adventofcode2022.models;

public class File extends Node {
    public int size;

    @Override
    public long getSize() {
        return size;
    }
}