package DailyChallenges.November2023;
// https://leetcode.com/problems/diagonal-traverse-ii/solutions/597698/java-c-hashmap-with-picture-clean-code-o-n/?envType=daily-question&envId=2023-11-22
// SOLVED

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedHashMap;
import java.util.List;

public class DiagonalTraverseII {

    public static int[] findDiagonalOrder(List<List<Integer>> nums) {

        LinkedHashMap<Integer, Deque<Integer>> map = new LinkedHashMap<>();
        List<Integer> finalOrder = new ArrayList<>();

        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.get(i).size(); j++) {
                int sum = i + j;
                int currentNumber = nums.get(i).get(j);

                map.computeIfAbsent(sum, k -> new ArrayDeque<>()).addFirst(currentNumber);
            }
        }

        for (Deque<Integer> numbers : map.values()) {
            finalOrder.addAll(numbers);
        }

        return finalOrder.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {


    }
}
