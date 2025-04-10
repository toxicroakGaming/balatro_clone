public class Pack{

//this is so that we know how many cards will be in the pack
//0: regular joker
//1: big joker
//2: tarot (small)
//3: tarot(big)
//4: arcana (small)
//5: arcana (big)
//6: planet (small)
//7: planet (big)
//8: card (small)
//9: card (big)
private int type;
private boolean show_cards = false;
//hand size
private int HS;

public Pack(int type, int hand_size){
    this.type = type;
    HS = hand_size;
    if(type == 2 || type ==3 || type == 4 || type == 5){
        show_cards = true;
    }
}

public void open_pack(){
    if(type == 0 || type == 1){
        open_joker();
    }
    if(type == 2 || type == 3){
        open_tarot();
    }
    if(type == 4 || type == 5){
        open_arcana();
    }
    if(type == 6 || type == 7){
        open_planet();
    }
    if(type == 8 || type == 9){
        open_card();
    }
}

//tarots
private void open_tarot(){

}
//arcana
private void open_arcana(){

}
//planet
private void open_planet(){

}
//joker
private void open_joker(){

}
//cards
private void open_card(){

}

}