package ArraysAndHashing;

public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int totalSumLeft = 1;
        int totalSumRight = 1;

        int[] sumLeftToRight = new int[nums.length];
        int[] sumRightToLeft = new int[nums.length];

        int[] result = new int[nums.length];

        for (int i = 0, j = nums.length - 1; i < nums.length && j > -1; i++, j--) {
            totalSumLeft *= nums[i];
            sumLeftToRight[i] = totalSumLeft;
            totalSumRight *= nums[j];
            sumRightToLeft[j] = totalSumRight;
        }

        for (int i = 0; i < nums.length; i++) {

            if (i == 0) {
                result[i] = sumRightToLeft[1];
                continue;
            }

            if (i == nums.length - 1) {
                result[i] = sumLeftToRight[nums.length - 2];
                continue;
            }

            result[i] = sumLeftToRight[i - 1] * sumRightToLeft[i + 1];

        }
        return result;
    }
}
