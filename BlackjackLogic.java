package Blackjack;

import Blackjack.Deck;

import java.util.Scanner;
import java.util.ArrayList;


public class BlackjackLogic {
    private Deck deck;
    private Player house;
    private Player player;
    private static final Scanner scan = new Scanner(System.in);

    public BlackjackLogic() {
        System.out.println("Enter player name: ");
        this.player = new Player(scan.next());
        this.deck = new Deck();
        this.house = new Player("House");
        mainLoop();
    }

    /**
     * Main game loop logic
     */
    private void mainLoop() {
        do {
            // Place bet
            System.out.println("Place your bet: ");
            this.player.makeBet((scan.nextInt()));

            // Draw cards
            this.player.hit(this.deck.drawCard());
            this.player.hit(this.deck.drawCard());
            this.house.hit(this.deck.drawCard());
            printPlayerHands();

            // Player choice
            int playerChoice = playerChoice();
            while (playerChoice != 3 && this.player.valueOfHand() < 21) {
                switch(playerChoice) {
                    case 1: // Hit
                        this.player.hit(this.deck.drawCard());
                        printPlayerHands();
                        break;
                    case 2: // Double down
                        this.player.doubleDown(this.deck.drawCard());
                        printPlayerHands();
                        playerChoice = 3; // Stand after doubling
                        break;
                }    
            }
            checkConditions();
            this.player.clearHand();
            this.house.clearHand();
        } while (true);
    }

    /**
     * Print if player won or not.
     */
    private void checkConditions() {
        // Player hand <= 21
        if (this.player.valueOfHand() <= 21) {
            houseTurn();
            if (this.house.valueOfHand() > 21) {
                System.out.println("HOUSE BUSTED - YOU WON");
            } else if (this.house.valueOfHand() > this.player.valueOfHand()) {
                System.out.println("YOU LOST");
            } else if (this.house.valueOfHand() < this.player.valueOfHand()) {
                System.out.println("YOU WON");
            } else {
                System.out.println("YOU PUSHED");
            }
        // Player Busted
        } else {
            System.out.println("YOU BUSTED RIP");
        }
    }

    /**
     * Prints all player's hands
     */
    private void printPlayerHands() {
        System.out.println(this.player);
        System.out.println(this.house);
    }

    /**
     * Prints game guidance ie. "Hit, double down, or stand"
     * @return Player's choice 1, 2, 3, or -1 if ERROR
     */
    public int playerChoice() {
        int choice = -1;
        do {
            try {
                System.out.println("Input the number of the desired move: 1: Hit | 2: Double down | 3: Stand");
                choice = Integer.parseInt(scan.next());
                if (choice != 1 || choice != 2 || choice != 3) {
                    System.out.println(choice + "is not a valid choice!");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Input is not a valid integer");
            }
        } while (!scan.hasNextInt());
        return choice;
    }

    /**
     * Houses turn
     */
    public void houseTurn() {
        System.out.println("House's Turn");
        while (house.valueOfHand() < 17){
            house.hit(deck.drawCard());
        }
    }
}
