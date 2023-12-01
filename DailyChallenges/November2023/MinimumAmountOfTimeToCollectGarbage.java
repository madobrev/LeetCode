package DailyChallenges.November2023;

//https://leetcode.com/problems/minimum-amount-of-time-to-collect-garbage/?envType=daily-question&envId=2023-11-20
// SOLVED
public class MinimumAmountOfTimeToCollectGarbage {
    public static int garbageCollection(String[] garbage, int[] travel) {

        int totalMinutes = 0;
        int lastSeenM = -1;
        int lastSeenG = -1;
        int lastSeenP = -1;

        for (int i = 0; i < garbage.length; i++) {
            totalMinutes += garbage[i].length();
            lastSeenM = garbage[i].contains("M") ? i : lastSeenM;
            lastSeenG = garbage[i].contains("G") ? i : lastSeenG;
            lastSeenP = garbage[i].contains("P") ? i : lastSeenP;
        }

        for (int j = 0; j < Math.max(Math.max(lastSeenP, lastSeenM), lastSeenG); j++) {
            if (j < lastSeenG) {
                totalMinutes += travel[j];
            }
            if (j < lastSeenM) {
                totalMinutes += travel[j];
            }
            if (j < lastSeenP) {
                totalMinutes += travel[j];
            }
        }
        return totalMinutes;
    }

    public static void main(String[] args) {

    }
}
