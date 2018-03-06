package interviews.wordDistance;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Find the shortest character length between two words in sentence.
 */
public class DistanceBetweenWords {

    private static String sentence = "This is some, test strings and I would like some cheese. Thank you!";
    private static Pattern pattern = Pattern.compile("[a-zA-Z]+");

    public static void main(String[] args) {

        DistanceBetweenWords dbw = new DistanceBetweenWords(sentence);

        Optional<Integer> count = dbw.distance("some", "you");
        if (count.isPresent()) {
            System.out.println(count.get());
        } else {
            System.out.println("No match!");
        }
    }

    private List<String> words;

    public DistanceBetweenWords(String text) {
        this.words = new ArrayList<>();

        final Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            words.add(matcher.group(0));
        }

    }

    public Optional<Integer> distance(String startingWord, String endingWord) {

        int characterCount = 0;
        Integer shortestCount = null;
        boolean counting = false;
        boolean foundWords = false;

        for (String aWord : words ) {

            // if we see starting word, start counting and reset count
            if (aWord.equals(startingWord)) {
                counting = true;
                characterCount = 0;
                continue;
            }

            // if we see ending word, stop counting.
            // check if this is the longest count
            if (aWord.equals(endingWord)) {
                if (counting) {
                    foundWords = true;
                    if (shortestCount == null || characterCount < shortestCount) {
                        shortestCount = characterCount;
                    }
                    counting = false;
                    characterCount = 0;
                }
                continue;
            }

            if (counting) {
                characterCount += aWord.length();
            }
        }

       if (foundWords) {
            return Optional.of(shortestCount + midPoint(startingWord) + midPoint(endingWord));
       }

       return Optional.empty();
    }

    private int midPoint(String word) {
        return word.length() / 2;
    }
}
