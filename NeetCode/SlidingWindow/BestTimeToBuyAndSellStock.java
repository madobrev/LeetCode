package SlidingWindow;

//TODO redo the problem
public class BestTimeToBuyAndSellStock {
    public static int maxProfit(int[] prices) {

        int maxProfit = 0;
        if (prices.length <= 1) {
            return maxProfit;
        }

        int highestValue = prices[0];
        int lowestValue = prices[0];
        boolean isDescendingArray = true;
        int irrelevantEndEntriesCounter = 0;
        int irrelevantBeginEntriesCounter = 0;

        for (int end = prices.length - 1; end > 0 && prices[end] < prices[end - 1]; end--) {
            irrelevantEndEntriesCounter++;
        }

        if (irrelevantEndEntriesCounter + 1 == prices.length) {
            return 0;
        }

        for (int i = 1; i < prices.length - irrelevantEndEntriesCounter; i++) {
            if (isDescendingArray) {
                if (prices[i] < prices[i - 1]) {
                    irrelevantBeginEntriesCounter++;
                } else {
                    break;
                }
            }
        }

        int indexOfHighest = irrelevantBeginEntriesCounter;
        int indexOfLowest = irrelevantBeginEntriesCounter;
        for (int i = irrelevantBeginEntriesCounter; i < prices.length - irrelevantEndEntriesCounter; i++) {
            int currentValue = prices[i];

            if (currentValue > prices[indexOfHighest]) {
                indexOfHighest = i;
            }

            if (currentValue < prices[indexOfLowest]) {
                indexOfLowest = i;
            }

        }

        if (indexOfHighest > indexOfLowest) {
            return prices[indexOfHighest] - prices[indexOfLowest];
        }

        highestValue = prices[indexOfHighest];
        lowestValue = prices[indexOfLowest];

        int highestDifferenceCalculatedWithHighest = 0;
        int highestDifferenceCalculatedWithLowest = 0;

        for (int i = indexOfHighest; i >= 0 + irrelevantBeginEntriesCounter; i--) {
            if (highestValue - prices[i] > highestDifferenceCalculatedWithHighest) {
                highestDifferenceCalculatedWithHighest = highestValue - prices[i];
            }
        }

        for (int i = indexOfLowest; i < prices.length - irrelevantEndEntriesCounter; i++) {
            if (prices[i] - lowestValue > highestDifferenceCalculatedWithLowest) {
                highestDifferenceCalculatedWithLowest = prices[i] - lowestValue;
            }
        }

        return Math.max(highestDifferenceCalculatedWithLowest, highestDifferenceCalculatedWithHighest);

    }

    public static void main(String[] args) {


    }

}
