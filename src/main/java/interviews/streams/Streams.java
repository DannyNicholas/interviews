package interviews.streams;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Danny on 05/03/2018.
 */
public class Streams {

    public static void main(String[] args) {

        integerStream();
        intStream();
        stringStream();

    }

    public static void integerStream() {

        System.out.println("-- Integers --");

        Integer[] numberArray = new Integer[] {
                2, 6, 8, 12, 14, 17, 6
        };

        // array to list
        List<Integer> numberList = Arrays.stream(numberArray).collect(Collectors.toList());
        System.out.println(numberList);

        // array to set
        Set<Integer> numberSet = Arrays.stream(numberArray).collect(Collectors.toSet());
        System.out.println(numberSet);

        // array to map of Integers vs frequency
        Map<Integer, Long> intNumberMap = Arrays.stream(numberArray).collect(Collectors.groupingBy(i -> i, Collectors.counting()));
        System.out.println(intNumberMap);

        // sum the Integer array
        Integer sum = Arrays.stream(numberArray).mapToInt(Integer::intValue).sum();
        System.out.println(sum);

        // max of array
        OptionalInt max = Arrays.stream(numberArray).mapToInt(Integer::intValue).max();
        System.out.println(max.getAsInt());

        // min of array
        OptionalInt min = Arrays.stream(numberArray).mapToInt(Integer::intValue).min();
        System.out.println(min.getAsInt());

        // sum of list
        Integer summedList = numberList.stream().mapToInt(Integer::intValue).sum();
        System.out.println(summedList);
    }

    public static void intStream() {

        System.out.println("-- ints --");

        int[] numberIntArray = new int[] {
                2, 6, 8, 12, 14, 17, 6
        };


        // int array to list
        List<Integer> intNumberList = Arrays.stream(numberIntArray).boxed().collect(Collectors.toList());
        System.out.println(intNumberList);

        // array to set
        Set<Integer> intNumberSet = Arrays.stream(numberIntArray).boxed().collect(Collectors.toSet());
        System.out.println(intNumberSet);

        // array to map of Integers vs frequency
        Map<Integer, Long> intNumberMap = Arrays.stream(numberIntArray).boxed().collect(Collectors.groupingBy(i -> i, Collectors.counting()));
        System.out.println(intNumberMap);

        // sum the int array
        Integer intSum = Arrays.stream(numberIntArray).sum();
        System.out.println(intSum);

        // max of array
        OptionalInt max = Arrays.stream(numberIntArray).max();
        System.out.println(max.getAsInt());

    }

    public static void stringStream() {

        System.out.println("-- strings --");

        String[] stringArray = new String[] { "hello", "dog", "cat", "cat", "dog" };

        // string array to list
        List<String> stringList = Arrays.stream(stringArray).collect(Collectors.toList());
        System.out.println(stringList);

        // array to set
        Set<String> stringSet = Arrays.stream(stringArray).collect(Collectors.toSet());
        System.out.println(stringSet);

        // array to map of strings vs frequency
        Map<String, Long> frequencyMap = Arrays.stream(stringArray).collect(Collectors.groupingBy(s -> s, Collectors.counting()));
        System.out.println(frequencyMap);

        // array to map of word length vs set of words
        Map<Integer, List<String>> wordLengthMap = stringSet.stream().collect(Collectors.groupingBy(String::length));
        System.out.println(wordLengthMap);


    }
}
