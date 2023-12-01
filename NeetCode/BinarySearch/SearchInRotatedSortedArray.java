package BinarySearch;

public class SearchInRotatedSortedArray {

    public static int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {

            if (left == right) {
                return (nums[left] == target) ? left : -1;
            }

            if (target > nums[right] && target < nums[left]) {
                return -1;
            }

            int middle = left + (right - left) / 2;

            if (nums[middle] == target) {
                return middle;
            }

            if (nums[left] == target || nums[right] == target) {
                return (nums[left] == target) ? left : right;
            }

            if (nums[left] > nums[right]) {
                if (nums[middle] > nums[left]) {

                    if (target < nums[middle]) {
                        if (target > nums[left]) {
                            right = middle - 1;
                        } else {
                            left = middle + 1;
                        }

                    } else {
                        left = middle + 1;
                    }
                } else {
                    if (target < nums[middle]) {
                        right = middle - 1;
                    } else {
                        if (target > nums[left]) {
                            right = middle - 1;
                            continue;

                        }
                        left = middle + 1;
                    }
                }

            } else if (nums[left] < nums[right]) {
                if (nums[middle] > target) {
                    right = middle - 1;
                } else if (nums[middle] < target) {
                    left = middle + 1;
                } else {
                    return middle;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {

    }
}


