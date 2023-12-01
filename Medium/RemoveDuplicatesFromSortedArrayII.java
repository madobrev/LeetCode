package Medium;

//https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/?envType=study-plan-v2&envId=top-interview-150
//SOLVED

public class RemoveDuplicatesFromSortedArrayII {

   public static int removeDuplicates(int[] nums) {

      int amountOfRemovedNumbers = 0;

      boolean isThereRepetition = false;
      boolean isIndexSet = false;

      int nextFreeIndex = -1;

      for (int i = 1; i < nums.length; i++) {

         if (i == nums.length - 1 && !isThereRepetition && nums[i - 1] == nums[i] && isIndexSet) {
            nums[nextFreeIndex] = nums[i];
            break;
         }

         if (nums[i - 1] == nums[i]) {
            if (!isThereRepetition) {
               isThereRepetition = true;
               if (nextFreeIndex > -1) {
                  nums[nextFreeIndex] = nums[i];
                  nextFreeIndex++;
               }
            } else {
               if (isIndexSet) {
                  amountOfRemovedNumbers++;
               } else {
                  nextFreeIndex = i;
                  isIndexSet = true;
                  amountOfRemovedNumbers++;
               }
            }
         } else {
            isThereRepetition = false;
            if (nextFreeIndex > -1) {
               nums[nextFreeIndex++] = nums[i];
            }
         }
      }

      return nums.length - amountOfRemovedNumbers;
   }

   public static void main(String[] args) {
      int[] a = { 1, 1, 1, 2, 2, 3 };

      removeDuplicates(a);
   }
}
