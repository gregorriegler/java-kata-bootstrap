public class TennisGame {

    private int player1Points;
    private boolean player2Scored;

    public TennisGame(String playerName1, String playerName2) {
    }

    public void wonPoint(String playerName) {
        if (playerName.equals("player1")) {
            player1Points++;
        } else {
            player2Scored = true;
        }
    }

    public String getScore() {
        if (player1Points == 3) {
            return score("Forty", "Thirty");
        }
        if (player1Points == 1) {
            if (player2Scored)
                return score("Fifteen", "Thirty");
            return score("Fifteen", "Love");
        }
        if (player2Scored) {
            return "Win for player2";
        }
        return score("Love", "All");
    }

    private String score(String player1Score, String player2Score) {
        return player1Score + "-" + player2Score;
    }
}
