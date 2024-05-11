import java.util.ArrayList;

public class StockAnalyzer {
    
    // Calculate the average stock price
    public static double calculateAveragePrice(float[] prices) {
        double sum = 0;
        for (float price : prices) {
            sum += price;
        }
        return sum / prices.length;
    }
    
    // Find the maximum stock price
    public static float findMaximumPrice(float[] prices) {
        float maxPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > maxPrice) {
                maxPrice = prices[i];
            }
        }
        return maxPrice;
    }
    
    // Determine the occurrence count of a specific price
    public static int countOccurrences(float[] prices, float targetPrice) {
        int count = 0;
        for (float price : prices) {
            if (price == targetPrice) {
                count++;
            }
        }
        return count;
    }
    
    // Compute the cumulative sum of stock prices
    public static ArrayList<Float> computeCumulativeSum(ArrayList<Float> prices) {
        ArrayList<Float> cumulativeSum = new ArrayList<>();
        float sum = 0;
        for (Float price : prices) {
            sum += price;
            cumulativeSum.add(sum);
        }
        return cumulativeSum;
    }
    
    public static void main(String[] args) {
        // Sample array of stock prices
        float[] pricesArray = {10.5f, 11.2f, 12.8f, 10.5f, 13.4f, 11.7f, 10.5f, 14.2f, 12.3f, 11.5f};
        
        // Sample ArrayList of stock prices
        ArrayList<Float> pricesList = new ArrayList<>();
        pricesList.add(10.5f);
        pricesList.add(11.2f);
        pricesList.add(12.8f);
        pricesList.add(10.5f);
        pricesList.add(13.4f);
        pricesList.add(11.7f);
        pricesList.add(10.5f);
        pricesList.add(14.2f);
        pricesList.add(12.3f);
        pricesList.add(11.5f);
        
        // Calculate and display the average stock price
        double averagePriceArray = calculateAveragePrice(pricesArray);
        System.out.println("Average Price (Array): " + averagePriceArray);
        
        // Find and display the maximum stock price
        float maxPriceArray = findMaximumPrice(pricesArray);
        System.out.println("Maximum Price (Array): " + maxPriceArray);
        
        // Determine and display the occurrence count of a specific price
        float targetPrice = 10.5f;
        int occurrences = countOccurrences(pricesArray, targetPrice);
        System.out.println("Occurrences of " + targetPrice + ": " + occurrences);
        
        // Compute and display the cumulative sum of stock prices
        ArrayList<Float> cumulativeSumList = computeCumulativeSum(pricesList);
        System.out.println("Cumulative Sum (ArrayList): " + cumulativeSumList);
    }
}

