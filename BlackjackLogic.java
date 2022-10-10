package BlackJack;

import java.util.Scanner;
import java.lang.Runtime;
import java.util.concurrent.TimeUnit;

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
     *  HELPER METHOD to clear cmd
     */
    private void clearConsole() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            System.out.println("cls didn't work... Exception: " + e);
        }
    }

    /**
     * Main game loop logic
     */
    private void mainLoop() {
        do {
            clearConsole();

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
            while ((playerChoice != 2 || playerChoice != 3) && this.player.valueOfHand() < 21) {
                System.out.println("Current Bet: " + this.player.getBet());
                switch(playerChoice) {
                    case 1: // Hit
                        this.player.hit(this.deck.drawCard());
                        clearConsole();
                        printPlayerHands();
                        break;
                    case 2: // Double down
                        this.player.doubleDown(this.deck.drawCard());
                        clearConsole();
                        printPlayerHands();
                        playerChoice = 3; // Stand after doubling
                        break;
                }
                if (this.player.valueOfHand() < 21 && (playerChoice != 2 || playerChoice != 3)) {
                    playerChoice = playerChoice();    
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
        try{
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            System.out.println("error: " + e);
        }
    }

    /**
     * Prints all player's hands
     */
    private void printPlayerHands() {
        System.out.println(this.player);
        this.player.displayHand();
        System.out.println(this.house);
        this.house.displayHand();
    }

    /**
     * Prints game guidance ie. "Hit, double down, or stand"
     * @return Player's choice 1, 2, 3, or -1 if ERROR
     */
    public int playerChoice() {
        int choice = -1;
        do {
            System.out.println("Input the number of the desired move: 1: Hit | 2: Double down | 3: Stand");
            choice = scan.nextInt();
        } while (choice != 1 && choice != 2 && choice != 3);
        return choice;
    }

    /**
     * Houses turn
     */
    public void houseTurn()  {
        System.out.println("House's Turn");
        try {
            TimeUnit.SECONDS.sleep(2);
            while (house.valueOfHand() < 17){
                house.hit(deck.drawCard());
                clearConsole();
                printPlayerHands();
                TimeUnit.SECONDS.sleep(1);
            }
        } catch (InterruptedException e) {
            System.out.println("House's Turn Error: " + e);
        }
    }
}
