public class TennisGame {

    private final String player1Name;
    private final String player2Name;
    private int player1Points;
    private int player2Points;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(player1Name)) {
            player1Points++;
        } else {
            player2Points++;
        }
    }

    public String getScore() {
        final String love = "Love";
        final String fifteen = "Fifteen";
        final String thirty = "Thirty";

        if (player1Points == 3) {
            if (player2Points == 4) {
                return "Advantage " + player2Name;
            }
            return score("Forty", thirty);
        }

        if (player1Points == 1) {
            if (player2Points > 0) {
                return score(fifteen, thirty);
            } else {
                return score(fifteen, love);
            }
        }
        if (player2Points == 0) {
            return score(love, "All");
        }

        return "Win for " + player2Name;
    }

    private String score(String player1Score, String player2Score) {
        return player1Score + "-" + player2Score;
    }
}
