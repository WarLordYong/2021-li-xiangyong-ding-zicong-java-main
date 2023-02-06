public class Score {
    private String playerClub;
    private String playerName;
    private String playerScore;

    public Score() {}

    public Score(String playerClub, String playerName, String playerScore) {
        this.playerClub = playerClub;
        this.playerName = playerName;
        this.playerScore = playerScore;
    }

    public String getPlayerClub() {
        return playerClub;
    }

    public void setPlayerClub(String playerClub) {
        this.playerClub = playerClub;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerScore() {
        return playerScore;
    }

    public void setPlayerScore(String playerScore) {
        this.playerScore = playerScore;
    }
}
