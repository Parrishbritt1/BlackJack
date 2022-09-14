package Blackjack;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Card {
    CardSuit suit;
    int rank;
    CardValue val;
    
    public Card(CardSuit suit, int rank, CardValue val){
        this.suit = suit;
        this.rank = rank;
        this.val = val;
    }
    public CardSuit getSuite() {
        return this.suit;
    }

    public CardValue getValue() {
        return this.value;
    }

    public void setSuite(CardSuite suit) {
        this.suit = suit;
    }

    public void setValue(CardValue value) {
        this.value = value;
    }
}

