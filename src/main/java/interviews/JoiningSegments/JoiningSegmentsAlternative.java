package interviews.JoiningSegments;

import java.util.*;

/**
 * Given a list of pairs representing path segments, return the list of segments in an order that represents
 * one continuous path. e.g. (11, 4) -> (4, 9) -> (9, 5) -> (5, 1).
 *
 * Assume if you see a pair in one direction, you won't see it in the other. e.g. if you have (2, 1), you won't have
 * (1, 2). If you can't form a continuous path, throw an exception.
 */
public class JoiningSegmentsAlternative {

    public static void main(String[] args) {
        List<Pair<Integer, Integer>> pairs = new ArrayList<>();
        pairs.add( new Pair<>(4,9));
        pairs.add( new Pair<>(9,5));
        pairs.add( new Pair<>(5,1));
        pairs.add( new Pair<>(11,4));
        pairs.add(new Pair<>(9,11));

        System.out.println("Pairs: " + pairs);

        List<Pair<Integer, Integer>> possibleStarts = findStartingPair(pairs);
        System.out.println("Possible Starting Pairs: " + possibleStarts);

        List<Pair<Integer, Integer>> path = new ArrayList<>();
        boolean result = organise(path, pairs, possibleStarts.get(1));
        System.out.println(result);
        System.out.println(path);
        System.out.println("Finished!");
    }

    // find the starting pair. That is: the pair where the first number
    // doesn't have a matching second number in another pair.

    // find possible starting points.
    // a starting point can be identified by:
    // 1) A pair with a start point but no other pair has a matching end point
    // 2) A value appears more often as a start point than an end point
    // 3) A value appears the same numbers of times as start and end (circular path)
    private static List<Pair<Integer, Integer>> findStartingPair(List<Pair<Integer, Integer>> pairs) {

        Map<Integer, Integer> startPoints = new HashMap<>();
        Map<Integer, Integer> endPoints = new HashMap<>();
        for (Pair<Integer, Integer> pair : pairs) {
            Integer startCount = startPoints.getOrDefault(pair.first, 0);
            startPoints.put(pair.first, startCount + 1);

            Integer endCount = endPoints.getOrDefault(pair.second, 0);
            endPoints.put(pair.second, endCount + 1);
        }

        // can we find a pair where the value appears more as start than end
        List<Pair<Integer, Integer>> possiblePairs = new ArrayList<>();
        for (Pair<Integer, Integer> pair : pairs) {
            if(startPoints.get(pair.first) > endPoints.get(pair.second)) {
                possiblePairs.add(pair);
            }
        }

        //throw new RuntimeException("No starting pair found!");
        return possiblePairs;
    }


    private static boolean organise(
            List<Pair<Integer, Integer>> path,
            List<Pair<Integer, Integer>> remainingPairs,
            Pair<Integer, Integer> start) {

        if (remainingPairs.size() == 0) {
            return true;
        }

        path.add(start);

        // remove this pair from list
        List<Pair<Integer, Integer>> updatedPairs = new ArrayList<>(remainingPairs);
        updatedPairs.remove(start);
        System.out.println(updatedPairs);

        Integer nextPairStart = start.second;

        // creates a lookup to find pairs by first number
        boolean successfulPath = false;
        //Map<Integer, List<Pair<Integer, Integer>>> pairLookup = new HashMap<>();
        for (Pair<Integer, Integer> pair : updatedPairs) {
            if (pair.first == nextPairStart) {
                //List<Pair<Integer, Integer>> newPath = new ArrayList<>(path);
                boolean next = organise(path, updatedPairs, pair);
                System.out.println(path);
                if (next) {
                    successfulPath = true;
                }
            }
        }

        return successfulPath;
    }

    public static class Pair<S, T> {

        public S first;
        public T second;

        public Pair(S first, T second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public String toString() {
            return first + "," + second;
        }
    }
}
