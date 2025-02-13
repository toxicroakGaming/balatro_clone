public class Blind {
    private int chips_required;
    private int money_granted;

    public Blind(int chip, int money){
        this.chips_required = chip;
        this.money_granted = money;
    }

    public int get_chips(){
        return chips_required;
    }
    public int get_money(){
        return money_granted;
    }
    
}
