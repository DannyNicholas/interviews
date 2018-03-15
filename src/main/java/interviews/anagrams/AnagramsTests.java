package interviews.anagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnagramsTests {

    public static void main(String args[]) {
        System.out.println(anagrams("dog"));
    }

    public static List<String> anagrams(String word) {
        char[] chars = word.toCharArray();
        return anagrams(chars, 0);
    }

    public static List<String> anagrams(char[] chars, int startIdx) {

        List<String> anagrams = new ArrayList<>();

        // have we reached the end?
        if (startIdx == chars.length - 1) {
            anagrams.add(new String (chars));
        }


        // swap each letter from start index upwards
        for(int i = startIdx; i < chars.length; i ++) {

            char[] copy = Arrays.copyOf(chars, chars.length);
            copy[i] = chars[startIdx];
            copy[startIdx] = chars[i];
            anagrams.addAll(anagrams(copy, startIdx + 1));
        }

        return anagrams;
    }
}
