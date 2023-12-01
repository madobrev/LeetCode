package Easy;
//https://leetcode.com/problems/consecutive-characters/description/
//SOLVED
import java.util.Arrays;

public class ConsecutiveCharacters {
   public static int maxPower(String s) {

      int highestStreak = 0;
      int currentStreak = 1;
      char[] inputAsArray = s.toCharArray();
      for (int i = 0; i < inputAsArray.length - 1; i++) {
         if (inputAsArray[i] == inputAsArray[i + 1]) {
            currentStreak++;
         } else {
            highestStreak = Math.max(currentStreak, highestStreak);
            currentStreak = 1;
            if (highestStreak > inputAsArray.length - i + 1) {
               break;
            }
         }
      }
      return Math.max(highestStreak, currentStreak);
   }

   public static void main(String[] args) {

      String s = "aasdddddsssbbbba";
      char[] arr = s.toCharArray();
      Arrays.sort(arr);
      System.out.println(Arrays.toString(arr));
      System.out.println(maxPower(s));
   }
}
