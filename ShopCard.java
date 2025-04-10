Public Class ShopCard{
    private int type;
    //this will be changed later, but basically, have one of each card
    //only initialize the kind that the shop actually is
    //so I guess this is a wrapper class? a good way to prevent this
    //is to just make a parent class, which will be done another time
    private Tarot t;
    private Planet p;
    private Joker j;
    private Card c;
    private int price;
}