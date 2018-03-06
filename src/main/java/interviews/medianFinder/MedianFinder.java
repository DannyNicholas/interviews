package interviews.medianFinder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Find the median value from two sorted arrays.
 */
public class MedianFinder {

    public static void main(String[] args) {

        // 2 lists - median should be 5
        int[] listOne = new int[] { 1, 3, 5, 7, 8, 9 };
        int[] listTwo = new int[] { 2, 4, 6 };

        // 2 lists - median should be 6 (4+8)/2
        int[] listThree = new int[] { 1, 4, 9 };
        int[] listFour = new int[] { 2, 8, 10 };

        MedianFinder sol = new MedianFinder();
        int oddMedianBrute = sol.bruteForceMedian(listOne, listTwo);
        System.out.println("Odd Median: " + oddMedianBrute);

        int evenMedianBrute = sol.bruteForceMedian(listThree, listFour);
        System.out.println("Even Median: " + evenMedianBrute);


        int oddMedian = sol.efficientMedian(listOne, listTwo);
        System.out.println("Odd Median: " + oddMedian);

        int evenMedian = sol.efficientMedian(listThree, listFour);
        System.out.println("Even Median: " + evenMedian);

    }

    public int bruteForceMedian(int[] listOne, int[] listTwo) {

        // brute force
        List<Integer> combined = toList(listOne);
        combined.addAll(toList(listTwo));
        Collections.sort(combined);

        System.out.println(combined);

        if (combined.size() % 2 != 0) {
            return combined.get(combined.size()/2);
        }
        else {
            int half = combined.size() / 2;
            return (combined.get(half) + combined.get(half - 1))/2;
        }
    }

    // get value at supplied index
    private int getIndex(int[] start, int[] end, int index) {
        int totalLength = start.length + end.length;

        if (index > start.length-1) {
            return end[index-start.length];
        }
        else {
            return start[index];
        }
    }

    // calculate the median from two ordered lists
    private int calculateMedian(int[] start, int[] end) {

        int totalLength = start.length + end.length;

        // even list length
        if (totalLength % 2 == 0) {
            int medianOneIndex = totalLength / 2;
            int medianTwoIndex = medianOneIndex - 1;
            int valueOne = getIndex(start, end, medianOneIndex);
            int valueTwo = getIndex(start, end, medianTwoIndex);

            return (valueOne + valueTwo) / 2;
        }

        // odd list length
        int medianIndex = totalLength / 2;
        return getIndex(start, end, medianIndex);

    }

    public int efficientMedian(int[] listOne, int[] listTwo) {

        int indexOne = 0;
        int indexTwo = 0;
        int lengthOne = listOne.length;
        int lengthTwo = listTwo.length;

        // check if all of list two contains numbers higher than list one
        if (listTwo[0] >= listOne[lengthOne-1]) {
            return calculateMedian(listOne, listTwo);
        }

        // check if all of list one contains numbers higher than list two
        if (listOne[0] >= listTwo[lengthTwo-1]) {
            return calculateMedian(listTwo, listOne);
        }

        int totalLength = lengthOne + lengthTwo;
        int medianIndex = totalLength / 2;
        int count = 0;
        int currentValue = -1;
        int previousValue = -1;

        while (count <= medianIndex) {

            if (indexTwo == lengthTwo || (indexOne < lengthOne && listOne[indexOne] <= listTwo[indexTwo])) {
                System.out.println(listOne[indexOne]);
                previousValue = currentValue;
                currentValue = listOne[indexOne];
                indexOne++;
            }
            else {
                System.out.println(listTwo[indexTwo]);
                previousValue = currentValue;
                currentValue = listTwo[indexTwo];
                indexTwo++;
            }
            count++;

        }

        if (totalLength % 2 == 0) {
            return (currentValue + previousValue) / 2;
        }

        return currentValue;

    }

    private List<Integer> toList(int[] numbers) {
        List<Integer> list = new ArrayList<>(numbers.length);
        for(int i : numbers) {
            list.add(i);
        }
        return list;
    }


}
