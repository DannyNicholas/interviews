package interviews.characterCount;

import java.util.HashMap;
import java.util.Map;

/**
 * Find the first char that only appears once in a string.
 */
public class FindFirstSingleChar {
    public static void main(String[] args) {

        FindFirstSingleChar sol = new FindFirstSingleChar();

        if (sol.testCases()) {
            System.out.println("All tests pass.");
        }
        else {
            System.out.println("Test failed.");
        }
    }

    private boolean testCases() {

        boolean first = (findFirstSingleChar("aabcdef") == 'b');
        boolean second = (findFirstSingleChar("hello") == 'h');
        boolean third = (findFirstSingleChar("zzyxxx") == 'y');
        boolean fourth = (findFirstSingleChar("kayak") == 'y');

        return first && second && third && fourth;
    }


    public char findFirstSingleChar(final String word) {

        System.out.println(word);

        char[] chars = word.toCharArray();

        Map<Character, Integer> charCount = new HashMap<>();

        for(char c : chars) {
            int count = charCount.getOrDefault(c, 0);
            charCount.put(c , count + 1);
        }
        System.out.println(charCount);

        Character firstChar = null;
        for(char c : chars) {
            int count = charCount.get(c);
            if (count == 1) {
                System.out.println(c + " - " + count);
                firstChar = c;
                break;
            }
        }

        return firstChar;
    }
}
