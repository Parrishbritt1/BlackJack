package BlackJack;


public enum CardSuit{
    SPADE("S"),
    CLUB("C"),
    HEART("H"),
    DIAMOND("D");

    private String suit;

    private CardSuit(String suit) {
        this.suit = suit;
    }

    public String getSuit() {
        return this.suit;
    }
}