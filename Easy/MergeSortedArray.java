package Easy;

import java.util.Arrays;
import java.util.PriorityQueue;

//https://leetcode.com/problems/merge-sorted-array/description/

public class MergeSortedArray {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        PriorityQueue<Integer> numbersToBeInserted = new PriorityQueue<>();

        for (int i = 0; i < nums1.length; i++) {

            if ((m < n && i > m - 1) || (m > n && i > n - 1) || (m == n && i > n - 1)) {
                if ((m < n && i < nums2.length) || (m > n && i < m)) {
                    numbersToBeInserted.add((m < n) ? nums2[i] : nums1[i]);
                }

                nums1[i] = numbersToBeInserted.poll();
                continue;
            } else if (i == nums1.length - Math.abs(m - n) - 1) {
                break;
            }

            if (numbersToBeInserted.isEmpty()) {
                if (nums1[i] < nums2[i]) {
                    numbersToBeInserted.add(nums2[i]);

                } else {
                    numbersToBeInserted.add(nums1[i]);
                    nums1[i] = nums2[i];
                }
            } else {
                int lowestToBeAdded = Math.min(numbersToBeInserted.peek(), Math.min(nums1[i], nums2[i]));
                if (numbersToBeInserted.peek() == lowestToBeAdded) {
                    numbersToBeInserted.add(nums1[i]);
                    numbersToBeInserted.add(nums2[i]);
                    nums1[i] = lowestToBeAdded;
                    numbersToBeInserted.poll();
                } else if (nums1[i] == lowestToBeAdded) {
                    numbersToBeInserted.add(nums2[i]);

                } else {
                    numbersToBeInserted.add(nums1[i]);
                    nums1[i] = nums2[i];
                }
            }
        }

        while (!numbersToBeInserted.isEmpty()) {
            nums1[m] = numbersToBeInserted.poll();
            m++;
        }

        System.out.println("Array state is: " + Arrays.toString(nums1));

    }

    public static void main(String[] args) {

    }
}
