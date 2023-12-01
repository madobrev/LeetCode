package DailyChallenges.November2023;
// https://leetcode.com/problems/count-nice-pairs-in-an-array/?envType=daily-question&envId=2023-11-21
// SOLVED

import java.util.HashMap;

public class CountNicePairsInArray {

    public static int rev(int x) {
        int result = 0;
        while (x != 0) {
            int digit = x % 10;
            x /= 10;
            result = result * 10 + digit;
        }
        return result;
    }

    public static int countNicePairs(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int nicePairsCount = 0;
        final int MOD = (int) (Math.pow(10, 9) + 7);

        for (int num : nums) {
            int neededSum = num - rev(num);

            if (map.keySet().contains(neededSum)) {
                nicePairsCount = (nicePairsCount + map.get(neededSum)) % MOD;
                map.put(neededSum, map.get(neededSum) + 1);
            } else {
                map.put(neededSum, 1);
            }
        }
        return nicePairsCount % MOD;
    }

    public static void main(String[] args) {

    }
}
