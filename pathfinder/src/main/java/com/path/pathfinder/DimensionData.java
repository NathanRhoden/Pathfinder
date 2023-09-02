package com.path.pathfinder;

public class DimensionData {

    private int height;
    private int width;
    private int row;
    private int col;
    private int rectangleWidth;
    private int rectangleHeight;
    private int vertexCount;

    public DimensionData(int height, int width, int row, int col) {
        this.height = height;
        this.width = width;
        this.row = row;
        this.col = col;
        rectangleHeight = height / row;
        rectangleWidth = width / col;
        vertexCount = row * col;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
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

    public int getVertexCount() {
        return vertexCount;
    }


}
