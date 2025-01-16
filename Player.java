import java.util.ArrayList;
import java.util.Random;
public class Player {
    private int deckSize;
    private int money;
    private int numJokers;
    private ArrayList<Card> deck = new ArrayList<Card>();

    public Player(int money, ArrayList<Card> deck){
        this.money = money;
        this.deck = deck;
        numJokers = 0;
        deckSize = deck.size();
    }

    public void do_turn(){
        ArrayList<Card> cur_deck = new ArrayList<Card>(deck);
        ArrayList<Card> cur_hand = new ArrayList<Card>();
        int hand_size = 8;
        for(int i = 0; i < hand_size; i++){
            Card c = get_rand_card(cur_deck);
            cur_deck.remove(c);
            cur_hand.add(c);
        }
        System.out.println("Cur hand: ");
        for(Card cur : cur_hand){
            System.out.println(cur.get_card());
        }
        System.out.println();
        System.out.println();
    }
    public Card get_rand_card(ArrayList<Card> cur_deck){
        Random r = new Random();
        return cur_deck.get(r.nextInt(cur_deck.size()));
    }
}
