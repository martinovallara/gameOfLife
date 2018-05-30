package com.geamOfLife;

import java.util.stream.Stream;

public class Cell {
    public static boolean LIVE = true;
    public static boolean DEAD = false;


    private Boolean[] neighbours;
    private boolean status;

    public Cell(boolean status) {

        this.status = status;
    }


    public boolean neighbourTree() {
        long count = countOfLives();
        return (count == 3);
    }

    private long countOfLives() {
        Stream<Boolean> stream = Stream.of(this.neighbours);
        return stream.filter(n -> n.equals(true)).count();
    }

    public boolean neighbourTwoOrTree() {
        long count = countOfLives();
        return (2 <= count && count <= 3);
    }

    public void addNeighbours(Boolean... neighbours) {
        this.neighbours = neighbours;
    }

    public boolean next() {
        if (status == DEAD) return neighbourTree();
        return neighbourTwoOrTree();
    }
}

