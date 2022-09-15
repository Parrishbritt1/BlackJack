package Blackjack;

import Blackjack.Deck;


public class BlackjackLogic {
    public BlackjackLogic() {
        Deck deck = new Deck();
        Player house = new Player("House");
        Player person = new Player ("Will");
        house.hit(deck.drawCard());
        person.hit(deck.drawCard());

    }
}
