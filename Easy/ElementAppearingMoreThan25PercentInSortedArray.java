package Easy;

//https://leetcode.com/problems/element-appearing-more-than-25-in-sorted-array/description/

//Solved

import java.util.HashMap;

public class ElementAppearingMoreThan25PercentInSortedArray { // Even faster is to check if the current element is the
                                                              // same as the array[currentIndex+arr.length/4]

   public static int findSpecialInteger(int[] arr) {
      HashMap<Integer, Integer> numberToFrequency = new HashMap<>();
      int result = 0;

      for (int num : arr) {
         numberToFrequency.put(num, numberToFrequency.getOrDefault(num, 0) + 1);

         if (numberToFrequency.get(num) > arr.length / 4) {
            result = num;
            break;
         }
      }

      return result;
   }

   public static void main(String[] args) {
      int[] arr = { 1, 2, 2, 6, 6, 6, 6, 7, 10 };
      System.out.println(findSpecialInteger(arr));
   }

}
