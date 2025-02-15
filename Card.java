import java.util.ArrayList;

public class Card {
    private int totalValue;
    //what value?
    private int value;
    //0 diamond
    //1 club
    //2 heart
    //3 spade
    //4 wild
    //5 stone. Stone cards are always played
    //6 other? there is no other
    private int suit;
    //what seal does it have?
    //0 none
    //1 purple
    //2 red
    //3 blue
    //4 gold
    private int seal;
    //what effect does card have?
    //0 none
    //1 polychrome
    //2 foil
    //3 holo
    //4 stone
    private int effect;
    //0 if not face
    //1 for jack
    //2 for queen
    //3 for king
    private int face;
    //the types in an arraylist
    private ArrayList<String> types;
    private ArrayList<String> faces;

    public Card(int value, int suit, int seal, int effect, int face){
        this.value = value;
        this.suit = suit;
        this.seal = seal;
        this.effect = effect;
        this.face = face;
        types = new ArrayList<String>();
        faces = new ArrayList<String>();
        types.add("Diamond");
        types.add("Club");
        types.add("Heart");
        types.add("Spade");
        types.add("Wild");
        types.add("Stone");
        faces.add("10");
        faces.add("Jack");
        faces.add("Queen");
        faces.add("King");
        totalValue = value;
    }
    //since we will be dealing with ints, this value will not change. maybe we
    //will deal with doubles later with mults, but for not, ints only.
    public int get_value(){
        return value;
    }
    //return if face or not
    public int get_face(){
        return face;
    }
    //returns the card being played
    public String toString(){
        String s = "";
        if(value == 50){
            return "Stone";
        }
        if(value == 10){
            if (face == 0){
                s += value + " ";
            }
            else {
                s += faces.get(face) + " ";
            }
        }
        else if(value == 11){
            s += "Ace ";
        }
        else{
            s += (value + " ");
        }
        s += "of ";
        s += types.get(suit);
        s += (" worth " + totalValue);
        return s;
    }
}
