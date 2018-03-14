package interviews.matrixSearch;

public class MatrixSearchTest {

    static int[][] matrix = {
            {15, 20, 40, 85},
            {20, 36, 80, 95},
            {30, 50, 95, 105},
            {40, 80, 100, 120}
    };

    public static void main(String[] args) {

        boolean isFound = findElement(matrix, 85);
        System.out.println(isFound);

    }

    public static boolean findElement(int[][] matrix, int elem) {
        return findElement(matrix, elem, 0, matrix.length - 1, 0, matrix[0].length - 1);
    }

    private static boolean findElement(int[][] matrix, int elem, int rowStart, int rowEnd, int colStart, int colEnd) {

        System.out.println("rs=" + rowStart + ",re=" + rowEnd +",cs=" + colStart + ",ce=" + colEnd);

        if (matrix[rowStart][colStart] > elem) {
            return false;
        }

        if (matrix[rowEnd][colEnd] < elem) {
            return false;
        }

        int iterations = Math.min(rowEnd-rowStart, colEnd-colStart);
        for (int i = 0; i <= iterations; i++) {

            int row = rowStart + i;
            int col = colStart + i;

            System.out.println(row + "," + col + "=" + matrix[row][col]);

            if (matrix[row][col] == elem) {
                return true;
            }

            if (matrix[row][col] > elem) {
                if (findElement(matrix, elem, rowStart, row ,  col , colEnd)) {
                    return true;
                }

                return findElement(matrix, elem, row, rowEnd, colStart, col );
            }
        }


        return false;
    }
}
