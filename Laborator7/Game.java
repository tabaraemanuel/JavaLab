import java.util.ArrayList;
import java.util.List;

public class Game {

    private List<Runnable> playerList;
    private Boolean currRunning;
    private Board board;
    private Integer numberOfPlayers;

    public Game(Integer numberOfPlayers) {

        this.currRunning = false;
        board = new Board(20);
        this.numberOfPlayers = numberOfPlayers;
        Runnable player1 = new Player("FirstPlayer",board);
        Runnable player2 = new Player("SecondPlayer",board);
        playerList = new ArrayList<Runnable>();
        playerList.add(player1); playerList.add(player2);
    }

    public void startGame(){
        currRunning = true;
        try{
            synchronized (this){
                while(board.getListSize() > 0){
                    new Thread(playerList.get(0)).start();
                    new Thread(playerList.get(1)).start();
                }
                Player inter1 = (Player) playerList.get(0);
                Player inter2 = (Player) playerList.get(1);
                if(inter1.getSeriesSize() > inter2.getSeriesSize())
                System.out.println("Player 1 won");
                else
                    System.out.println("Player 2 won");
            }
        }catch (Exception e){
            System.out.println("Met start exception");
        }

    }

}
