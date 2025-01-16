public class Joker {
    //0 for chip
    //1 for mult
    //2 for eco
    //3 for effect
    private int type;
    //+ or X? 0 for + 1 for X
    private int plus;
    //amount it is at. will sometimes be changed
    private int amount;
    //what effect does the joker have?
    //0 for default
    //1 for polychrome (X1.5 mult)
    //2 for foil (+50 chips)
    //3 for holo (+10 mult)
    //4 for negative (joker takes up zero space)
    private int effect;
    //how much does it sell for?
    private int sell;
}
