package interviews.characterCount;

import java.util.HashMap;
import java.util.Map;

/**
 * Find the first char that only appears once in a string.
 */
public class FindFirstSingleChar {
    public static void main(String[] args) {

        FindFirstSingleChar sol = new FindFirstSingleChar();
        sol.findFirstSingleChar("hello");
        sol.findFirstSingleChar("zzyxxx");
        sol.findFirstSingleChar("kayak");
    }

    public void findFirstSingleChar(final String word) {

        System.out.println(word);

        char[] chars = word.toCharArray();

        // this is flawed as we lose ordering with a hash-map
        // we can no longer find the first char
        Map<Character, Integer> charCount = new HashMap<>();

        for(char c : chars) {
            if (charCount.containsKey(c)) {
                int count = charCount.get(c);
                charCount.put(c, count + 1);
            }
            else {
                charCount.put(c , 1);
            }
        }
        System.out.println(charCount);

        for(char c : chars) {
            int count = charCount.get(c);
            if (count == 1) {
                System.out.println(c + " - " + count);
                break;
            }
        }
    }
}
