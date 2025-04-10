public class Planet {
    private int type;
    private String name;
    private int mult_inc;
    private int chip_inc;
    private HashMap<String, Integer> num_chips;
    private HashMap<String, Integer> num_mult;
    public Planet(String name, int type, HashMap<String, Integer> chip, HashMap<String, Integer> mult){
        num_chips = chip;
        num_mult = mult;
        this.type = type;
        this.name = name;
    }

    private HashMap<String, Integer> increase_chips(int chips){
        return num_chips;
    }
    private HashMap<String, Integer> increase_mult(int mult){
        return num_mult;
    }
}
