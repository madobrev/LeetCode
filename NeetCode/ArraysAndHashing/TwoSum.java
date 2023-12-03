package ArraysAndHashing;

import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, int[]> numberToIndex = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int key = nums[i];
            int[] foundIndexes = numberToIndex.putIfAbsent(key, new int[]{i});
            if (foundIndexes != null) {
                int[] newIndexes = new int[2];
                newIndexes[0] = foundIndexes[0];
                newIndexes[1] = i;
                numberToIndex.put(nums[i], newIndexes);
            }

            if (key * 2 == target && numberToIndex.get(key).length == 2) {
                return numberToIndex.get(key);
            }

            int soughtNumber = target - key;

            if (soughtNumber != key && numberToIndex.containsKey(soughtNumber)) {
                return new int[]{numberToIndex.get(key)[0], numberToIndex.get(soughtNumber)[0]};
            }
        }

        return null;

    }
}
