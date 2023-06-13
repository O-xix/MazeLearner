package com.company;
import java.awt.*;
import java.io.*;
import java.lang.*;
import java.net.*;
import java.util.*;
import javax.imageio.*;
import javax.swing.*;

/**
 * Write a description of class Maze here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Maze {
    String[][] maze_layout = new String[24][24];
    DrawingPanel maze = new DrawingPanel(600, 600);
    int currentXpos = 1;
    int currentYpos = 1;
    public void setupRandomMaze(String[][] maze_layout) {
        //make it empty at first
        for (int i = 0; i < maze_layout.length; i++) {
            for (int j = 0; j < maze_layout[i].length; j++) {
                maze_layout[i][j] = "empty";
            }
        }
        //set up bordering walls
        for (int i = 0; i < maze_layout.length; i++) {
            for (int j = 0; j < maze_layout[i].length; j++) {
                if (i == 0 || i == 23) {
                    maze_layout[i][j] = "wall";
                }
                else if (j == 0 || j == 23) {
                    maze_layout[i][j] = "wall";
                }
                else {
                    continue;
                }
            }
        }
        //set up starting and ending spaces
        maze_layout[1][1] = "start";
        maze_layout[22][22] = "end";
        //set up a winning path
        int pathx = 1;
        int pathy = 1;
        String current = maze_layout[1][1];
        int direction = 0;
        Random random = new Random();
        while (!(pathx == 22 && pathy == 22)) {
            direction = random.nextInt(3);
            if(direction == 0 && pathx < 22) {
                pathx++;
            }
            else if(direction == 1 && pathy < 22) {
                pathy++;
            }
            else if(direction == 2 && pathx > 1) {
                pathx--;
            }
            else if(direction == 3 && pathy > 1) {
                pathy--;
            }
            else {
                continue;
            }
            maze_layout[pathx][pathy] = "walkable";
            current = maze_layout[pathx][pathy];
        }
        //reassign last space as finish
        maze_layout[22][22] = "end";
        //figure out the remaining spaces
        for (int i = 0; i < maze_layout.length; i++) {
            for (int j = 0; j < maze_layout[i].length; j++) {
                current = maze_layout[i][j];
                if (current.equals("empty")) {
                    direction = random.nextInt(2);
                    if (direction == 0) {
                        maze_layout[i][j] = "wall";
                    }
                    else if (direction == 1) {
                        maze_layout[i][j] = "walkable";
                    }
                }
            }
        }
        //print the maze layout
        /*
        for (int i = 0; i < maze_layout.length; i++) {
            for (int j = 0; j < maze_layout[i].length; j++) {
                System.out.print(maze_layout[i][j] + ", ");
            }
            System.out.println();
        }
        */
    }
    public void visualizeMaze(String[][] maze_layout, DrawingPanel panel) {
        Graphics maze = panel.getGraphics();
        for (int i = 0; i < maze_layout.length; i++) {
            for (int j = 0; j < maze_layout[i].length; j++) {
                if (maze_layout[i][j].equals("wall")) {
                    maze.setColor(new Color(0, 0, 0));
                    maze.fillRect(i * 25, j * 25, 25, 25);
                }
                else if (maze_layout[i][j].equals("start")) {
                    maze.setColor(new Color(0, 0, 255));
                    maze.fillRect(i * 25, j * 25, 25, 25);
                }
                else if (maze_layout[i][j].equals("end")) {
                    maze.setColor(new Color(0, 255, 0));
                    maze.fillRect(i * 25, j * 25, 25, 25);
                }
                else if (maze_layout[i][j].equals("walkable")) {
                    maze.setColor(new Color(255, 255, 255));
                    maze.fillRect(i * 25, j * 25, 25, 25);
                }
                else {
                    continue;
                }
            }
        }
    }
    public void changePlayerPosition(String input, String[][] maze_layout) {
        if (input.equals("UP")) {
            currentYpos--;
            if (maze_layout[currentXpos][currentYpos].equals("wall")) {
                currentYpos++;
            }
            else if (maze_layout[currentXpos][currentYpos].equals("end")) {
                System.out.println("YOU WIN!");
                System.exit(0);
            }
            else {
                return;
            }
        }
        else if (input.equals("DOWN")) {
            currentYpos++;
            if (maze_layout[currentXpos][currentYpos].equals("wall")) {
                currentYpos--;
            }
            else if (maze_layout[currentXpos][currentYpos].equals("end")) {
                System.out.println("YOU WIN!");
                System.exit(0);
            }
            else {
                return;
            }
        }
        else if (input.equals("LEFT")) {
            currentXpos--;
            if (maze_layout[currentXpos][currentYpos].equals("wall")) {
                currentXpos++;
            }
            else if (maze_layout[currentXpos][currentYpos].equals("end")) {
                System.out.println("YOU WIN!");
                System.exit(0);
            }
            else {
                return;
            }
        }
        else if (input.equals("RIGHT")) {
            currentXpos++;
            if (maze_layout[currentXpos][currentYpos].equals("wall")) {
                currentXpos--;
            }
            else if (maze_layout[currentXpos][currentYpos].equals("end")) {
                System.out.println("YOU WIN!");
                System.exit(0);
            }
            else {
                return;
            }
        }
        else {
            return;
        }
    }
    public void visualizePlayerSpace(DrawingPanel panel) {
        Graphics player = panel.getGraphics();
        player.setColor(new Color(255, 0, 0));
        player.fillRect(currentXpos * 25, currentYpos * 25, 25, 25);
    }
}
