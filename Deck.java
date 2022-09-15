package Blackjack;

import java.util.ArrayList;
import Blackjack.Card;
import Blackjack.CardSuit;
import Blackjack.CardValue;


public class Deck {
    private ArrayList<Card> dArray;
    public Deck(){
        //Creates ArrayList which respresents a "deck" to store each card object. Calls create card method to create each card object
        this.dArray = new ArrayList<Card>(52);
        createCard();
    }

    public void createCard(){
        //Iterates through each suit and card value and creates a card object for each card value/suit combination.
        //After each card object is created the obejct is passed to the addCard method to be added to the deck, dArray List.
        int[] rank = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        int x = 0;
        int y = 0;

        //CardSuit[] sList = CardSuit.values();
        //CardValue[] vList = CardValue.values();
        
        for (int z = 0; z < 52; z++){     

            Card c = new Card(CardValue.values()[x], rank[y], CardSuit.values()[y]);
            addCard(c);
            if (y >= 12){
                x += 1;
                y = 0;
            }
        }
        
    }

    public void addCard(Card c){
        //adds each given card object to the deck, dArray List
        dArray.add(c);
        System.out.println(dArray.size());
    }   
}


