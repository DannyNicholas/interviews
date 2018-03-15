package interviews.codility;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Find smallest positive integer that does not occur in array
 */
public class SmallestMissingInteger {

    public static void main(String[] args) {

        int[] numbers = new int[] {2, 3, 1, 5};
        int missing = solution(numbers);
        System.out.println(missing);

        int[] numbers2 = new int[] {1, 2, 3};
        int missing2 = solution(numbers2);
        System.out.println(missing2);

        int[] numbers3 = new int[] {-1, -3};
        int missing3 = solution(numbers3);
        System.out.println(missing3);

        int[] numbers4 = new int[] {-1, -3, 1, 2};
        int missing4 = solution(numbers4);
        System.out.println(missing4);
    }

    public static int solution(int[] A) {

        Set<Integer> numbers = Arrays.stream(A).boxed().collect(Collectors.toSet());
        int max =  Arrays.stream(A).max().getAsInt();

        // quick exit - also handles negative lists
        if (!numbers.contains(1)) {
            return 1;
        }

        // search for missing numbers
        for (int i = 1; i <= max; i ++) {
            if (!numbers.contains(i)) {
                return i;
            }
        }

        // to get to this point no numbers were missing e.g. [1, 2, 3, 4]
        // so smallest missing is max+1 e.g [5]
        return max + 1;
    }
}
