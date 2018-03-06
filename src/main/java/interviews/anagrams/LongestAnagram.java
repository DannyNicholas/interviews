package interviews.anagrams;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Find the longest word/s that exist in the dictionary that are anagrams of the supplied letters.
 *
 * e.g. input = "otge" -> Matches found:[toe, got, tog]
 */
public class LongestAnagram {

    static String[] dictionary = new String[] {
            "toe", "toes", "got", "toga", "other", "tog"
    };

    private Map<String, Set<String>> sortedDictionary;

    public static void main(String[] args) {
        LongestAnagram sol = new LongestAnagram();
        sol.longestAnagram("otge");
        System.out.println("------------------");
        sol.longestAnagram("otes");
        System.out.println("------------------");
        sol.longestAnagram("hello");
    }

    public LongestAnagram () {
        this.sortedDictionary = initialiseDictionary();
    }

    public Set<String> longestAnagram(String str) {

        System.out.println("Anagrams for: " + str);

        // creates all permutations of word mapped by string length
        Map<Integer, Set<String>> allPermutations = permutations(str);

        Integer maxLength = allPermutations.keySet().stream().mapToInt(Integer::intValue).max().getAsInt();

        // iterate from longest permutations to smallest
        for (int length = maxLength; length > 0; length--) {

            // find all permutations of current length
            Set<String> words = allPermutations.get(length);

            // do any of these permutations exist in our dictionary map?
            Set<String> matches = new HashSet<>();
            for (String word : words) {
                if (sortedDictionary.containsKey(word)) {
                    matches.addAll(sortedDictionary.get(word));
                }
            }

            if (matches.size() > 0) {
                System.out.println("Matches found:" + matches);
                return matches;
            }
        }

        System.out.println("No matches found.");
        return new HashSet<>();
    }

    // initialises dictionary map
    // key is sorted in character order
    // value is a set of all matching words from dictionary
    private Map<String, Set<String>> initialiseDictionary() {

        Map<String, Set<String>> sortedDictionary = new HashMap<>();

        for (String word : dictionary) {
            String sortedWord = sortString(word);

            Set<String> wordSet = sortedDictionary.getOrDefault(sortedWord, new HashSet<>());
            wordSet.add(word);
            sortedDictionary.put(sortedWord, wordSet);
        }

        System.out.println("Dictionary initialised:");
        System.out.println(sortedDictionary);

        return sortedDictionary;
    }

    // sorts string in order of chars
    private static String sortString(String word) {
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    // creates all permutations of a string
    // organised by length
    private static Map<Integer, Set<String>> permutations(String word) {

        List<String> permutations = nuPowerSet(word);

        Map<Integer, Set<String>> allPermutations = new HashMap<>();
        for(String aPermutation : permutations) {
            Integer length = aPermutation.length();
            String sortedPermutation = sortString(aPermutation);

            // add sorted permutation to map by string length
            Set<String> permutationSet = allPermutations.getOrDefault(length, new HashSet<>());
            permutationSet.add(sortedPermutation);
            allPermutations.put(length, permutationSet);
        }

        System.out.println("Permutations:");
        System.out.println(allPermutations);
        return allPermutations;

    }

    private static List<String> nuPowerSet(String s) {

        if (s.length() == 0) { // trivial, subset of empty string is empty
            return new ArrayList<>();
        }

        String head = s.substring(0, 1);
        if (s.length() ==1) // the subset of a one character string is exactly that character
            return Arrays.asList(head);

        String tail = s.substring(1);

        ArrayList<String> ps = new ArrayList<String>();

        ps.add(head); // one of the subsets is the current first character

        List<String> tailSubsets = nuPowerSet(tail); // all the subsets of the remainder.


        List<String> tailSubsetsWithCurrentHeadPrepended = tailSubsets
                .stream()
                .map(element -> head + element)
                .collect(Collectors.toList());

        ps.addAll(tailSubsets);
        ps.addAll(tailSubsetsWithCurrentHeadPrepended);

        return ps;
    }

}
