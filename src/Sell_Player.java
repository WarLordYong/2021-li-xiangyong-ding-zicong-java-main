public class Sell_Player {
    private Player player;
    private String userName;
    private int price;

    public Sell_Player() {};
    public Sell_Player(Player player, String userName, int price) {
        this.player = player;
        this.userName = userName;
        this.price = price;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
