import javax.swing.plaf.SliderUI;
import java.util.ArrayList;

public class Market {
    private ArrayList<Sell_Player> sell_list = new ArrayList<Sell_Player>();
    private TMViewer tmViewer = new TMViewerImpl();

    public Market() {};
    public Market(ArrayList<Sell_Player> sell_list) {
        this.sell_list = sell_list;
    }

    public ArrayList<Sell_Player> getSell_list() {
        return sell_list;
    }

    public void setSell_list(ArrayList<Sell_Player> sell_list) {
        this.sell_list = sell_list;
    }

    /*展示当前正在出售的卡*/
    public void showSellPlayers() {
        for(int i = 0; i < sell_list.size(); i++) {
            tmViewer.showSellPlayer(sell_list.get(i));
        }
    }

    /*加入一张卡上去*/
    public void addSellPlayer(Sell_Player sell_Player) throws NullPlayerException{
        if(sell_Player == null) {
            throw new NullPlayerException("null player!!");
        }
        sell_list.add(sell_Player);
    }

    /*查找售卡下标*/
    private int findIndeBySellPlayerID(int playerID) throws PlayerIDException {
        if(playerID < 0 || playerID > Integer.MAX_VALUE) {
            throw new PlayerIDException("play ID is illegal!!!");
        }

        int index = -1;

        for(int i = 0; i < sell_list.size(); i++) {
            if(this.sell_list.get(i).getPlayer().getId() == playerID) {
                index = i;
                break;
            }
        }
        return index;
    }

    /*卖出一张卡*/
    public boolean firePlayByID(int playID) throws PlayerIDException{
        int index = findIndeBySellPlayerID(playID);

        if(index != -1) {
           sell_list.remove(index);
        }
        else {
            tmViewer.deleteError();
            return false;
        }
        return true;
    }



}
