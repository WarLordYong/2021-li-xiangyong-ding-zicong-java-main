import java.util.ArrayList;

public class User {
    private String userName;
    private int currency = 10000;
    private ArrayList<Player> u_players = new ArrayList<Player>();
    private ArrayList<Sell_Player> sell_players = new ArrayList<Sell_Player>();
    private TMViewer tmViewer = new TMViewerImpl();
    private String passWord;

    public User() {}

    public User(String userName, int currency, ArrayList<Player> u_players, ArrayList<Sell_Player> sell_players) {
        this.userName = userName;
        this.currency = currency;
        this.u_players = u_players;
        this.sell_players = sell_players;
    }

    public User(String userName, String passWord) {
        super();
        this.userName = userName;
        this.passWord = passWord;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getCurrency() {
        return currency;
    }

    public void setCurrency(int currency) {
        this.currency = currency;
    }

    public ArrayList<Player> getU_players() {
        return u_players;
    }

    public void setU_players(ArrayList<Player> u_players) {
        this.u_players = u_players;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public ArrayList<Sell_Player> getSell_players() {
        return sell_players;
    }

    public void setSell_players(ArrayList<Sell_Player> sell_players) {
        this.sell_players = sell_players;
    }

    /*查找球员下标*/
    private int findIndeByPlayerID(int playerID) throws PlayerIDException {
        if(playerID < 0 || playerID > Integer.MAX_VALUE) {
            throw new PlayerIDException("play ID is illegal!!!");
        }

        int index = -1;

        for(int i = 0; i < u_players.size(); i++) {
            if(this.u_players.get(i).getId() == playerID) {
                index = i;
                break;
            }
        }
        return index;
    }

    /*通过ID查找球员*/
    private Player findByID(int playerID) throws PlayerIDException {
        if(playerID < 0 || playerID > Integer.MAX_VALUE) {
            throw new PlayerIDException("play ID is illegal!!!");
        }

        for(int i = 0; i < u_players.size(); i++) {
            if(u_players.get(i).getId() == playerID) {
                return u_players.get(i);
            }
        }
        tmViewer.findPlayerError();
        return null;
    }

    /*查询余额*/
    public void showBalance() {
        tmViewer.showBalance(currency);
    }

    /*查询所有卡*/
    public void showAllPlayers() {
        for(int i = 0; i < u_players.size(); i++) {
            tmViewer.showPlayer(this.u_players.get(i));
        }
    }

    /*查询卡的详情*/
    public void showPlayerDetail(Player player) {
        tmViewer.showPlayerDetail(player);
    }

    /*组建一支球队*/
    public Teem createTeem() {
        Teem teem = new Teem();
        return teem;
    }

    /*查询正在出售的卡*/
    public void showSellPlayers() {
        for (int i = 0; i < sell_players.size(); i++) {
            tmViewer.showSellPlayer(sell_players.get(i));
        }
    }

    /*将一张卡挂到交易所*/
    public void sellPlayer(Player player, int price, Market market) throws NullPlayerException {
        Sell_Player sell_player = new Sell_Player(player, this.userName, price);
        this.sell_players.add(sell_player);
        this.u_players.remove(player);
        market.addSellPlayer(sell_player);
    }

    /*撤销挂到交易所的卡*/
    public void revokeSellPlayer(Sell_Player sell_player, Market market) throws PlayerIDException {
        this.sell_players.remove(sell_player);
        this.u_players.add(sell_player.getPlayer());
        market.firePlayByID(sell_player.getPlayer().getId());
    }

    /*通过交易所卖出了一张卡*/
    public void firePlayer(Sell_Player sell_player, Market market) throws PlayerIDException {
        this.currency += sell_player.getPrice();
        this.sell_players.remove(sell_player);
        market.firePlayByID(sell_player.getPlayer().getId());
    }

    /*通过交易所买了一张卡*/
    public void buyPlayer(Sell_Player sell_player, Market market) throws PlayerIDException {
        this.currency -= sell_player.getPrice();
        this.u_players.add(sell_player.getPlayer());
        market.firePlayByID(sell_player.getPlayer().getId());
    }

    /*获得一张卡片*/
    public void addPlayer(Player player) throws NullPlayerException {
        if(player == null) {
            throw new NullPlayerException("null player!!");
        }
        u_players.add(player);
    }

    /*丢掉一张卡片*/
    public void deletePlayerByID(int playerID) throws PlayerIDException {
        int index = findIndeByPlayerID(playerID);

        if (index != -1) {
            u_players.remove(index);
        }
        else {
            tmViewer.deleteError();
        }
    }

    /*与一位玩家交易*/
    public boolean exchangePlayer(User user, int sellPlayerID, int buyPlayerID) throws PlayerIDException, NullPlayerException {
        addPlayer(user.findByID(buyPlayerID));
        deletePlayerByID(sellPlayerID);
        user.addPlayer(findByID(sellPlayerID));
        user.deletePlayerByID(buyPlayerID);
        return true;
    }



}
