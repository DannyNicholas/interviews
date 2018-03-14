package interviews.binaryGap;

/**
 * A binary gap within a positive integer N is any maximal sequence of consecutive zeros that is surrounded by ones at both ends in the binary representation of N.
 * For example, number 9 has binary representation 1001 and contains a binary gap of length 2. The number 529 has binary representation 1000010001 and contains two binary gaps: one of length 4 and one of length 3. The number 20 has binary representation 10100 and contains one binary gap of length 1. The number 15 has binary representation 1111 and has no binary gaps.
 *
 * Write a function:
 * class Solution { public int solution(int N); }
 * that, given a positive integer N, returns the length of its longest binary gap. The function should return 0 if N doesn't contain a binary gap.
 *
 * For example, given N = 1041 the function should return 5, because N has binary representation 10000010001 and so its longest binary gap is of length 5.
 *
 * Assume that:
 * N is an integer within the range [1..2,147,483,647].
 *
 * Complexity:
 * expected worst-case time complexity is O(log(N))
 * expected worst-case space complexity is O(1).
 */
public class BinaryGap {

    public static void main(String[] args) {
        BinaryGap bg = new BinaryGap();
        bg.solution(8);
        bg.solution(9);
        bg.solution(1025);
        bg.solution(1041);


    }


    public int solution(int N) {

        String binary = convertToBinary(N);
        System.out.println(N + " = " + binary);
        char[] binaryChars = binary.toCharArray();

        Integer longestGap = null;
        Integer count = 0;
        boolean counting = false;
        for(int i = 0; i < binaryChars.length; i++ ) {

            if (counting && binaryChars[i] == '0') {
                count++;
            }
            else {
                if ((counting) && (longestGap == null || count > longestGap)) {
                    longestGap = count;
                }
                counting = true;
                count = 0;
            }
        }

        int gap = longestGap == null ? 0 : longestGap;
        System.out.println("LongestGap = " + gap);

        return gap;
    }

    // zero counting logic could be moved to this method
    private String convertToBinary(int num) {

        StringBuilder sb = new StringBuilder();
        int n = num;
        Integer longestGap = null;
        Integer count = 0;
        boolean counting = false;

        for (int i = nearestPowerOfTwo(n); i > 0; i = i/2) {
            if (n >= i) {

                // we have a '1'
                sb.append(1);
                n = n - i;
                if ((counting) && (longestGap == null || count > longestGap)) {
                    longestGap = count;
                }
                counting = true;
                count = 0;

            }
            else {

                // we have a '0'
                sb.append(0);
                if (counting) {
                    count++;
                }
            }
        }

        String binary = sb.toString();
        System.out.println(num + " = " + binary);

        int gap = longestGap == null ? 0 : longestGap;
        System.out.println("LongestGap = " + gap);

        return binary;
    }

    private int nearestPowerOfTwo(int n) {
        int i = 1;
        while (n/2 >= i) {
            i *= 2;
        }
        return i;
    }
}
