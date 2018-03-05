package interviews.powerSet;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PowerSet {

    private static List<String> powerSet(String s) {

        if (s.length() == 0) {
            List<String> empty = new ArrayList<>();
            empty.add("");
            return empty;
        }

        String head = s.substring(0, 1);
        String tail = s.substring(1);

        List<String> set = powerSet(tail);

        List<String> tailSet = new ArrayList<>();
        for (String aTail : set) {
            tailSet.add(head + aTail);
        }
        set.addAll(tailSet);
        // equivalent stream version below
        //set.addAll(powerSet(tail).stream().map(x -> head + x).collect(Collectors.toList()));

        return set;
    }

    public static void main(String[] args) {
        List<String> permutations = powerSet("hello");
        permutations.remove("");
        System.out.println(permutations);
    }
}
