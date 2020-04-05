import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Board {
    private List<Token> tokenList;
    private Integer size;
    private Integer initialSize;


    public Board(Integer size) {
        this.size = size;
        this.initialSize = size;
        List<Token> intermediaryList = new ArrayList<Token>();
        for (int k = 0; k < size; k++) {

            Token curToken = new Token(k);
            System.out.println(curToken.getValue());
            intermediaryList.add(curToken);
        }
        tokenList = Collections.synchronizedList(intermediaryList);
    }

    public Token getToken(int index) {
        Token toSend = tokenList.get(index);
        tokenList.remove(index);
        size--;
        return toSend;
    }

    public Integer getListSize() {
        return tokenList.size();
    }

    public Integer getInitialSize(){
        return this.initialSize;
    }


}
