package Medium;
//https://leetcode.com/problems/insert-delete-getrandom-o1/description/?envType=study-plan-v2&envId=top-interview-150
//solved
import java.util.*;

public class RandomizedSet {

    private HashMap<Integer, Integer> hashMap;
    private ArrayList<Integer> list;


    public RandomizedSet() {
        hashMap = new HashMap<>();
        list = new ArrayList<>();
    }

    public boolean insert(int val) {

        if (hashMap.get(val) == null) {
            list.add(val);
            hashMap.put(val, list.size() - 1);
            return true;
        } else {
            return false;
        }

    }

    public boolean remove(int val) {
        if (hashMap.get(val) == null) {
            return false;
        } else {

            int indexToRemove = hashMap.get(val);
            int lastElement = list.get(list.size() - 1);

            list.set(indexToRemove, lastElement);
            hashMap.put(lastElement, indexToRemove);

            list.remove(list.size() - 1);
            hashMap.remove(val);
            return true;
        }
    }

    public int getRandom() {

        Random random = new Random();
        int randomIndex = random.nextInt(list.size());
        return list.get(randomIndex);
    }

}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */

