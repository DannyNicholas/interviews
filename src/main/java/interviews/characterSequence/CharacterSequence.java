package interviews.characterSequence;

/**
 * Find the longest substring made up of the same character.
 * e.g. "aaaabbbcc" -> "aaaa"
 */
public class CharacterSequence {

    public static void main(String[] args) {

        CharacterSequence sol = new CharacterSequence();

        String longestSubString = sol.longestSubString("bbbbbaaaaaaaaaccccccccc");
        System.out.println("Result: "+ longestSubString);
        System.out.println("------------");

        longestSubString = sol.longestSubString("b");
        System.out.println("Result: "+ longestSubString);
        System.out.println("------------");

        longestSubString = sol.longestSubString("hello");
        System.out.println("Result: "+ longestSubString);
        System.out.println("------------");
    }

    public String longestSubString(String word) {

        Character currentChar = null;
        int currentCharLength = 0;
        int currentCharStartIndex = 0;

        Character longestChar = null;
        int longestCharLength = 0;
        int longestCharStartIndex = 0;

        for (int i = 0; i < word.length(); i++) {

            char nextChar = word.charAt(i);

            // reset if the next char is different
            if (currentChar == null || nextChar != currentChar) {
                currentCharStartIndex = i;
                currentCharLength = 0;
                currentChar = nextChar;
            }

            currentCharLength++;

            // is the current sequence the longest seen
            if (currentCharLength > longestCharLength) {
                longestChar = currentChar;
                longestCharLength = currentCharLength;
                longestCharStartIndex = currentCharStartIndex;
            }
        }

        System.out.println("Longest char: " + longestChar);
        System.out.println("Longest length: " + longestCharLength);
        System.out.println("Start index: " + longestCharStartIndex);

        return word.substring(longestCharStartIndex, longestCharStartIndex + longestCharLength);
    }
}
