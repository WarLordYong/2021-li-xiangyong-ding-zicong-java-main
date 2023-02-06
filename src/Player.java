public class Player {
    private static int PLAYER_ID = 0;
    private int id;
    private int num;
    private String name;
    private Type play_Type;
    private Level play_Level;

    {
        PLAYER_ID++;
    }

    public Player() {}

    public Player(int num, String name, Type play_Type, Level play_Level) {
        this.id = PLAYER_ID;
        this.num = num;
        this.name = name;
        this.play_Type = play_Type;
        this.play_Level = play_Level;
    }

    public int getId() {
        return id;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getPlay_Type() {
        return play_Type;
    }

    public void setPlay_Type(Type play_Type) {
        this.play_Type = play_Type;
    }

    public Level getPlay_Level() {
        return play_Level;
    }

    public void setPlay_Level(Level play_Level) {
        this.play_Level = play_Level;
    }
}
