package interviews.powerSet;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PowerSetDestructive {

    public static void powerSet(Set<String> set, String word) {

        set.add(word);
        for (int i = 0; i < word.length(); i++) {
            StringBuilder builder = new StringBuilder(word);
            builder.deleteCharAt(i);
            String reduced = builder.toString();
            set.add(reduced);
            powerSet(set, reduced);
        }
    }

    public static void main(String[] args) {
        Set<String> permutations = new HashSet<>();
        powerSet(permutations, "hello");
        System.out.println(permutations);
    }
}
