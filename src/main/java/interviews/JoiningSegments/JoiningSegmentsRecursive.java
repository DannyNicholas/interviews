package interviews.JoiningSegments;

import java.util.*;

/**
 * Given a list of pairs representing path segments, return the list of segments in an order that represents
 * one continuous path. e.g. (11, 4) -> (4, 9) -> (9, 5) -> (5, 1).
 *
 * Assume if you see a pair in one direction, you won't see it in the other. e.g. if you have (2, 1), you won't have
 * (1, 2). If you can't form a continuous path, throw an exception.
 */
public class JoiningSegmentsRecursive {

    public static void main(String[] args) {
        List<Pair<Integer, Integer>> pairs = new ArrayList<>();
        pairs.add( new Pair<>(4,9));
        pairs.add( new Pair<>(9,5));
        pairs.add( new Pair<>(5,1));
        pairs.add( new Pair<>(11,4));
        pairs.add( new Pair<>(9,11));

        // optional pair that will throw an exception if added
        //pairs.add( new Pair<>(7,6));

        System.out.println("Pairs: " + pairs);
        List<Pair<Integer, Integer>> path = findPath(pairs);
        System.out.println("Successful path: " + path);
    }

    /**
     * Return a list of possible path starting pairs. This can optimise the
     * algorithm by reducing how many pairs are chosen to start path.
     *
     * A possible starting point can be identified by: A value that appears
     * more often as a start point than an end point
     *
     * @param pairs
     * @return list of possible starting pairs
     */
    private static List<Pair<Integer, Integer>> possibleStartingPairs(List<Pair<Integer, Integer>> pairs) {

        Map<Integer, Integer> startPoints = new HashMap<>();
        Map<Integer, Integer> endPoints = new HashMap<>();
        for (Pair<Integer, Integer> pair : pairs) {
            Integer startCount = startPoints.getOrDefault(pair.start, 0);
            startPoints.put(pair.start, startCount + 1);

            Integer endCount = endPoints.getOrDefault(pair.end, 0);
            endPoints.put(pair.end, endCount + 1);
        }

        // can we find a pair where the value appears more as start than end
        List<Pair<Integer, Integer>> possibleStartingPairs = new ArrayList<>();
        for (Pair<Integer, Integer> pair : pairs) {
            if(startPoints.get(pair.start) > endPoints.get(pair.end)) {
                possibleStartingPairs.add(pair);
            }
        }

       if (possibleStartingPairs.size() > 0) {
           System.out.println("Possible Starting Pairs: " + possibleStartingPairs);
           return possibleStartingPairs;
       }

       return new ArrayList<>(pairs);
    }

    /**
     * Find a continuous path from supplied list of pairs.
     * Throw an exception if no continuous path is possible.
     *
     * @param pairs
     * @return
     */
    public static List<Pair<Integer, Integer>> findPath(List<Pair<Integer, Integer>> pairs) {

        // get list of possible pairs to start path with
        List<Pair<Integer, Integer>> possibleStartingPairs = possibleStartingPairs(pairs);

        List<Pair<Integer, Integer>> path = new ArrayList<>();
        for (Pair<Integer, Integer> pair : possibleStartingPairs) {
            if (findPath(path, removePair(pairs, pair), pair)) {
                return path;
            }
        }
        throw new RuntimeException("No path can be found");
    }


    /**
     * Find a path of continuous pairs from the supplied pair using the list of remaining pairs.
     *
     * @param path - path up to current point
     * @param remainingPairs - remaining pairs not yet used in path
     * @param lastPair - last pair in path
     * @return
     */
    private static boolean findPath(
            List<Pair<Integer, Integer>> path,
            List<Pair<Integer, Integer>> remainingPairs,
            Pair<Integer, Integer> lastPair) {

        // if no more pairs left, we have successfully reached the end of a complete path.
        if (remainingPairs.size() == 0) {
            path.add(0, lastPair);
            return true;
        }

        // find paths from any remaining pairs that start with the wanted value
        for (Pair<Integer, Integer> pair : remainingPairs) {
            if (pair.start == lastPair.end) {
                // check if a path can be made from this pair
                if (findPath(path, removePair(remainingPairs, pair), pair)) {
                    path.add(0, lastPair);
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * Return a new list without the wanted pair.
     *
     * @param pairs - original list
     * @param removalPair - pair to remove
     * @return
     */
    private static List<Pair<Integer, Integer>> removePair(
            List<Pair<Integer, Integer>> pairs,
            Pair<Integer, Integer> removalPair) {
        List<Pair<Integer, Integer>> pairsWithoutRemoval = new ArrayList<>(pairs);
        pairsWithoutRemoval.remove(removalPair);
        return pairsWithoutRemoval;
    }

    public static class Pair<S, T> {

        public S start;
        public T end;

        public Pair(S start, T end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return start + "," + end;
        }
    }
}
