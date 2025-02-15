import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
public class Player {
    //how much money the player has
    private int money;
    //how many jokers the player has (non negative)
    private int numJokers;
    //the full deck
    private ArrayList<Card> deck = new ArrayList<Card>();
    //number of discards and hands available to the player
    private int num_hands;
    private int num_disc;

    /*
     * Init the player values
     */
    public Player(int money, ArrayList<Card> deck, int num_hands, int num_disc){
        this.money = money;
        this.deck = deck;
        numJokers = 0;
        this.num_hands = num_hands;
        this.num_disc = num_disc;
    }

    /*
     * This is where the majority of stuff is happening.
     * This method IS NOT the shop, but handles each round
     * enters loop until either no hands or boss blind is defeated
     * this function is here as a backup in case things fail
     */
    public void do_turn(int chips, int money){
            int chips_earned = 0;
            int hand_cur = num_hands;
            int disc_cur = num_disc;
            ArrayList<Card> cur_deck = new ArrayList<Card>(deck);
            while(chips_earned < chips){
                ArrayList<Card> cur_hand = new ArrayList<Card>();
                int hand_size = 8;
                for(int i = 0; i < hand_size; i++){
                    Card c = get_rand_card(cur_deck);
                    cur_deck.remove(c);
                    cur_hand.add(c);
                }
                System.out.println("Cur hand: ");
                int l = 0;
                for(Card cur : cur_hand){
                    l++;
                    System.out.println(l + ": " + cur.toString());
                }
                System.out.println();
                System.out.println();
                Scanner sc = new Scanner(System.in);
                System.out.println("Pick cards ");
                System.out.println("Deck size " + cur_deck.size() + " / " + deck.size());
            }
    }

    /* 
     * This method selects the card that we want to return
     * It DOES NOT remove it from the deck, just selects it.
     * the fact that it doesnt remove is done for debugging purposes
    */
    public Card get_rand_card(ArrayList<Card> cur_deck){
        Random r = new Random();
        return cur_deck.get(r.nextInt(cur_deck.size()));
    }
}
