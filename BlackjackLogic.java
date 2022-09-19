package Blackjack;

import Blackjack.Deck;
import java.util.Scanner;

public class BlackjackLogic {
    Scanner scan = new Scanner(System.in);
    public BlackjackLogic() {
        Deck deck = new Deck();
        Player house = new Player("House");
        house.hit(deck.drawCard());
        person.hit(deck.drawCard());
    }

    public void setup(){
        System.out.println("Enter player name: ");
        String pName = scan.nextLine();
        Player p = new Player(pName);
    }
}
