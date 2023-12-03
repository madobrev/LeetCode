package ArraysAndHashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {

        int[] result = new int[k];
        List<Integer> listResult = new ArrayList<>();

        HashMap<Integer, Integer> numbersToFrequency = new HashMap<>();
        List<Integer>[] bucketList = new List[nums.length + 1];

        for (int i = 0; i < nums.length; i++) {
            numbersToFrequency.put(nums[i], numbersToFrequency.getOrDefault(nums[i], 0) + 1);
        }

        for (int number : numbersToFrequency.keySet()) {
            int frequencyValue = numbersToFrequency.get(number);
            if (bucketList[frequencyValue] == null) {
                bucketList[frequencyValue] = new ArrayList<>();
            }
            bucketList[frequencyValue].add(number);
        }

        for (int i = bucketList.length - 1; i > 0; i--) {
            if (listResult.size() >= k) {
                break;
            }
            if (bucketList[i] != null) {
                listResult.addAll(bucketList[i]);
            }
        }

        for (int i = 0; i < k; i++) {
            result[i] = listResult.get(i);
        }
        return result;
    }
}
