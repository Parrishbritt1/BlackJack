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

    @Override
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
        String rows = "\n┌───────────┐\t" +
        String.format("\n│ %s%s        │\t", symbol, filler) +             
        String.format("\n│ %s         │\t", suit) +  
                              "\n│           │\t" + 
        String.format("\n│    %s      │\t", suit) + 
                              "\n│           │\t" +
        String.format("\n│         %s │\t", suit) +
        String.format("\n│        %s%s │\t", filler, symbol) + 
                               "\n└───────────┘";
        return rows;
    }
}

