package interviews.rockCollector;

/**
 * Find the highest value path through a 2D area.
 * Each location contains a number of rocks to collect.
 * From each point you can only move north or east.
 * <p>
 * Start bottom-left and finish top-right.
 *
 * This is an improved version that requires a single
 * pass through the array and no recursion. Steps back from
 * end and at each point looks at the best direction
 * east or north, the matrix is updated to reflect this
 * value plus any in your own cell.
 */
public class RockCollectorOptimised {

    public static int[][] cities = new int[][]{
            {1, 0, 0, 0, 2},
            {5, 0, 1, 2, 2},
            {2, 3, 1, 1, 1}
    };

    public static void main(String[] args) {
        RockCollectorOptimised sol = new RockCollectorOptimised();
        sol.start();
    }


    public void start() {

        int lastRow = cities.length - 1;
        int lastColumn = cities[0].length - 1;

        int row = 0;
        int column = lastColumn;

        int originRow = lastRow;
        int originColumn = 0;

        boolean finished = false;

        while (!finished) {

            // move one position
            column -= 1;
            if (column < 0) {
                row += 1;
                column = lastColumn;
            }

            int rocks = cities[row][column];

            // add the best from north/east cities
            rocks += bestRocks(cities, row, column);

            // update the matrix
            cities[row][column] = rocks;

            System.out.println(row + "," + column + "=" + rocks);

            // have we finished
            if (row == originRow && column == originColumn) {
                finished = true;
            }
        }
    }

    // find the highest value rocks from north or east
    private int bestRocks(int[][] cities, int row, int column) {

        // look north
        int northRocks = 0;
        if (row > 0) {
            northRocks = cities[row - 1][column];
        }
        // look east
        int eastRocks = 0;
        if (column < cities[0].length - 1) {
            eastRocks = cities[row][column + 1];
        }

        return (northRocks > eastRocks) ? northRocks : eastRocks;
    }
}
