package Easy;

//https://leetcode.com/problems/delete-greatest-value-in-each-row/
// SOLVED

import java.util.Arrays;
import java.util.Stack;

public class DeleteGreatestValueInEachRow {
   public static int deleteGreatestValue(int[][] grid) {

      int result = 0;
      Stack<Integer> stack = new Stack<>();

      for (int[] row : grid) {
         Arrays.sort(row);
      }

      for (int col = 0; col < grid[0].length; col++) {
         for (int row = 0; row < grid.length; row++) {
            int currentNumber = grid[row][col];
            if (stack.isEmpty() || currentNumber > stack.peek()) {
               stack.clear();
               stack.push(currentNumber);
            }

         }
         result += stack.pop();
      }

      return result;

   }

   public static void main(String[] args) {

   }

}
