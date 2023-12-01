package DailyChallenges.November2023;
//https://leetcode.com/problems/arithmetic-subarrays/description/?envType=daily-question&envId=2023-11-23
// SOLVED

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArithmeticSubarrays {

    public static List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {

        List<Boolean> result = new ArrayList<>();
        boolean isSubarayGood = true;
        for (int i = 0; i < l.length; i++) {

            int[] tempSubarray = new int[r[i] - l[i] + 1];
            tempSubarray = Arrays.copyOfRange(nums, l[i], r[i] + 1);
            Arrays.sort(tempSubarray);

            int initialDifference = tempSubarray[1] - tempSubarray[0];
            for (int j = 1; j < tempSubarray.length - 1; j++) {
                if (tempSubarray[j + 1] - tempSubarray[j] != initialDifference) {
                    isSubarayGood = false;
                    break;
                }
            }
            result.add(isSubarayGood);
            isSubarayGood = true;
        }

        return result;
    }

    public static void main(String[] args) {

        int[] nums = {4, 6, 5, 9, 3, 7};
        int[] l = {0, 0, 2};
        int[] r = {2, 3, 5};

        System.out.println(checkArithmeticSubarrays(nums, l, r));
    }
}
