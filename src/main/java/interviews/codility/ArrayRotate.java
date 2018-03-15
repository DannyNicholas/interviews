package interviews.codility;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// A zero-indexed array A consisting of N integers is given. Rotation of the array means that each element is shifted right by one index, and the last element of the array is moved to the first place. For example, the rotation of array A = [3, 8, 9, 7, 6] is [6, 3, 8, 9, 7] (elements are shifted right by one index and 6 is moved to the first place).
//
// The goal is to rotate array A K times; that is, each element of A will be shifted to the right K times.
//
// Write a function:
//
// class Solution { public int[] solution(int[] A, int K); }
//
// that, given a zero-indexed array A consisting of N integers and an integer K, returns the array A rotated K times.
//
// For example, given
//
// A = [3, 8, 9, 7, 6]
// K = 3
// the function should return [9, 7, 6, 3, 8]. Three rotations were made:
//
// [3, 8, 9, 7, 6] -> [6, 3, 8, 9, 7]
// [6, 3, 8, 9, 7] -> [7, 6, 3, 8, 9]
// [7, 6, 3, 8, 9] -> [9, 7, 6, 3, 8]
// For another example, given
//
// A = [0, 0, 0]
// K = 1
// the function should return [0, 0, 0]
//
// Given
//
// A = [1, 2, 3, 4]
// K = 4
// the function should return [1, 2, 3, 4]
//
// Assume that:
//
// N and K are integers within the range [0..100];
// each element of array A is an integer within the range [−1,000..1,000].
public class ArrayRotate {

    public static void main(String[] args) {
        ArrayRotate rot = new ArrayRotate();

        // rotate list 2 places
        int[] result1 = rot.solution(new int[] { 1, 2, 3, 4 }, 2);
        List<Integer> list1 = Arrays.stream(result1).boxed().collect(Collectors.toList());
        System.out.println(list1);
    }

    public int[] solution(int[] A, int K) {

        int[] B;
        for (int i = 0; i < K; i ++) {
            B = rotate(A);
        }

        int[] C = rotateAll(A, K);

        return C;
    }

    /**
     * Simple rotate that rotates on place right at a time.
     * Need to call repeatedly for multiple place rotation
     * @param array
     * @return
     */
    private int[] rotate(int[] array) {

        int[] newArray = new int[array.length];
        for (int i = array.length-1; i > 0 ; i --) {
            newArray[i] = array[i-1];
        }
        newArray[0] = array[array.length-1];
        return array;
    }

    /**
     * Rotates K places right in one operation.
     *
     * @param array
     * @param K
     * @return
     */
    private int[] rotateAll(int[] array, int K) {

        int[] newArray = new int[array.length];
        for (int i = 0; i <  array.length ; i++) {
            int index = (i+K) % array.length;
            newArray[index] = array[i];
        }

        return newArray;
    }
}
