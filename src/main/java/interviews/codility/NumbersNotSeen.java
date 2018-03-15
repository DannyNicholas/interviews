package interviews.codility;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Find the missing element from a list [1, 2, ....(N + 1)]
 */
public class NumbersNotSeen {

    public static void main(String[] args) {

        int[] numbers = new int[] {2, 3, 1, 5};
        int missing = solution(numbers);
        System.out.println(missing);
    }

    public static int solution(int[] A) {

        // add expected numbers to a set
        Set<Integer> numbersNotSeen = IntStream.rangeClosed(1, A.length + 1).boxed().collect(Collectors.toSet());
        System.out.println(numbersNotSeen);

        for(Integer value : A) {
            numbersNotSeen.remove(value);
        }
        System.out.println(numbersNotSeen);

        // should have 1 remaining number
        return numbersNotSeen.iterator().next();
    }
}
