package org.example.adventofcode2022.models;

public class Tree {
    private char value;
    private Integer x;
    private Integer y;
    private Boolean visible = true;
    private Boolean visibleUp = true;
    private Boolean visibleDown = true;
    private Boolean visibleLeft = true;
    private Boolean visibleRight = true;
    private Integer visionUp = 0;
    private Integer visionDown = 0;
    private Integer visionLeft = 0;
    private Integer visionRight = 0;

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public Integer getVisionUp() {
        return visionUp;
    }

    public void setVisionUp(Integer visionUp) {
        this.visionUp = visionUp;
    }

    public Integer getVisionDown() {
        return visionDown;
    }

    public void setVisionDown(Integer visionDown) {
        this.visionDown = visionDown;
    }

    public Integer getVisionLeft() {
        return visionLeft;
    }

    public void setVisionLeft(Integer visionLeft) {
        this.visionLeft = visionLeft;
    }

    public Integer getVisionRight() {
        return visionRight;
    }

    public Integer getTotalVision() {
        return visionUp*visionRight*visionDown*visionLeft;
    }

    public void setVisionRight(Integer visionRight) {
        this.visionRight = visionRight;
    }

    public Tree(char value, int x, int y) {
        this.value=value;
        this.x = x;
        this.y = y;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public Boolean getVisibleUp() {
        return visibleUp;
    }

    public void setVisibleUp(Boolean visibleUp) {
        this.visibleUp = visibleUp;
    }

    public Boolean getVisibleDown() {
        return visibleDown;
    }

    public void setVisibleDown(Boolean visibleDown) {
        this.visibleDown = visibleDown;
    }

    public Boolean getVisibleLeft() {
        return visibleLeft;
    }

    public void setVisibleLeft(Boolean visibleLeft) {
        this.visibleLeft = visibleLeft;
    }

    public Boolean getVisibleRight() {
        return visibleRight;
    }

    public void setVisibleRight(Boolean visibleRight) {
        this.visibleRight = visibleRight;
    }

    public char getValue() {
        return value;
    }

    public void setValue(char value) {
        this.value = value;
    }
}
