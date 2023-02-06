import java.util.Scanner;

public class Teem {
    //球队
    private Player[] t_players = new Player[DEFAULT_CAPACITY];
    //统计当前players数组有多少元素
    private int itemCount = 0;
    //默认的球队球员个数
    private static final int DEFAULT_CAPACITY = 4;

    private TMViewer tmViewer = new TMViewerImpl();

    public Teem() {}

    public Teem(Player[] t_players) {
        this.t_players = t_players;
    }

    public Player[] getT_players() {
        return t_players;
    }

    public void setT_players(Player[] t_players) {
        this.t_players = t_players;
    }

    /*扩容球队*/
    private void grow() {
        int oldCapacity = this.t_players.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        Player[] newArray = new Player[newCapacity];
        for(int i = 0 ; i < oldCapacity; i++) {
            newArray[i] = this.t_players[i];
        }
        this.t_players = newArray;
    }

    /*查看所有球员*/
    public void showAllPlayers() {
        for(int i = 0; i < itemCount; i++) {
            tmViewer.showPlayer(this.t_players[i]);
        }
    }

    /*添加球员到球队中*/
    public boolean addPlayer(Player player) throws NullPlayerException {
        if(player == null) {
            throw new NullPlayerException("null player!!");
        }

        if(itemCount == this.t_players.length) {
            grow();
        }

        for(int i = 0; i < itemCount; i++) {
            if(t_players[i].getName() == player.getName() && t_players[i].getPlay_Type() == player.getPlay_Type()) {
                return false;
            }
            if(t_players[i].getPlay_Type() == Type.Guardian) {
                if(player.getPlay_Type() == Type.Guardian) {
                    return false;
                }
            }
        }
        this.t_players[itemCount++] = player;

        return true;
    }

    /*查找球员下标*/
    private int findIndeByPlayerID(int playerID) throws PlayerIDException {
        if(playerID < 0 || playerID > Integer.MAX_VALUE) {
            throw new PlayerIDException("play ID is illegal!!!");
        }

        int index = -1;

        for(int i = 0; i < itemCount; i++) {
            if(this.t_players[i].getId() == playerID) {
                index = i;
                break;
            }
        }
        return index;
    }

    /*将球员从球队中剔除*/
    public boolean firePlayerByID(int playID) throws PlayerIDException{
        int index = findIndeByPlayerID(playID);

        if(index != -1) {
            for(int i = index; i < itemCount - 1; i++) {
                t_players[i] = t_players[i + 1];
            }

            t_players[--itemCount] = null;
            return true;
        }
        else {
            tmViewer.deleteError();
            return false;
        }
    }

    /*判断球队是否有守门员*/
    public boolean ifTeemLegal() {
        for(int i = 0; i < itemCount; i++) {
            if(t_players[i].getPlay_Type() == Type.Guardian) {
                return true;
            }
        }
        tmViewer.showTeemIllegal();
        return false;
    }

    /*计算球队得分*/
    public double Scoring(Performance performance) {
        double score = 0;
        for (int i = 0; i < itemCount; i++) {
            for(int j = 0; j < performance.getPlayerPerformanceList().size(); j++) {
                if(this.t_players[i].getName() == performance.getPlayerPerformanceList().get(j).getPlayerName()) {
                    if(performance.getPlayerPerformanceList().get(j).getPlayerScore() == "-") {
                        break;
                    }
                    else if(this.t_players[i].getPlay_Level() == Level.R) {
                        score += Double.parseDouble(performance.getPlayerPerformanceList().get(j).getPlayerScore());
                    }
                    else if(this.t_players[i].getPlay_Level() == Level.SR) {
                        score += Double.parseDouble(performance.getPlayerPerformanceList().get(j).getPlayerScore()) * 1.05;
                    }
                    else if(this.t_players[i].getPlay_Level() == Level.SSR) {
                        score += Double.parseDouble(performance.getPlayerPerformanceList().get(j).getPlayerScore()) * 1.1;
                    }
                }
            }
        }
        return score;
    }
}
