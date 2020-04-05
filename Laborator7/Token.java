import java.util.Comparator;

public class Token implements Comparable<Token> {
    private Integer value;
    private Boolean isBlank;
    private Integer maxValue = 900;

    public Token(Integer value) {
        if (value < maxValue) {
            this.value = value;
            this.isBlank = false;
        } else {
            this.value = null;
            this.isBlank = true;
        }
    }

    public Integer getValue() {
        return value;
    }

    public Boolean getBlank() {
        return isBlank;
    }


    @Override
    public int compareTo(Token o) {
        if(this.isBlank || o.isBlank)
            return 0;
        else
            return this.value.compareTo(o.value);
    }
}
