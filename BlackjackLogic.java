package Blackjack;

import Blackjack.Deck;
import java.util.Scanner;

import javax.management.ValueExp;

public class BlackjackLogic {
    private Deck deck;
    private Player house;
    private Player p;
    private int option;

    public BlackjackLogic() {
        Scanner scan = new Scanner(System.in);
        this.deck = new Deck();
        this.house = new Player("House");
        this.option = 0;
        System.out.print("Enter player name: ");
        String pName = scan.nextLine();
        scan.close();
        this.p = new Player(pName);
        setup();
    }

    /**
     * Game setup, drawing 1 card for house and 2 cards for player
     */
    public void setup(){
        house.hit(deck.drawCard());
        p.hit(deck.drawCard());
        p.hit(deck.drawCard());
        playerInfo();
        playerOption();
    }

    /**
     * Prints game guidance ie. "Hit or stand"
     */
    public int gameOutput(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Input the number of the desired move: 1: hit | 2: Stand");
        this.option = scan.nextInt();
        scan.close();
        return this.option;
    }

    /*
     * Prints player game information
     */
    public void playerInfo(){
        System.out.println(p);
        System.out.println("HAND VALUE: " + p.valueOfHand());
    }

    /**
     * Presents player with choice of hit or stand
     * Calls houseTurn method once player stands
     * Ends game if player busts
     */
    public void playerOption(){
        while (this.option != 2 && p.isBust() == false){
            this.option = gameOutput();
            if (this.option == 1){
                p.hit(deck.drawCard());
                playerInfo();
            }
        }
        if (p.isBust() == false){
            houseTurn();
        }
        else{
            System.out.println("BUST");
        }
    }

    /**
     * Houses turn, house will hit until valueofHand >= 17
     */
    public void houseTurn(){
        while (house.valueOfHand() < 17){
            house.hit(deck.drawCard());
            System.out.println("HOUSE HAND: " + house.valueOfHand());
        }
    }
}
