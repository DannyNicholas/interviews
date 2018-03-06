package interviews.stringReverse;

/**
 * Reverse a given string
 */
public class StringReverse {

    public static void main(String[] args) {

        String myName = "Danny Nicholas";

        StringBuilder reversedName = new StringBuilder();
        for (int i = myName.length() - 1; i >= 0; i--) {
            reversedName.append(myName.charAt(i));
        }

        System.out.println(reversedName.toString());
    }
}
