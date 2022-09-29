package BlackJack;

import BlackJack.CardValue;
import BlackJack.Card;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * TO DO
 * add setup method that asks for player name, creates house and player obj, deals out cards (signifies beginning of game basically)
 */
public class Player {
    private ArrayList<Card> hand;
    private int valueOfHand;
    private int bankroll;
    private int bet;
    private String name;

    /**
     * Player Constructor
     * @param name Name of the player
     */
    public Player(String name) {
        this.hand = new ArrayList<Card>();
        this.name = name;
        this.valueOfHand = 0;
        this.bet = 0;
        this.bankroll = 1000;
    }

    public String getName() {
        return this.name;
    }

    public int valueOfHand() {
        return this.valueOfHand;
    }

    public int getBankroll() {
        return this.bankroll;
    }

    public int getBet() {
        return this.bet;
    }
    
    /**
     * Adds bet amount to total bet, subtracts bet amount from bankroll
     * @param newBet is input bet amount 
     */
    public void makeBet(int newBet) {
        this.bet += newBet;
        this.bankroll -= this.bet;
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
     * Player doubles down (player hits and doubles the bet)
     * @param card Card that will be added to hand
     */
    public void doubleDown(Card card) {
        this.hit(card);
        this.makeBet(this.bet);
    }

    /**
     * Removes all cards from hand.
     */
    public void clearHand() {
        this.hand.clear();
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
                } else {
                    this.valueOfHand += c.getValue().getValue();
                }
            } else {
                this.valueOfHand += c.getValue().getValue();
            }
        }
        return this.valueOfHand;
    }

    /**
     * Prints the Player's hand to the screen ASCII format
     */
    public void displayHand() {
        // ArrayList<String> rows = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            String s = "";
            for (Card c : this.hand) {
                String symbol = c.getValue().getSymbol();
                String suit = c.getSuit().getSuit();
                String filler = " ";
                if (c.getValue() == CardValue.TEN){
                    filler = "";
                }
                switch(i) {
                    case 0:
                        s += "┌───────────┐";
                        // rows.append(s);
                        break;
                    case 1:
                        s += String.format("│ %s%s        │", symbol, filler);
                        // rows.append(s);
                        break;
                    case 2:
                        s += String.format("│ %s         │", suit);
                        // rows.append(s);
                        break;
                    case 3:
                        s += "│           │";
                        // rows.append(s);
                        break;
                    case 4:
                        s += String.format("│    %s      │", suit);
                        // rows.append(s);
                        break;
                    case 5:
                        s += "│           │";
                        // rows.append(s);
                        break;
                    case 6:
                        s += String.format("│         %s │", suit);
                        // rows.append(s);
                        break;
                    case 7:
                        s += String.format("│        %s%s │", filler, symbol);
                        // rows.append(s);
                        break;
                    case 8:
                        s += "└───────────┘";
                        // rows.append(s);
                        break;
                }
            }
            System.out.println(s);
        }
    }

    public String toString() {
        return "Player - " + this.name + " | Hand Value: " + valueOfHand() + "\n"; 
    }
}
