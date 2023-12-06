package DailyChallenges.December2023;

public class CalculateMoneyInLeetcodeBank06_12 {
    public int totalMoney(int n) {

        final int MONEY_AFTER_FIRST_WEEK = 28;
        int amountOfFullWeeks = n / 7;
        int amountOfDaysInLastWeek = n % 7;
        int totalMoney = 0;

        if (amountOfDaysInLastWeek > 0) {
            int mondayValue = amountOfFullWeeks == 0 ? 1 : amountOfFullWeeks + 1;

            while (amountOfDaysInLastWeek > 0) {
                totalMoney += mondayValue;
                amountOfDaysInLastWeek--;
                mondayValue++;
            }
        }

        if (amountOfFullWeeks > 1) {
            while (amountOfFullWeeks > 0) {
                totalMoney += MONEY_AFTER_FIRST_WEEK + 7 * (amountOfFullWeeks - 1);
                amountOfFullWeeks--;
            }

        } else if (amountOfFullWeeks == 1) {
            totalMoney += MONEY_AFTER_FIRST_WEEK;
        }

        return totalMoney;
    }

}