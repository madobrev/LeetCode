package DailyChallenges.November2023;

//https://leetcode.com/problems/sum-of-absolute-differences-in-a-sorted-array/description/?envType=daily-question&envId=2023-11-25
//SOLVED


public class SumOfAbsoluteDifferencesInASortedArray {

    public static int[] getSumAbsoluteDifferences(int[] nums) {

        int[] result = new int[nums.length];
        int totalSum = 0;
        int sumUntilNow = 0;

        for (int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            int absSumBeforehand = i * nums[i] - sumUntilNow;
            int currentNumber = nums[i];

            result[i] = absSumBeforehand + Math.abs((nums.length - i) * currentNumber - totalSum);

            sumUntilNow += nums[i];
            totalSum -= nums[i];
        }

        return result;
    }

    public static void main(String[] args) {
        
    }
}
