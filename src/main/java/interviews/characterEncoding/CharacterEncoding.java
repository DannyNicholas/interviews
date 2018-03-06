package interviews.characterEncoding;

/**
 * Encode a string of characters so that repeated character are represented by character and number.
 * e.g. "aaaa" -> "a4"
 */
public class CharacterEncoding {

    public static void main(String[] args) {

        final String letters = "aabbbccddddaaa";
        final char[] chars = letters.toCharArray();
        int charCount = 0;

        StringBuilder code = new StringBuilder();

        for (int i = 0; i< chars.length; i++) {

            char character = chars[i];
            charCount++;

            // are we at end of string or is next character different?
            if(i == chars.length - 1 || character != chars[i+1])
            {
                code.append(character).append(charCount);
                charCount = 0;
            }
        }

        System.out.println(code.toString());
    }
}
