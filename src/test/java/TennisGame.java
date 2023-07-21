public class TennisGame {
    private boolean player1Scored;
    private boolean anyPlayerScored;

    public TennisGame(String playerName1, String playerName2) {
    }

    public void wonPoint(String playerName) {
        if (playerName.equals("player1")) {
            player1Scored = true;
        }
        anyPlayerScored = true;
    }

    public String getScore() {
        if (player1Scored) return "Forty-Thirty";
        if (anyPlayerScored) return "Win for player2";
        return "Love-All";
    }
}
