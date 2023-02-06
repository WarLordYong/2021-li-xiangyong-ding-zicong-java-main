# 类

1. User(username, currency, u_players<Player>, sell_players<Sell_Player>)
2. Player(num, name, player_Type, player_Level)
3. Sell_Player(player, userName, price)
4. Teem(t_players<Player>, itemCount)
5. Score(playerClub, playerName, playerScore)
6. Performance(playerPerformanceList<Score>)
7. Match(matchList<Teem>)
8. Market(sell_list<Sell_Player>)

# 方法

1. User:
   1. 查询余额：void showBalance()
   2. 查询所有卡：void showAllPlayers()
   3. 查询单卡的详情：void showPlayerDetail(player)
   4. 组建一支球队：Teem createTeem()
   5. 查询正在出售的卡：void showSellPlayers()
   6. 挂一张卡去卖：void sellPlayer(player, price, market)
   7. 撤销挂的卡：void revokeSellPlayer(sell_player, market)
   8. 卖出了一张卡：void firePlayer(sell_player, market)
   9. 买进了一张卡：void buyPlayer(sell_player, market)
   10. 获得一张卡：void addPlayer(player)
   11. 丢掉一张卡：deletePlayerByID(playerID)
   12. 跟一名玩家交易：boolean exchangePlayer(user, sellPlayerID, buyPlayerID)
2. Teem:
   1. 查看所有队员：void showAllPlayers()
   2. 添加球员到球队：boolean addPlayer(player)
   3. 将球员开除出球队：boolean firePlayerByID(playID)
   4. 判断是否有守门员：boolean ifTeemLegal()
   5. 计算球队得分：double Scoring(performance)
3. Match:
   1. 排行榜：ArrayList<Double> board(performance)
4. Market:
   1. 展示正在出售的卡：void showSellPlayers()
   2. 加一张卡上去：addSellPlayer(sell_Player)
   3. 卖出一张卡：firePlayerByID(playId)
