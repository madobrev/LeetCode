package ArraysAndHashing;

import java.util.HashSet;
import java.util.PriorityQueue;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int highestStreak = 0;
        int currentStreak = 1;

        PriorityQueue<Integer> prioQueueSortedInput = new PriorityQueue<>();
        HashSet<Integer> seenNumbers = new HashSet<>();
        for (int num : nums) {
            prioQueueSortedInput.add(num);
        }

        int previousNumber = prioQueueSortedInput.poll();
        seenNumbers.add(previousNumber);
        while (!prioQueueSortedInput.isEmpty()) {

            int currentNumber = prioQueueSortedInput.poll();
            if (seenNumbers.contains(currentNumber)) {
                continue;
            }

            if (previousNumber + 1 == currentNumber) {
                currentStreak++;
            } else {
                if (currentStreak > highestStreak) {
                    highestStreak = currentStreak;
                }
                currentStreak = 1;
            }
            seenNumbers.add(currentNumber);
            previousNumber = currentNumber;
        }

        return Math.max(highestStreak, currentStreak);

    }
}
