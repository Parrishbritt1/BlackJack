package Blackjack;

import Blackjack.CardValue;
import Blackjack.Card;
import java.util.ArrayList;


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
}
