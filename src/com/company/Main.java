package com.company;
import java.awt.*;
import java.io.*;
import java.lang.*;
import java.net.*;
import java.util.*;
import javax.imageio.*;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("");
        Maze maze = new Maze();
        navigation(maze);
    }
    public static void navigation(Maze maze) {
        System.out.println("Navigate the maze and reach the end. (Controls: UP, DOWN, LEFT, RIGHT) ");
        maze.setupRandomMaze(maze.maze_layout);
        maze.visualizeMaze(maze.maze_layout, maze.maze);
        maze.visualizePlayerSpace(maze.maze);
        Scanner navigation_input = new Scanner(System.in);
        Random navi_random = new Random();
        while (true) {
            String navi_input = navigation_input.nextLine();
            maze.visualizeMaze(maze.maze_layout, maze.maze);
            maze.changePlayerPosition(navi_input, maze.maze_layout);
            maze.visualizePlayerSpace(maze.maze);
            if (navi_random.nextInt(3) == 1) {
                maze.maze.setVisible(false);
                maze.maze.setVisible(true);
            }
            else {
                continue;
            }
        }
    }
}
