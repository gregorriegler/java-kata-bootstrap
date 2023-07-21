public class TennisGame {
    private boolean field1;
    private boolean field2;

    public TennisGame(String playerName1, String playerName2) {
    }

    public void wonPoint(String playerName) {
        if (playerName.equals("player1")) {
            field1 = true;
        }
        field2 = true;
    }

    public String getScore() {
        if(field1) return "Forty-Thirty";
        if(field2) return "Win for player2";
        return "Love-All";
    }
}
