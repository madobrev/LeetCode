package TwoPointer;

public class ContainerWithMostWater {

   public static int maxArea(int[] height) {

      int maxAreaResult = 0;

      for (int leftPointer = 0, rightPointer = height.length - 1; leftPointer < rightPointer;) {
         int leftHeight = height[leftPointer];
         int rightHeight = height[rightPointer];
         int pointerDifference = rightPointer - leftPointer;

         int currentArea = (leftHeight > rightHeight ? rightHeight * pointerDifference
               : leftHeight * pointerDifference);

         if (currentArea > maxAreaResult) {
            maxAreaResult = currentArea;
         }

         if (height[leftPointer] > height[rightPointer]) {
            rightPointer--;
         } else {
            leftPointer++;
         }
      }

      return maxAreaResult;
   }

   public static void main(String[] args) {

   }

}
