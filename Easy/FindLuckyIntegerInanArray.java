package Easy;

// https://leetcode.com/problems/find-lucky-integer-in-an-array/
// SOLVED
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

public class FindLuckyIntegerInanArray {

   public static int findLucky(int[] arr) {
      HashMap<Integer, Integer> numberToFrequency = new HashMap<>();
      int highestNumber = -1;

      for (int num : arr) {
         numberToFrequency.put(num, numberToFrequency.getOrDefault(num, 0) + 1);
      }

      List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(numberToFrequency.entrySet());
      ListIterator<Map.Entry<Integer, Integer>> reverseIterator = entries.listIterator(entries.size());

      while (reverseIterator.hasPrevious()) {
         Map.Entry<Integer, Integer> entry = reverseIterator.previous();
         if (entry.getKey().equals(entry.getValue())) {
            highestNumber = entry.getKey();
            break;
         }
      }

      return highestNumber;
   }

   public static void main(String[] args) {

   }
}
