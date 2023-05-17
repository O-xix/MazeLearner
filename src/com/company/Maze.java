package com.company;

public class Maze {

    int[][] maze = new int[0][0];
    int length = 0;
    int width = 0;

    public void Maze(int l, int w) {
        maze = new int[l][w];
        length = l;
        width = w;

    }

    public void mazeGenerator() {
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                if (i == 0 || i == length) {

                }
                else if (j == 0 || j == width) {

                }
            }
        }
    }
}
