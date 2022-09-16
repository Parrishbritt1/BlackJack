package Blackjack;


public class RUNNER {
    public static void main(String args[]){
        Deck d = new Deck();
        Player p = new Player("PSlatt");
        p.hit(d.drawCard());
        System.out.println(p);
        // d.printDeck();
    }
}
