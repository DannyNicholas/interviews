package interviews.binarySearch;

/**
 * Binary search to find item in an ordered array
 */
public class BinarySearch {

    private static int[] numbers = new int[] { 2, 5, 6, 7, 8, 10, 12 };

    public static void main(String[] args) {

        System.out.println(binarySearch(numbers, 2));
        System.out.println(binarySearch(numbers, 12));
        System.out.println(binarySearch(numbers, 7));
        System.out.println(binarySearch(numbers, 9));
        System.out.println(binarySearch(numbers, 0));
        System.out.println(binarySearch(numbers, 14));
    }

    private static int binarySearch(int[] numbers, int searchValue) {

        // pointers for search range
        int start = 0;
        int finish = numbers.length - 1;

        while(start <= finish) {

            int index = (start + finish) / 2;
            int value = numbers[index];

            if (value == searchValue) {
                return index;
            }

            if (searchValue < value) {
                finish = index - 1;
            }
            else {
                start = index + 1;
            }

        }

        return -1;
    }
}
