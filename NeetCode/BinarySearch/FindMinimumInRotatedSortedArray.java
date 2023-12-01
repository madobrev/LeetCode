package BinarySearch;

public class FindMinimumInRotatedSortedArray {

    public int findMin(int[] nums) {

        if (nums.length == 1) {
            return nums[0];
        }

        int left = 0;
        int right = nums.length - 1;


        while (left <= right) {

            if (right - left == 1) {
                return Math.min(nums[left], nums[right]);
            } else if (right == left) {
                return nums[left];
            }

            int middle = left + (right - left) / 2;

            if (nums[middle] > nums[middle + 1]) {
                return nums[middle + 1];
            } else if (nums[middle] > nums[right]) {
                left = middle + 1;
            } else if (nums[middle] > nums[left]) {
                right = middle - 1;
            } else if (nums[middle] < nums[middle + 1] && nums[middle] < nums[middle - 1]) {
                return nums[middle];
            } else if (nums[middle] < nums[right] && nums[middle] < nums[left]) {
                right = middle - 1;
            }
        }

        return left;

    }

    public static void main(String[] args) {

    }
}
