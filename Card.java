package Blackjack;

import Blackjack.CardSuit;
import Blackjack.CardValue;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Card {
    CardSuit suit;
    int rank;
    CardValue val;

    public Card(CardValue val, int rank, CardSuit suit){
        this.suit = suit;
        this.rank = rank;
        this.val = val;
    }
    public CardSuit getSuit() {
        return this.suit;
    }

    public CardValue getValue() {
        return this.val;
    }

    public void setSuit(CardSuit suit) {
        this.suit = suit;
    }

    public void setValue(CardValue val) {
        this.val = val;
    }
}

