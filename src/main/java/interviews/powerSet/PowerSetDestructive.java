package interviews.powerSet;

import java.util.HashSet;
import java.util.Set;

public class PowerSetDestructive {

    public static void powerSet(Set<String> set, String word) {

        set.add(word);
        for (int i = 0; i < word.length(); i++) {
            StringBuilder builder = new StringBuilder(word);
            builder.deleteCharAt(i);
            String reduced = builder.toString();
            powerSet(set, reduced);
        }
    }

    public static void main(String[] args) {
        Set<String> permutations = new HashSet<>();
        powerSet(permutations, "hello");
        permutations.remove("");
        System.out.println(permutations);
    }
}
