package TwoPointer;

import java.util.Arrays;

public class TwoSumIIInputArrayIsSorted {
    public static int[] twoSum(int[] numbers, int target) {

        for (int i = 0, j = numbers.length - 1; i < j; ) {
            int neededAmount = target - numbers[i];

            if (neededAmount < numbers[j]) {
                j--;
                continue;
            } else if (neededAmount > numbers[j]) {
                i++;
                continue;
            } else {
                return new int[]{i + 1, j + 1};
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] numbers = {2, 7, 11, 15};
        int target = 9;

        System.out.println(Arrays.toString(twoSum(numbers, target)));
    }

}
