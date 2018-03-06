package interviews.highestMeanScore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  Find the student with the highest mean score.
 *
 * input = {Charles=[50, 80], Barry=[67], John=[49]}
 *
 * Charles=[50, 80] -> 65
 * Barry=[67]
 * John=[49]
 *
 * Highest Mean:67 (Barry)
 */
public class HighestMeanScore {
    public static void main(String[] args) {

        String[][] scores = new String[][] {
                { "Charles", "50" },
                { "Barry", "67" },
                { "Charles", "80" },
                { "John", "49" }
        };

        HighestMeanScore sol = new HighestMeanScore();
        int hms = sol.highestMeanScore(scores);
        System.out.println("Highest Mean:" + hms);
    }

    private int highestMeanScore ( String[][] scores) {

        Map<String, List<Integer>> meanScore = new HashMap<>();

        for (String[] aScore : scores) {
            String name = aScore[0];
            Integer score = Integer.parseInt(aScore[1]);
            addToMeanScores(meanScore, name, score);
        }

        System.out.println(meanScore);

        return findHighestMeanScore(meanScore);
    }

    // add supplied name and score to the existing map
    private void addToMeanScores(Map<String, List<Integer>> meanScore, String name,  Integer score) {

        List<Integer> means;
        if (meanScore.containsKey(name)) {
            means = meanScore.get(name);
        }
        else {
            means = new ArrayList<>();
        }
        means.add(score);
        meanScore.put(name, means);
    }

    // find the highest mean score from the map
    private Integer findHighestMeanScore(Map<String, List<Integer>> meanScores) {

        Integer highestMean = null;

        for (Map.Entry<String, List<Integer>> map : meanScores.entrySet()) {
            System.out.println(map);
            List<Integer> numbers = map.getValue();
            Integer sum = numbers.stream().mapToInt(Integer::intValue).sum();
            Integer count = numbers.size();
            Integer mean = sum / count;

            System.out.println(mean);

            if (highestMean == null || mean > highestMean) {
                highestMean = mean;
            }
        }

        return highestMean;
    }
}
