package interviews.SecondLowest;

/**
 * Find the second lowest number from an array
 * or 0 if the array contains less than 2 elements.
 */
public class SecondLowest {

    public static void main(String[] args) {

        int[] numbers = new int[] { 7, 8, 6, 5, 4, 3, 3, 4, 5 };

        SecondLowest sol = new SecondLowest();
        int num = sol.secondLowest(numbers);

        System.out.println("Second lowest : " + num);
    }

    public int secondLowest(int[] numbers) {

        if (numbers.length < 2) {
            return 0;
        }

        Integer lowest = null;
        Integer secondLowest = null;

        for (int nextNumber : numbers) {

            if (lowest == null || nextNumber < lowest) {
                secondLowest = lowest;
                lowest = nextNumber;
                continue;
            }

            if (secondLowest == null || (nextNumber < secondLowest && nextNumber > lowest)) {
                secondLowest = nextNumber;
            }

        }

        return secondLowest;
    }
}
