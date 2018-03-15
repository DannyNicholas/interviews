package interviews.anagrams;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Create all possible anagrams for a supplied word
 */
public class Anagrams {

    // create a set of anagrams for a word
    private static Set<String> anagrams(String word) {
        char[] chars = word.toCharArray();
        return anagramRecursive(chars, 0);
    }

    private static Set<String> anagramRecursive(char[] chars, int startIndex) {

        Set<String> set = new HashSet<String>();

        if (startIndex == chars.length-1) {
            set.add(new String(chars));
        }
        else {
            // iteratively swap chars with char at start
            for (int i = startIndex; i < chars.length; i ++) {

                // swap chars in a copy
                char[] copy = Arrays.copyOf(chars, chars.length);
                copy[startIndex] = chars[i];
                copy[i] = chars[startIndex];
                set.addAll(anagramRecursive(copy, startIndex+1));
            }
        }

        return set;
    }

    public static void main(String[] args) {
        Set<String> anagrams = anagrams("dog");
        System.out.println(anagrams);
        System.out.println(anagrams.size());
    }
}
