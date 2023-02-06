import java.util.ArrayList;

public class Pool {
    private static final int NUMBER_R = 1000;
    private static final int NUMBER_SR = 100;
    private static final int NUMBER_SSR = 10;

    private ArrayList<Player> allPlayerPool = new ArrayList<Player>();

    public Pool() {}

    public Pool(ArrayList<Player> allPlayerPool) {
        this.allPlayerPool = allPlayerPool;
    }

    /*加入球员*/
    public void addPlayer(String name, Type type) {
        int num = 1;

        for(int i = 0; i < NUMBER_R; i++) {
            Player player = new Player(num, name, type, Level.R);
            allPlayerPool.add(player);
            num++;
        }

        num = 1;
        for(int i = 0; i < NUMBER_SR; i++) {
            Player player = new Player(num, name, type, Level.SR);
            allPlayerPool.add(player);
            num++;
        }

        num = 1;
        for(int i = 0; i < NUMBER_SSR; i++) {
            Player player = new Player(num, name, type, Level.SSR);
            allPlayerPool.add(player);
            num++;
        }
    }

    /*加入一张卡*/
    public void addCard(Player player) {

    }


}
