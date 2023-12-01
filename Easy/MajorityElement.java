package Easy;

import java.util.Arrays;

//https://leetcode.com/problems/majority-element/?envType=study-plan-v2&envId=top-interview-150
//SOLVED non linear time

public class MajorityElement {
   public int majorityElement(int[] nums) {

      int half = (int) Math.ceil((double) nums.length / 2.0);
      Arrays.sort(nums); // O(n logn). The solution isn't linear time O(n)
      
      for (int i = 0; i < nums.length; i += half) {
         if (i + half >= nums.length || nums[i] == nums[i + half - 1]) {
            return nums[i];
         }
      }

      return 0;
   }

   public static void main(String[] args) {
      System.out.println((int) Math.ceil((double) (3) / (double) (2)));
   }
}
