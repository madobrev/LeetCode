package DailyChallenges.November2023;

//https://leetcode.com/problems/number-of-ways-to-divide-a-long-corridor/description/?envType=daily-question&envId=2023-11-28
//SOLVED

public class NumberOfWaysToDivideALongCorridor {
    public static int numberOfWays(String corridor) {

        long amountOfSeats = corridor.chars().filter(ch -> ch == 'S').count();

        if (amountOfSeats == 2) {
            return 1;
        } else if (amountOfSeats < 2 || amountOfSeats % 2 == 1) {
            return 0;
        }
        final int MODULO = (int) Math.pow(10, 9) + 7;
        long result = 0;

        boolean isFirstOfTwoChairsEnountered = false;
        boolean isPairOfChairsFound = false;

        int amountOfPossibleSeparations = 0;

        for (int i = 0; i < corridor.length(); i++) {

            char currentChar = corridor.charAt(i);

            if (isPairOfChairsFound) {
                if (currentChar == 'P') {
                    amountOfPossibleSeparations++;
                } else {
                    result = result == 0 ? amountOfPossibleSeparations
                            : (result * amountOfPossibleSeparations) % MODULO;
                    amountOfPossibleSeparations = 0;
                    isPairOfChairsFound = false;
                    isFirstOfTwoChairsEnountered = true;
                }
                continue;
            }

            if (isFirstOfTwoChairsEnountered) {
                if (currentChar == 'P') {
                    continue;
                } else {
                    isFirstOfTwoChairsEnountered = false;
                    isPairOfChairsFound = true;
                    amountOfPossibleSeparations++;
                }

            } else {
                if (currentChar == 'S') {
                    isFirstOfTwoChairsEnountered = true;
                }
            }

        }

        return (int) result % MODULO;

    }

    public static void main(String[] args) {

        String corridor = "SSPPSPS";
        System.out.println(numberOfWays(corridor));

    }
}
