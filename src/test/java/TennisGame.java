public class TennisGame {

    private int player1Points;
    private int player2Scored;

    public TennisGame(String playerName1, String playerName2) {
    }

    public void wonPoint(String playerName) {
        if (playerName.equals("player1")) {
            player1Points++;
        } else {
            player2Scored++;
        }
    }

    public String getScore() {
        final String love = "Love";
        final String fifteen = "Fifteen";
        final String thirty = "Thirty";

        if (player1Points == 3) {
//            if (player2Scored) {
//                return "Advantage player2";            
//            }
            return score("Forty", thirty);
        }
        
        if (player1Points == 1) {
            if (player2Scored > 0) {
                return score(fifteen, thirty);
            } else {
                return score(fifteen, love);
            }
        }
        if (player2Scored == 0) {
            return score(love, "All");
        }

        return "Win for player2";
    }

    private String score(String player1Score, String player2Score) {
        return player1Score + "-" + player2Score;
    }
}
