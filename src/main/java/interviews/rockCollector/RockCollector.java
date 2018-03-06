package interviews.rockCollector;

import java.util.ArrayList;
import java.util.List;

/**
 * Find the highest value path through a 2D area.
 * Each location contains a number of rocks to collect.
 * From each point you can only move north or east.
 *
 * Start bottom-left and finish top-right.
 */
public class RockCollector {

    public static int[][] cities = new int[][]{
            {1, 0, 0, 0, 2},
            {5, 0, 1, 2, 2},
            {2, 3, 1, 1, 1}
    };


    public static void main(String[] args) {
        RockCollector sol = new RockCollector();
        sol.start();
    }

    public void start() {

        List<Integer> path = new ArrayList<>();
        int biggestRoute = move(2,0,0,path);
        System.out.println("finished");
        System.out.println("Highest route: " + biggestRoute);
    }

    public int move(
            int row,
            int col,
            int sum,
            List<Integer> path) {

        int value = cities[row][col];
        sum = sum + value;
        path.add(value);

        if (row == 0 && col == 4) {
            System.out.println("end of path: " + sum);
            System.out.println(path);
            return sum;
        }

        int eastSum = 0;
        int northSum = 0;

        if (row > 0) {
            northSum = move(row - 1, col, sum, new ArrayList<>(path));
        }
        if (col < 4) {
            eastSum = move(row, col + 1, sum, new ArrayList<>(path));
        }

        if (eastSum > northSum) {
            return eastSum;
        }
        return northSum;
    }
}
