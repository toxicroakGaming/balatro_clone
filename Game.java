import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Game {
    //what round and ante are we on?
    int round = 0;
    int ante = 0;
    //Hashmaps to store the values of each hand type
    HashMap<String, Integer> hand_chips = new HashMap<String, Integer>();
    HashMap<String, Integer> hand_mults = new HashMap<String, Integer>();
    public Game(){
        init_hands();
    }
    /*
     * This adds the hand types to our game. These are all the hands you can get in Balatro
     */
    private void init_hands(){
        //all of these arrays should have the same size, so the operations we do 
        //will not cause an error
        String[] hands = {"High Card","Pair", "Two Pair", "Three of a Kind", "Straight", "Flush", "Full House", "Four of a kind",
        "Straight Flush", "Royal Flush", "Five of a Kind", "Flush House, Flush Five"};
        int[] chip_amounts = {5, 10, 20, 30, 35, 49, 60, 100, 100, 120, 140, 160};
        int[] mult_amounts = {1, 2, 2, 3, 4, 4, 4, 7, 8, 8, 12, 14, 16};
        for(int i = 0; i < hands.length; ++i){
            hand_chips.put(hands[i], chip_amounts[i]);
            hand_mults.put(hands[i], mult_amounts[i]);
        }
    }

    /*
     * The main game loop that happens
     */
    public void do_turn(Player p, int num_hands, int num_disc, int chips, ArrayList<Card> deck){
        int chips_earned = 0;
        ArrayList<Card> cur_deck = new ArrayList<Card>(deck);
        //while we have not lost
        while(chips_earned < chips && num_hands > 0){
            ArrayList<Card> cur_hand = new ArrayList<Card>();
            //default hand size
            int hand_size = 8;
            //draw a hand to start with
            for(int i = 0; i < hand_size; i++){
                Card c = p.get_rand_card(cur_deck);
                cur_deck.remove(c);
                cur_hand.add(c);
            }
            //printing info
            System.out.println("Cur hand: ");
            int l = 0;
            for(Card cur : cur_hand){
                l++;
                System.out.println(l + ": " + cur.toString());
            }
            System.out.println();
            System.out.println();
            //pick which cards to play
            //by default, d will be do discard hand selected,
            //u will be to unselect a card
            //p will be to play hand for scoring
            //selections will be based off the index in your hand the card is
            Scanner sc = new Scanner(System.in);
            System.out.println("Pick cards (based on index)");
            System.out.println("When done, d to discard or p to play or u to unselect");
            System.out.println("Deck size " + cur_deck.size() + " / " + deck.size());
            String choice = "";
            String choices = "Selected Cards: \n";
            ArrayList<Card> selected = new ArrayList<Card>();
            Card temp = null;
            //while a hand is neither being played or discarded, do this
            //there might be a bug with logic to check later about drawing hands. This will be handled
            //in a later version if its an issue
            while(choice != "p" || choice != "d"){
                choice = sc.nextLine();
                //lets see if it is an index to select
                try {
                    int i = Integer.parseInt(choice);
                    if(i < 0 || i > cur_hand.size() - 1){
                        System.out.println("index out of range! choose again");
                    }
                    else{
                        temp = cur_hand.get(Integer.parseInt(choice));
                        selected.add(cur_hand.get(Integer.parseInt(choice)));
                        System.out.println("You selected" + cur_hand.get(Integer.parseInt(choice)).toString());
                        choices += cur_hand.get(Integer.parseInt(choice)).toString() + " \n";
                        System.out.println(choices);
                    }
                }
                //not an index
                catch (NumberFormatException e){
                    //play the hand
                    if(choice.equals("p")){
                        //score the hand
                        chips_earned += score_hand(cur_hand);
                        int ind = 0;
                        //draw more cards and remove selected cards from deck
                        for(Card c : selected){
                            ++ind;
                            cur_hand.remove(c);
                        }
                        for(int i = ind; i < hand_size; i++){
                            Card c = p.get_rand_card(cur_deck);
                            cur_deck.remove(c);
                            cur_hand.add(c);
                        }
                        selected.clear();
                        num_hands--;
                    }
                    //discards
                    else if(choice.equals("d")){
                        int ind = 0;
                        //discard the cards selected
                        for(Card c : selected){
                            ++ind;
                            cur_hand.remove(c);
                        }
                        //draw more cards
                        for(int i = ind; i < hand_size; i++){
                            Card c = p.get_rand_card(cur_deck);
                            cur_deck.remove(c);
                            cur_hand.add(c);
                        }
                        selected.clear();
                        num_disc --;
                    }
                    else if(choice.equals("u")){
                        selected.remove(temp);
                        System.out.println("previous card unselected");
                    }
                    //the user should not see this is valid input is given, but it is here
                    //just in case (error checking)
                    else{
                        System.out.println("invalid choice. Try again");
                    }
                }
            }
        }
    }

    /*
     * This is where the scoring happens
     */
    public int score_hand(ArrayList<Card> cur_hand){
        
        return 0;
    }

    /*
     * we will find out what hand the player has selected with this function
     */
    public String get_hand_type(ArrayList<Card> cur_hand){
        
        return "High Card";
    }
}
