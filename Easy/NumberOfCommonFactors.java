package Easy;

//https://leetcode.com/problems/number-of-common-factors/description/
//SOLVED
public class NumberOfCommonFactors {
   public static int commonFactors(int a, int b) {

      int smallerNumber = Math.min(a, b);
      int biggerNumber = Math.max(a, b);
      int result = biggerNumber % smallerNumber == 0 ? 1 : 0;
      // bruteForce
      for (int i = 1; i < smallerNumber; i++) {
         if (smallerNumber % i == 0 && biggerNumber % i == 0) {
            result++;
         }
      }
      return result;
   }

   public static void main(String[] args) {
      int a = 1;
      int b = 5;
      System.out.println(commonFactors(a, b));
   }
}
