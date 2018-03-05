package interviews.comparators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Danny on 05/03/2018.
 */
public class Comparators {

    /**
     * Player class with natural ordering by age
     */
    public static class Player implements Comparable<Player> {

        private String name;
        private Integer age;

        public Player(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public Integer getAge() {
            return age;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "Player{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }

        // negative results mean this player comes before other player in natural ordering
        @Override
        public int compareTo(Player o) {
            return this.age - o.age;
        }
    }

    /**
     * specific comparator that sorts by name
     */
    public static class PlayerNameComparator implements Comparator<Player> {

        @Override
        public int compare(Player o1, Player o2) {
            return o1.name.compareTo(o2.name);
        }
    }



    public static void main (String[] args) {
        Player player1 = new Player("Dan", 23);
        Player player2 = new Player("George", 18);
        Player player3 = new Player("Henry", 22);
        List<Player> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);
        players.add(player3);

        System.out.println("-- Natural Ordering by Age --");
        System.out.println(players);
        Collections.sort(players);
        System.out.println(players);

        System.out.println("-- Comparator Ordering by Name --");
        System.out.println(players);
        Collections.sort(players, new PlayerNameComparator());
        System.out.println(players);

        System.out.println("-- Natural Ordering with Streams --");
        List<Player> playerList = players.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
        System.out.println(playerList);

        System.out.println("-- Comparator Ordering with Streams --");
        List<Player> playerCompList = players.stream().sorted(new PlayerNameComparator()).collect(Collectors.toList());
        System.out.println(playerCompList);

        System.out.println("-- Java 8 Comparator --");
        Comparator<Player> byName = (p1, p2) -> p1.name.compareTo(p2.name);
        Collections.sort(players, byName);
        System.out.println(players);

        System.out.println("-- Alternative Java 8 Comparator --");
        Comparator<Player> byAge = Comparator.comparing(Player::getAge);
        Collections.sort(players, byAge);
        System.out.println(players);
    }
}
