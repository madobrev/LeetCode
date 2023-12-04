package TwoPointer;

import java.util.*;

public class ThreeSum {

    public int findPositiveStart(int[] nums) {
        int target = 0;
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] > target) {
                right = middle - 1;
            } else if (nums[middle] < target) {
                left = middle + 1;
            } else {
                return middle;
            }
        }


        while (left > 0 && nums[left - 1] == 0) {
            left--;
        }

        return left;
    }

    public List<List<Integer>> twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> numToIndex = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int currentNumber = nums[i];
            int soughtNumber = target - currentNumber;

            if (numToIndex.containsKey(soughtNumber)) {
                List<Integer> foundPair = new ArrayList<>();
                foundPair.add(nums[numToIndex.get(soughtNumber)]);
                foundPair.add(currentNumber);
                result.add(foundPair);
            }
            numToIndex.put(currentNumber, i);
        }

        return result;
    }

    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        if (nums[0] > 0 || nums[nums.length - 1] < 0) {
            return new ArrayList<List<Integer>>();
        }

        int positiveNumbersBeginning = findPositiveStart(nums);

        int[] negativePart = Arrays.copyOfRange(nums, 0, positiveNumbersBeginning);
        int[] positivePart = Arrays.copyOfRange(nums, positiveNumbersBeginning, nums.length);

        boolean isPositivePartBeginningWithThreeOrMoreZeroes = positivePart.length >= 3 && positivePart[2] == 0;
        boolean isInputOnlyZeroes = negativePart.length == 1 && negativePart[0] == 0 && positivePart[positivePart.length - 1] == 0;

        if (isPositivePartBeginningWithThreeOrMoreZeroes || isInputOnlyZeroes) {
            List<Integer> onlyZeroes = Arrays.asList(0, 0, 0);
            result.add(onlyZeroes);
        }

        Set<Integer> seenCombinations = new HashSet<>();

        for (int i : negativePart) {
            if (seenCombinations.contains(i)) {
                continue;
            }
            List<List<Integer>> lists = twoSum(positivePart, -i);
            for (List<Integer> list : lists) {
                list.add(i);
            }

            result.addAll(lists);
            seenCombinations.add(i);
        }

        seenCombinations.clear();

        for (int i : positivePart) {
            if (seenCombinations.contains(i)) {
                continue;
            }

            List<List<Integer>> lists = twoSum(negativePart, -i);
            for (List<Integer> list : lists) {
                list.add(i);
            }

            result.addAll(lists);
            seenCombinations.add(i);
        }

        Set<List<Integer>> seenTriplets = new HashSet<>();
        List<List<Integer>> filteredResult = new ArrayList<>();

        for (List<Integer> correctCombination : result) {
            Collections.sort(correctCombination);
            if (!seenTriplets.contains(correctCombination)) {
                seenTriplets.add(correctCombination);
                filteredResult.add(correctCombination);
            }
        }

        return filteredResult;
    }

}
