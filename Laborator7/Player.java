import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Player implements Runnable {

    String name;
    private Board board;
    private Boolean myTurn = false;
    private Integer seriesSize;
    List<Token> tokenList;
    public Player(String name, Board board) {
        this.board = board;
        tokenList = new ArrayList<Token>();
        this.name = name;
    }

    @Override
    public synchronized void run() {
        while (myTurn) {
            int random = (int) (Math.random() * board.getListSize() + 1);
           //System.out.println(board.getListSize());
            Token toAdd = board.getToken(random);
            tokenList.add(toAdd);
        }
    }

    public String getName(){
        return this.name;
    }

    public Boolean getMyTurn(){
        return this.myTurn;
    }

    public Integer getSeriesSize(){
        Arrays.sort(tokenList.toArray());
        Integer maxProgressionLength = 0;
        Integer currentProgressionLength;
        for(int outerIterator = 0; outerIterator < board.getInitialSize()/2;outerIterator++){
            for(Integer playerIterator = 0; playerIterator < this.tokenList.size();playerIterator++){
                currentProgressionLength = 0;
                for(Integer innerPlayerIterator = playerIterator; innerPlayerIterator < this.tokenList.size();innerPlayerIterator++ ){
                    if(!this.tokenList.get(playerIterator).getBlank() && !this.tokenList.get(innerPlayerIterator).getBlank()){
                    if(tokenList.get(playerIterator).getValue() + outerIterator * innerPlayerIterator == tokenList.get(innerPlayerIterator).getValue()){
                        currentProgressionLength++;
                    }}else{
                        if(this.tokenList.get(innerPlayerIterator).getBlank())
                        currentProgressionLength++;
                    }
                    if(currentProgressionLength > maxProgressionLength)
                        maxProgressionLength = currentProgressionLength;
                }
            }
        }
        return maxProgressionLength;
    }


}
