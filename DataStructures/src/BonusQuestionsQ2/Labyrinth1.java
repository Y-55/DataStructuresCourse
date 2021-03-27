/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BonusQuestionsQ2;

/**
 *
 * @author Yusuf Abdullah
 */
public class Labyrinth1 {

    protected String[][] labyrinth = {
        {"0", "0", "0", "x", "0", "x"},
        {"0", "x", "0", "x", "0", "x"},
        {"0", "*", "x", "0", "x", "0"},
        {"0", "x", "0", "0", "0", "0"},
        {"0", "0", "0", "x", "x", "0"},
        {"0", "0", "0", "x", "0", "x"}
    };

    public Labyrinth1() {

    }

    public void Arranging() {
        change(2, 1);
        zeroToU();
    }

    public void change(int a, int b) {
        int next;
        int current;

        boolean above = false;
        boolean below = false;
        boolean left = false;
        boolean right = false;

        //for The element above-----------------------------------------------
        if (a + 1 < this.labyrinth.length && !(labyrinth[a + 1][b].equals("x")) && !(labyrinth[a + 1][b].equals("*"))) {
            if (labyrinth[a][b].equals("*")) {
                labyrinth[a + 1][b] = "1";
                above = true;
            } else {
                next = Integer.parseInt(labyrinth[a + 1][b]);
                current = Integer.parseInt(labyrinth[a][b]) + 1;
                if (current < next || next == 0) {
                    above = true;
                    labyrinth[a + 1][b] = current + "";
                }

            }

        }
        //for The item below-----------------------------------------------
        if (a - 1 >= 0 && !(labyrinth[a - 1][b].equals("x")) && !(labyrinth[a - 1][b].equals("*"))) {
            if (labyrinth[a][b].equals("*")) {
                labyrinth[a - 1][b] = "1";
                below = true;
            } else {
                next = Integer.parseInt(labyrinth[a - 1][b]);
                current = Integer.parseInt(labyrinth[a][b]) + 1;
                if (current < next || next == 0) {
                    below = true;
                    labyrinth[a - 1][b] = current + "";

                }
            }

        }
        //for Right item------------------------------------------------
        if (b + 1 < this.labyrinth.length && !(labyrinth[a][b + 1].equals("x")) && !(labyrinth[a][b + 1].equals("*"))) {
            if (labyrinth[a][b].equals("*")) {
                labyrinth[a][b + 1] = "1";
                right = true;
            } else {
                next = Integer.parseInt(labyrinth[a][b + 1]);
                current = Integer.parseInt(labyrinth[a][b]) + 1;
                if (current < next || next == 0) {
                    right = true;
                    labyrinth[a][b + 1] = current + "";
                }
            }

        }
        //for left item-----------------------------------------------
        if (b - 1 >= 0 && !(labyrinth[a][b - 1].equals("x")) && !(labyrinth[a][b - 1].equals("*"))) {
            if (labyrinth[a][b].equals("*")) {
                labyrinth[a][b - 1] = "1";
                left = true;
            } else {
                next = Integer.parseInt(labyrinth[a][b - 1]);
                current = Integer.parseInt(labyrinth[a][b]) + 1;
                if (current < next || next == 0) {
                    left = true;
                    labyrinth[a][b - 1] = current + "";
                }
            }
        }
        //-----------------------------------------------
        if (right) {
            change(a, b + 1);
        }
        if (above) {
            change(a + 1, b);
        }
        if (below) {
            change(a - 1, b);
        }
        if (left) {
            change(a, b - 1);
        }

    }

    public void zeroToU() {
        for (int i = 0; i < labyrinth.length; i++) {
            for (int j = 0; j < labyrinth[i].length; j++) {
                if (labyrinth[i][j].equals("0")) {
                    labyrinth[i][j] = "u";
                }
            }
        }
    }

    public void print() {
        for (int i = 0; i < labyrinth.length; i++) {
            System.out.print("{");
            for (int j = 0; j < labyrinth[i].length; j++) {
                if (j == labyrinth[i].length - 1) {
                    System.out.print(labyrinth[i][j]);
                } else {
                    System.out.print(labyrinth[i][j] + ",");
                }

            }
            System.out.println("}");
        }
        System.out.println("");
    }
}
