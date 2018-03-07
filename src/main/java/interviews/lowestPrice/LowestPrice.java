package interviews.lowestPrice;

import java.util.ArrayList;
import java.util.List;

/**
 * Return the lowest price for a specified time-period from a series of arrays representing sales.
 */
public class LowestPrice {

    private static int[] PRICE_ONE = new int[] { 0, 10, 45};
    private static int[] PRICE_TWO = new int[] { 10, 20, 20};
    private static int[] PRICE_THREE = new int[] { 30, 40, 10};

       public static void main(String[] args) {
        List<Sale> sales = new ArrayList<>();
        sales.add(createSale(PRICE_ONE));
        sales.add(createSale(PRICE_TWO));
        sales.add(createSale(PRICE_THREE));

        Integer minPrice = leastPrice(0, 20, sales);
        System.out.println(minPrice);
    }


    public static Sale createSale(int[] sale) {
        return new Sale(sale[0], sale[1], sale[2]);
    }

    public static Integer leastPrice(int startTime, int endTime, List<Sale> sales) {

        Integer minPrice = null;
        for (Sale aSale : sales) {
            // does sale fall within time window?
            if (aSale.startTime >= startTime && aSale.endTime <= endTime) {
                if (minPrice == null || aSale.price < minPrice) {
                    minPrice = aSale.price;
                }
            }
        }

        return minPrice;
    }

    public static class Sale {

        public int startTime;
        public int endTime;
        public int price;

        public Sale(int startTime, int endTime, int price) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.price = price;
        }
    }

}
