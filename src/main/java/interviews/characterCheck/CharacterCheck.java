package interviews.characterCheck;

/**
 * Determine which letters of the alphabet are missing from a supplied string.
 */
public class CharacterCheck {


    public static void main(String[] args) {

        String word = "quick brown fox";
//        String alphabet = "abcdefghijklmnopqrstuvwxyz";
//        char[] alphaChars = alphabet.toCharArray();

        StringBuilder missing = new StringBuilder();
        for (char c = 'a'; c <= 'z'; c++) {
            System.out.println(c);
            if (word.indexOf(c) != -1) {
                missing.append(c);
            }
        }

        System.out.println(missing.toString());

    }
}
