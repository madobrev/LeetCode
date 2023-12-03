package ArraysAndHashing;

import java.util.Arrays;

public class ContainingDuplicate {
    public boolean containsDuplicate(int[] nums) { // can also use Set

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }
}
