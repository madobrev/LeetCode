package DailyChallenges.December2023;

public class CountOfMatchesInTournament05_12 {

    public int numberOfMatches(int n) {

        int matchesPlayed = 0;

        while (n > 1) {

            if (n % 2 == 0) {
                matchesPlayed += n / 2;
                n -= n / 2;

            } else {
                n--;
                matchesPlayed += n / 2;
                n -= n / 2;
                n++;
            }
        }

        return matchesPlayed;
    }
}
