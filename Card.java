package Blackjack;

import java.lang.reflect.Array;
import java.util.ArrayList;
import Blackjack.CardSuit;
import Blackjack.CardValue;

public class Card {
    private CardSuit suit;
    private CardValue val;
    
    public Card(CardSuit suit, CardValue val){
        this.suit = suit;
        this.val = val;
    }
    public CardSuit getSuit() {
        return this.suit;
    }

    public CardValue getValue() {
        return this.val;
    }

    public void setSuite(CardSuit suit) {
        this.suit = suit;
    }

    public void setValue(CardValue val) {
        this.val = val;
    }

    public String toString() {
        return "{Suit: " + getSuit() + " Val: " + getValue() + "}";
    }
}

