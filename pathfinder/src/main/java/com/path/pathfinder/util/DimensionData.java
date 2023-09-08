package com.path.pathfinder.util;

public class DimensionData {

    private final int row;
    private final int col;
    private final int rectangleWidth;
    private final int rectangleHeight;

    public DimensionData(int height, int width, int row, int col) {
        this.row = row;
        this.col = col;
        rectangleHeight = height / row;
        rectangleWidth = width / col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public int getRectangleWidth() {
        return rectangleWidth;
    }

    public int getRectangleHeight() {
        return rectangleHeight;
    }


}
