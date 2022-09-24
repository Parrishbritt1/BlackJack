package Blackjack;

import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.xml.namespace.QName;

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
        return cardArt();
    }

    public String cardArt() {
        String suit = getSuit().getSuit();
        if (getValue().getValue() > 9){
            String symbol = getSymbol().getSymbol();
        }
        else{
            int symbol = getValue().getValue();
        }
        String rows = "\n┌───────────┐\n" +
        String.format("│ %d        │\n", val) +             
        String.format("│ %s         │\n", suit) +  
        "│          │\n" + 
        String.format("│    %s      │\n", suit) + 
        "│          │\n" +
        String.format("│         %s │\n", suit) +
        String.format("│        %d │\n", val) + 
        "└───────────┘\n";
        return rows;
    }
}

