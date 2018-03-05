package interviews.anagrams;

import java.util.HashSet;
import java.util.Set;

public class Anagrams {

    // create a set of anagrams for a word
    private static Set<String> anagrams(String word) {
        Set<String> anagrams = new HashSet<>();
        char[] chars = word.toCharArray();
        anagramRecursive(anagrams, chars, 0);
        return anagrams;
    }

    private static void anagramRecursive(Set<String> anagrams, char[] chars, int index) {

        if (index == chars.length-1) {
            anagrams.add(new String(chars));
        }
        else {
            for (int i = index; i < chars.length; i ++) {

                // swap chars
                char tmp = chars[index];
                chars[index] = chars[i];
                chars[i] = tmp;

                anagramRecursive(anagrams, chars, index+1);

                // swap chars back
                tmp = chars[index];
                chars[index] = chars[i];
                chars[i] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        Set<String> anagrams = anagrams("hello");
        System.out.println(anagrams);
    }
}
