package Medium;
//https://leetcode.com/problems/rotate-array/description/?envType=study-plan-v2&envId=top-interview-150
//SOLVED

import java.util.Arrays;

public class RotateArray {
    public static void rotate(int[] nums, int k) {

        if (nums.length == 1 || k == 0 || k == nums.length) {
            return;
        }
        int offset = k % nums.length;
        int counter = 0;

        int currentIndex = 0;
        int previousIndex = currentIndex - offset > 0 ? currentIndex - offset : nums.length + currentIndex - offset;
        int tempHolder = nums[previousIndex];

        if (nums.length % 2 != 0 && nums.length % previousIndex != 0) {
            while (counter < nums.length) {
                int toBeInserted = tempHolder;
                tempHolder = nums[currentIndex];
                nums[currentIndex] = toBeInserted;
                currentIndex = (currentIndex + offset) % nums.length;
                counter++;
            }
        } else {
            int beginIndex = 0;
            while (counter < nums.length) {
                boolean isThereLoop = false;
                currentIndex = beginIndex;
                previousIndex = currentIndex - offset > 0 ? currentIndex - offset : nums.length + currentIndex - offset;
                tempHolder = nums[previousIndex];

                while (!isThereLoop) {
                    int toBeInserted = tempHolder;
                    tempHolder = nums[currentIndex];
                    nums[currentIndex] = toBeInserted;
                    currentIndex = (currentIndex + offset) % nums.length;
                    counter++;

                    if (currentIndex == beginIndex) {
                        isThereLoop = true;
                    }
                }
                beginIndex++;
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int[] nums2 = {-1, -100, 3, 99};

        int[] nums3 = {-1, -100, 3};
        int[] nums4 = {1, 2};
        int[] nums5 = {1, 2, 3, 4, 5, 6};
        int[] nums6 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45};


        System.out.println(nums6.length);
        rotate(nums6, 36);
    }
}
