package BinarySearch;

import java.util.Arrays;

//UNSOLVED
public class KokoEatingBananas {

    public static int minEatingSpeed(int[] piles, int h) {

        Arrays.sort(piles);

        if (piles.length == h) {
            return piles[piles.length - 1];
        }


        int maxRepeats = h - piles.length;


        //when repeats are less than the input array length
        // if theres only 1 repeat possible, its always on the last element
        // 2 repeats = 2 last/ last-secondToLast
        // 3 repeats = 3last/ 2last-1secondToLast/ last:last-1:last-2


        //when repeats are more or equal to the input array len
        //

        int totalSum = Arrays.stream(piles).sum();


        for (int i = piles.length - 1; i >= 0; i--) {

        }

        int speed = 0;

        return speed;

    }


    public static void main(String[] args) {

//        int[] piles = {4,11,20,23,30};  // 1repeat
//        int h = 6;

        int[] piles = {3, 6, 7, 11};
        int h = 8;
        System.out.println(minEatingSpeed(piles, h));
    }

}
