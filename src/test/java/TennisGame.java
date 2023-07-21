public class TennisGame {
    private int player1Scored;
    private boolean anyPlayerScored;

    public TennisGame(String playerName1, String playerName2) {
    }

    public void wonPoint(String playerName) {
        if (playerName.equals("player1")) {
            player1Scored++;
        }
        anyPlayerScored = true;
    }

    public String getScore() {
        if (player1Scored > 1) return score("Forty", "Thirty");
        if (player1Scored == 1) return score("Fifteen", "Thirty");
        if (anyPlayerScored) return "Win for player2";
        return score("Love", "All");
    }

    private String score(String forty, String thirty) {
        return forty + "-" + thirty;
    }
}
