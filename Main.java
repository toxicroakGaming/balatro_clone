import java.util.ArrayList;

class Main{
    public static void main(String[] args){
        //set up the player with a 52 card standard deck
        ArrayList<Card> mainDeck = new ArrayList<Card>();
        for(int num = 2; num < 12; num++){
            for(int suit = 0; suit < 4; ++suit){
                mainDeck.add(new Card (num, suit, 0, 0, 0));
            }
        }
        for(int face = 1; face < 4; face++){
            for(int suit = 0; suit < 4; ++suit){
                mainDeck.add(new Card (10, suit, 0, 0, face));
            }
        }
        System.out.println("size of the deck " + mainDeck.size());
        for(Card c : mainDeck){
            System.out.println(c.get_card());
        }
        System.out.println();
        Player main = new Player(4, mainDeck);
        for(int i = 0; i < 3; i++){
            main.do_turn();
        }
    }
}

