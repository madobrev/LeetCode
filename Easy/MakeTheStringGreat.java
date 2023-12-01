package Easy;

//https://leetcode.com/problems/make-the-string-great/description/
//SOLVED
import java.util.Stack;

public class MakeTheStringGreat {
   public static String makeGood(String s) {

      Stack<Character> lettersStack = new Stack<>();

      for (int i = 0; i < s.length(); i++) {
         char currentChar = s.charAt(i);
         boolean isCurrentCharUppercase = Character.isUpperCase(currentChar);

         if (!lettersStack.isEmpty()) {
            char previousChar = lettersStack.peek();
            boolean isPreviousCharUppercase = Character.isUpperCase(previousChar);

            boolean areBothCharsDifferentCasedAndSameValue = (isCurrentCharUppercase != isPreviousCharUppercase) &&
                  (Character.toUpperCase(previousChar) == Character.toUpperCase(currentChar));

            if (areBothCharsDifferentCasedAndSameValue) {
               lettersStack.pop();
            } else {
               lettersStack.push(currentChar);
            }

         } else {
            lettersStack.push(currentChar);
         }
      }

      StringBuilder result = new StringBuilder();
      for (Character ch : lettersStack) {
         result.append(ch);
      }

      return result.toString();
   }

   public static void main(String[] args) {

      String s = "leEeetcode";
      System.out.println(makeGood(s));
   }
}
