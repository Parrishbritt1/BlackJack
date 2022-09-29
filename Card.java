package BlackJack;

import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.xml.namespace.QName;

import BlackJack.CardSuit;
import BlackJack.CardValue;

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
        String symbol = getValue().getSymbol();
        String filler = " ";
        
        if (getValue() == CardValue.TEN){
            filler = "";
        }
        String rows = "\n┌───────────┐\n" +
        String.format("│ %s%s        │\n", symbol, filler) +             
        String.format("│ %s         │\n", suit) +  
        "│           │\n" + 
        String.format("│    %s      │\n", suit) + 
        "│           │\n" +
        String.format("│         %s │\n", suit) +
        String.format("│        %s%s │\n", filler, symbol) + 
        "└───────────┘";
        return rows;
    }
}

