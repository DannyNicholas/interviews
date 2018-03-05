package interviews.powerSet;

import java.util.HashSet;
import java.util.Set;

public class PowerSet {

    private static Set<String> powerSet(String s) {

        if (s.length() == 0) {
            Set<String> empty = new HashSet<>();
            empty.add("");
            return empty;
        }

        String head = s.substring(0, 1);
        String tail = s.substring(1);

        Set<String> set = powerSet(tail);

        Set<String> tailSet = new HashSet<>();
        for (String aTail : set) {
            tailSet.add(head + aTail);
        }
        set.addAll(tailSet);
        // equivalent stream version below
        //set.addAll(powerSet(tail).stream().map(x -> head + x).collect(Collectors.toList()));

        return set;
    }

    public static void main(String[] args) {
        Set<String> permutations = powerSet("hello");
        permutations.remove("");
        System.out.println(permutations);
    }
}
