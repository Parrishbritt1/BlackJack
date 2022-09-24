package Blackjack;


public enum CardSuit{
    SPADE("♠"),
    CLUB("♣"),
    HEART("♥"),
    DIAMOND("♦");

    private String suit;

    private CardSuit(String suit) {
        this.suit = suit;
    }

    public String getSuit() {
        return this.suit;
    }
}