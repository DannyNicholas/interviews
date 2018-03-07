package interviews.robot;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Given a string calculate a robot's end co-ordinates
 */
public class Robot {

    private static Pattern p = Pattern.compile("[UDLR]");

    public static void main(String[] args) {

        List<Character> chars = new ArrayList<>();
        Matcher matcher = p.matcher("UDDLR2xUPLLRRUD");
        while (matcher.find()) {
            chars.add(matcher.group(0).charAt(0));
        }
        System.out.println(chars);

        int[] position = new int[2];

        for (Character c : chars) {

            switch(c) {
                case 'U': moveUp(position);
                break;
                case 'D': moveDown(position);
                break;
                case 'L': moveLeft(position);
                break;
                case 'R': moveRight(position);
                break;
                default: System.out.println("Unknown char " +c);
            }
        }

        System.out.println(position[0] + "," + position[1]);


        // this is an alterative method that works out net moves
        // i.e. each move right is cancelled out by a move left
        Map<Character, Integer> moveCount = new HashMap<>();
        for (Character c : chars) {
            int count = moveCount.getOrDefault(c, 0);
            moveCount.put(c, count + 1);
        }
        System.out.println(moveCount);

        int moveRight = moveCount.get('R') - moveCount.get('L');
        int moveUp = moveCount.get('U') - moveCount.get('D');
        position[0] = moveRight;
        position[1] = moveUp;

        System.out.println(position[0] + "," + position[1]);
    }

    private static void moveUp(int[] position) {
        position[1]++;
    }

    private static void moveDown(int[] position) {
        position[1]--;
    }

    private static void moveLeft(int[] position) {
        position[0]--;
    }

    private static void moveRight(int[] position) {
        position[0]++;
    }
}
