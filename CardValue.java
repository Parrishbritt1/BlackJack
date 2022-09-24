package Blackjack;


public enum CardValue {
    ACE(11, "A"), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10),
    JACK(10, "J"), QUEEN(10, "Q"), KING(10, "K");

    private int val;
    private String symbol;

    private CardValue(int val, String symbol) {
        this.val = val;
        this.symbol = symbol;
    }

    public int getValue() {
        return this.val;
    }

    public String getSymbol(){
        return this.symbol;
    }
}