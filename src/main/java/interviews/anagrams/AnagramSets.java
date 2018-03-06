package interviews.anagrams;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Given a list of words, return a set of words where each word in an inner set is an anagram of every
 * other word in the list.
 *
 * for:[ "cat", "dog", "god", "cat" ] -> return [["cat"], ["dog", "god"]]
 */
public class AnagramSets {

    private static String[] words = new String[] { "cat", "dog", "god", "cat" };

    public static void main(String[] args) {

        // method one that uses a map with a sorted key
        // much faster!!
        anagramOne();

        System.out.println("-------------------------------------------");

        // method two that creates real anagrams
        // just to see if I could
        anagramTwo();
    }

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

    // create a sorted word map
    public static Map<String, Set<String>> sortedWordMap(List<String> words) {

        Map<String, Set<String>> sortedWordMap = new HashMap<>();
        for (String word : words) {
            String sortedString = sort(word);
            Set<String> wordSet = sortedWordMap.getOrDefault(sortedString, new HashSet<String>());
            wordSet.add(word);
            sortedWordMap.put(sortedString, wordSet);
        }

        System.out.println(sortedWordMap);
        return sortedWordMap;
    }


    public static String sort(String word) {
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public static void anagramOne() {
        List<String> wordList = Arrays.stream(words).collect(Collectors.toList());
        Map<String, Set<String>> sortedWordMap = sortedWordMap(wordList);

        // find matches for all words
        List<Set<String>> output = new ArrayList<>();
        for (String word : words) {
            String sortedWord = sort(word);

            if (sortedWordMap.containsKey(sortedWord)) {
                output.add(sortedWordMap.get(sortedWord));
            }
        }

        System.out.println(output);
    }

    public static void anagramTwo() {
        // add words to set for quick look-up
        Set<String> wordSet = new HashSet<>();
        for (String word : words) {
            wordSet.add(word);
        }

        List<Set<String>> output = new ArrayList<>();

        // find anagram matches for all words
        for (String word : words) {
            Set<String> anagrams = anagrams(word);

            // find anagrams in original word list
            Set<String> matches = new HashSet<>();
            for (String anAnagram : anagrams) {
                if (wordSet.contains(anAnagram)) {
                    matches.add(anAnagram);
                }
            }
            output.add(matches);

            System.out.println(anagrams);
            System.out.println(matches);
        }

        System.out.println(output);
    }
}
