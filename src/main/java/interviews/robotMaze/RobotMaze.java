package interviews.robotMaze;

import java.util.ArrayList;
import java.util.List;

/**
 * Robot needs to find a route from top-left to bottom-right
 * without walking on any illegal cells (1s).
 *
 * Robot can only move RIGHT or DOWN
 */
public class RobotMaze {

    // maze - robot can only walk on '0's.
    // 1s are not allowed
    private static int[][] MAZE = new int[][]{
            {0, 1, 1, 0},
            {0, 0, 0, 0},
            {0, 1, 0, 1},
            {0, 1, 0, 0}
    };

    public static void main(String[] args) {

        Point startPosition = new Point(0, 0);
        List<Point> path = new ArrayList<>();
        boolean success = move(path, startPosition, MAZE);
        System.out.println("Path: " + path);
        System.out.println("Success: " + success);
    }

    public static boolean move(List<Point> path, Point position, int[][] maze) {

        if(illegalPoint(position, maze)) {
            return false;
        }

        if(reachedFinish(position)
                || move(path, new Point(position.row+1, position.col), maze)
                || move(path, new Point(position.row, position.col+1), maze)
                ) {
            path.add(position);
            return true;
        }

        return false;
    }

    private static boolean illegalPoint(Point position, int[][] maze) {
        return (position.row > 3 || position.col > 3 || maze[position.row][position.col] == 1);
    }

    private static boolean reachedFinish(Point position) {
        return (position.row == 3 && position.col == 3);
    }

    /**
     * Represents the Robot's current point
     */
   public static class Point {
        public int row;
        public int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
       public String toString() {
            return row + "," + col;
        }
   }
}





