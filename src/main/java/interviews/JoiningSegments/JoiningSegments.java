package interviews.JoiningSegments;

import java.util.*;

public class JoiningSegments {


    public static void main(String[] args) {
        List<Pair<Integer, Integer>> pairs = new ArrayList<>();
        pairs.add( new Pair<>(4,9));
        pairs.add( new Pair<>(9,5));
        pairs.add( new Pair<>(5,1));
        pairs.add( new Pair<>(11,4));

        System.out.println(pairs);
        List<Pair<Integer, Integer>> organisedPairs = organise(pairs);
        System.out.println(organisedPairs);
    }

    // find the starting pair. That is: the pair where the first number
    // doesn't have a matching second number in another pair.
    private static Pair<Integer, Integer> findStartingPair(List<Pair<Integer, Integer>> pairs) {

        Set<Integer> endPoints = new HashSet<>();
        for (Pair<Integer, Integer> pair : pairs) {
            endPoints.add(pair.second);
        }

        // can we find the pair where the start number
        // has no matching end number
        for (Pair<Integer, Integer> pair : pairs) {
            if(!endPoints.contains(pair.first)) {
                return pair;
            }
        }

        throw new RuntimeException("No starting pair found!");
    }


    private static List<Pair<Integer, Integer>> organise(List<Pair<Integer, Integer>> pairs) {

        Pair<Integer, Integer> next = findStartingPair(pairs);
        int pairsToMatch = 0;

        // creates a lookup to find pairs by first number
        Map<Integer, Pair<Integer, Integer>> pairLookup = new HashMap<>();
        for (Pair<Integer, Integer> pair : pairs) {
            pairLookup.put(pair.first, pair);
            pairsToMatch++;
        }

        List<Pair<Integer, Integer>> path = new ArrayList<>();
        boolean finished = false;

        while(!finished) {

            path.add(next);
            pairsToMatch--;

            int nextStart = next.second;
            if (pairLookup.containsKey(nextStart)) {
                next = pairLookup.get(nextStart);
            } else {
                finished = true;
            }
        }

        if (pairsToMatch != 0) {
            throw new RuntimeException("Not joined all pairs.");
        }

        return path;
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
