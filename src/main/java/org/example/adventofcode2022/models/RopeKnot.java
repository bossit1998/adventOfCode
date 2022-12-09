package org.example.adventofcode2022.models;

public class RopeKnot {
    private Integer i;
    private Integer j;

    public RopeKnot() {
        i=0;
        j=0;
    }

    public RopeKnot(int i, int j) {
        this.i=i;
        this.j=j;
    }

    public RopeKnot(RopeKnot tail) {
        this.i=tail.getI();
        this.j=tail.getJ();
    }

    public Integer getI() {
        return i;
    }

    public void setI(Integer i) {
        this.i = i;
    }

    public Integer getJ() {
        return j;
    }

    public void setJ(Integer j) {
        this.j = j;
    }
}
