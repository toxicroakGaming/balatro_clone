import java.util.ArrayList;

class Main{
    public static void main(String[] args){
        //set up the player with a 52 card standard deck
        ArrayList<Card> mainDeck = new ArrayList<Card>();
        //add number cards (and ace)
        for(int num = 2; num < 12; num++){
            for(int suit = 0; suit < 4; ++suit){
                mainDeck.add(new Card (num, suit, 0, 0, 0));
            }
        }
        //add face cards
        for(int face = 11; face < 14; face++){
            for(int suit = 0; suit < 4; ++suit){
                mainDeck.add(new Card (10, suit, 0, 0, face));
            }
        }
        //just a test that will be deleted later
        System.out.println("size of the deck " + mainDeck.size());
        for(Card c : mainDeck){
            System.out.println(c.toString());
        }
        System.out.println();
        //this is the main game loop
        //get blind HP. it will be an arrayList here
        //right now, we will assume it is just the first blind for now
        //also, design decision. shop as a class or handle shop in player?
        Player main = new Player(4, mainDeck, 4, 4);
        main.do_turn(300, 4);
    }
}

