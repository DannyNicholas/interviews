package interviews.brackets;

import java.util.Stack;

/**
 * Confirm brackets are correctly structured
 */
public class Brackets {

    public static void main(String[] args) {

        String incorrect = "{(})";
        String incomplete = "({}";
        String correct = "({()})";

        brackets(incorrect);
        System.out.println("--------");
        brackets(incomplete);
        System.out.println("--------");
        brackets(correct);



    }

    public static void brackets(String text) {

        boolean formedCorrectly = true;

        Stack<Character> stack = new Stack<>();
        for (char aChar : text.toCharArray()) {

            switch(aChar) {
                case '{' :
                case '(' :
                    stack.push(aChar);
                    break;
                case '}' :
                case ')' :
                    char bracket= stack.pop();
                    if((aChar == '}' && bracket != '{') || (aChar == ')' && bracket != '(')) {
                        formedCorrectly = false;
                        System.out.println("Expected opening for " + aChar + " but saw " + bracket);
                    }
            }
        }

        if (!stack.empty()) {
            formedCorrectly = false;
            System.out.println("Unprocessed brackets still on stack");
        }

        if (formedCorrectly) {
            System.out.println("Success!");
        }


    }

}
