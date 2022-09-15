package Blackjack;

import java.util.ArrayList;
import Blackjack.Card;
import Blackjack.CardSuit;
import Blackjack.CardValue;
import java.util.Collections;


public class Deck {
    private ArrayList<Card> dArray;

    /**
     * Creates ArrayList which respresents a "deck" to store each card object. Calls create card method to create each card object
     */
    public Deck(){
        this.dArray = new ArrayList<Card>(52);
        fillDeck();
        shuffleDeck();
        Card f = drawCard();
        System.out.println(f);
    }

    /**
     * Fills the deck with Card Objects
     */
    public void fillDeck(){
        for (CardValue val : CardValue.values()) {
            for (CardSuit suit : CardSuit.values()) {
                Card card = new Card(suit, val);
                addCard(card);
            }
        }
    }

    /**
     * adds each given card object to the deck, dArray List
     * @param c Card object
     */
    public void addCard(Card c){
        this.dArray.add(c);
    }   

    /**
     * Shuffles deck, dArray List
     */
    public void shuffleDeck(){
        Collections.shuffle(this.dArray);
    }

    /**
     * Pops card off of deck, dArray List stack
     */
    public Card drawCard(){
        Card drawnCard = this.dArray.remove(this.dArray.size() - 1);
        return(drawnCard);
    }
}


