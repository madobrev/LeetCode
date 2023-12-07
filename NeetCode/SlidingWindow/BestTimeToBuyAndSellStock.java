package SlidingWindow;

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int left = 0;
        int right = 0;

        int maxProfit = 0;
        int highestIndex = 0;

        while (right < prices.length) {
            if (prices[right] < prices[left]) {
                maxProfit = Math.max(prices[highestIndex] - prices[left], maxProfit);
                left = right;
                highestIndex = left;
            } else {
                highestIndex = prices[right] > prices[highestIndex] ? right : highestIndex;

            }
            right++;
        }
        return Math.max(prices[highestIndex] - prices[left], maxProfit);
    }

}
