import java.util.ArrayList;

public class Performance {
    private ArrayList<Score> playerPerformanceList = new ArrayList<Score>();

    public Performance() {}

    public Performance(ArrayList<Score> playerPerformanceList) {
        this.playerPerformanceList = playerPerformanceList;
    }

    public ArrayList<Score> getPlayerPerformanceList() {
        return playerPerformanceList;
    }

    public void setPlayerPerformanceList(ArrayList<Score> playerPerformanceList) {
        this.playerPerformanceList = playerPerformanceList;
    }


}
