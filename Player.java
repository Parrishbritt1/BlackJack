package Blackjack;

import Blackjack.CardValue;
import Blackjack.Card;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * TO DO
 * add setup method that asks for player name, creates house and player obj, deals out cards (signifies beginning of game basically)
 */
public class Player {
    private ArrayList<Card> hand;
    private int valueOfHand;
    private String name;

    /**
     * Player Constructor
     * @param name Name of the player
     */
    public Player(String name) {
        this.hand = new ArrayList<Card>();
        this.name = name;
        this.valueOfHand = 0;
    }

    public String getName() {
        return this.name;
    }

    public int valueOfHand() {
        return this.valueOfHand;
    }

    /**
     * Player hits (adds card to hand and updates value of hand)
     * @param card Card that will be added to hand
     */
    public void hit(Card card) {
        this.hand.add(card);
        updateValueOfHand();
    }

    /**
     * Player stands (doesn't add cards to hand)
     */
    public void stand(){
        updateValueOfHand();
    }

    /**
     * Checks if player goes bust, (hand value > 21)
     * @return boolean if player is bust
     */
    public boolean isBust(){
        if (valueOfHand() > 21){
            return true;
        }
        return false;
    }

    /**
     * Private helper method
     * Gets the value of player's hand
     * @return value of hand
     */
    private int updateValueOfHand() {
        this.valueOfHand = 0;
        for (Card c : hand) {
            if (c.getValue() == CardValue.ACE) {
                if (this.valueOfHand + c.getValue().getValue() > 21) {
                    this.valueOfHand += 1;
                    continue;
                }
            } else {
                this.valueOfHand += c.getValue().getValue();
            }
        }
        return this.valueOfHand;
    }

    public String toString() {
        return "Player - " + this.name + " Hand - " + this.hand;
    }
}
