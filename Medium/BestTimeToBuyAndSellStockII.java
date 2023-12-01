package Medium;
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/solutions/564729/java-simple-code-dp/?envType=study-plan-v2&envId=top-interview-150
//Solved

public class BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices) {

        if (prices.length == 1) { //Only one day so cannot make profit
            return 0;
        }

        int left = 0;
        int right = 1;

        int totalProfit = 0;
        while (right < prices.length) {

            int leftValue = prices[left];
            int rightValue = prices[right];

            if (leftValue >= rightValue) { // If we start the array with a value which is greater than
                // the one in the next day we don't want to buy the expensive one on the first day => just skip it
                left++;
                right++;
            } else {
                if (right + 1 < prices.length) { // is there a value on the next right index
                    int nextValue = prices[right + 1];
                    if (nextValue >= rightValue) {// the next value is higher/equal => we don't need to sell yet
                        right++;
                    } else { // the next value is lower => we sell
                        totalProfit += prices[right] - prices[left];
                        if (right + 2 < prices.length) { // check if we can buy on the next day and be able to sell on the day after the next one
                            left = right + 1;
                            right += 2;
                        } else {
                            break;
                        }
                    }
                } else {//we have found the final value in the array, and we know that it's the highest one so far, so we want to sell
                    totalProfit += rightValue - leftValue;
                    break;
                }
            }
        }

        return totalProfit;
    }

}
