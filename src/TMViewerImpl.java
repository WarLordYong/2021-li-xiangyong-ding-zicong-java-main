public class TMViewerImpl implements TMViewer{
    @Override
    public void showPlayer(Player player) {
        System.out.println(player);
    }

    @Override
    public void showTeemIllegal() {
        System.out.println("Lack of Guardian!!!");
    }

    @Override
    public void showBalance(int currency) {
        System.out.println(currency);
    }

    @Override
    public void showPlayerDetail(Player player) {
        System.out.println(player.getId());
        System.out.println(player.getName());
        System.out.println(player.getPlay_Type());
    }

    @Override
    public void deleteError() {
        System.out.println("No player found.");
    }

    @Override
    public void showSellPlayer(Sell_Player sell) {
        System.out.println(sell.getPlayer());
        System.out.println(sell.getPrice());
        System.out.println(sell.getPlayer());
    }

    @Override
    public void findPlayerError() {
        System.out.println("Can't find player!!");
    }
}
