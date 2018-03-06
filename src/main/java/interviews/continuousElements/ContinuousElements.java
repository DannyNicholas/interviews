package interviews.continuousElements;

/**
 * Given an array of non-negative integers and a target, find the length of the
 * shortest continuous sub-sequence.
 */
public class ContinuousElements {

    static private int[] numbers = new int[] { 12, 45, 34, 10, 5, 7, 9, 12 };
    static private int target = 40;

    /**
     * Track sub-sequence as two pointers. Start and end.
     * Both start at index 0
     *
     * If sequence is less than target then extend end pointer.
     * If sequence is more than target then increase start pointer. (can we find a smaller sequence?)
     */
    public static void main(String[] args) {

        int startIndex = 0;
        int endIndex = 0;
        boolean giveUp = false;
        Integer smallestSequenceLength = null;

        while(!giveUp) {

            int sequenceSum = sum(startIndex, endIndex);

            if (sequenceSum > target) {
                System.out.println(startIndex + " to " + endIndex + " = " + sequenceSum);
                int sequenceLength = endIndex - startIndex + 1;
                if (smallestSequenceLength == null || sequenceLength < smallestSequenceLength) {
                    smallestSequenceLength = sequenceLength;
                }

                // we've hit target but can we reduce sequence length further?
                if (sequenceLength > 1) {
                    startIndex++;
                }
                else {
                    endIndex++;
                }
            }
            else {
                // we haven't hit target so extend the end index to see a longer sequence
                endIndex++;
            }

            // if we've gone beyond array length then stop
            if (endIndex > numbers.length - 1) {
                giveUp = true;
            }
        }

        System.out.println("Shortest sequence: " + smallestSequenceLength);
    }

    private static int sum(int startIndex, int endIndex) {
        int sum = 0;
        for (int i = startIndex; i <= endIndex; i++) {
            sum += numbers[i];
        }
        return sum;
    }
}
