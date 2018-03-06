package interviews.matrixSearch;

/**
 * Find a value in a n x m sorted matrix.
 *
 * Each row is sorted.
 * Each column is sorted.
 */
public class MatrixSearch {

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

        int rowStart = 0;
        int colStart = 0;
        int rowEnd = matrix.length;
        int colEnd =  matrix[0].length;

        return findDiagonal(matrix, elem, rowStart, colStart, rowEnd, colEnd);



//     int row = findRow(matrix, elem);
//     System.out.println("row: " + row);
//     if (row != -1) {
//       return binarySearch(matrix[row], elem);
//     }

//     return false;
    }

    public static int findRow(int[][] matrix, int elem) {

        for(int i = 0; i < matrix.length-1; i++) {

            int[] rowArray = matrix[i];
            if (elem >= rowArray[0] && elem <= rowArray[rowArray.length-1]) {
                return i;
            }
        }

        return -1;
    }


    public static boolean findDiagonal(int[][] matrix, int elem, int rowStart, int colStart, int rowEnd, int colEnd) {


        int shortestLongest = Math.min(rowEnd, colEnd);

        if (elem < matrix[rowStart][colStart]) {
            return false;
        }


        int col = colStart;
        for(int row = rowStart; row < rowEnd; row++) {

            if(elem == matrix[row][col]) {
                return true;
            }

            if(elem < matrix[row][col]) {

                if (findDiagonal(matrix, elem, rowStart, col, row, colEnd)) {
                    return true;
                }

                return findDiagonal(matrix, elem, row, colStart, rowEnd, col);
            }

            col++;
        }

        return false;

    }



    public static boolean binarySearch(int[] row, int elem) {

        int startIndex = 0;
        int endIndex = row.length - 1;
        boolean found = false;

        while(!found) {

            int midIndex = startIndex + ((endIndex - startIndex) / 2);
            System.out.println(midIndex);

            if (row[midIndex] == elem) {
                return true;
            }

            if (startIndex == endIndex) {
                return false;
            }

            if (elem <= row[midIndex]) {
                endIndex = midIndex;
            }
            else {
                startIndex = midIndex + 1;
            }

        }

        return false;

    }
}
