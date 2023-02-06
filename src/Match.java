import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Match {
    private ArrayList<Teem> matchList = new ArrayList<Teem>();

    public Match() {}

    public Match(ArrayList<Teem> matchList) {
        this.matchList = matchList;
    }

    public ArrayList<Teem> getMatchList() {
        return matchList;
    }

    public void setMatchList(ArrayList<Teem> matchList) {
        this.matchList = matchList;
    }

    /*排行榜*/
    public ArrayList<Double> board(Performance performance) {
        ArrayList<Double> board = new ArrayList<Double>();
        for(int i = 0; i< matchList.size(); i++) {
            board.add(matchList.get(i).Scoring(performance));
        }
        Collections.sort(board, new Comparator<Double>() {
            @Override
            public int compare(Double o1, Double o2) {
                return (int) (o2-o1);
            }
        });
        return board;
    }
}
