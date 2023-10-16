package bdd.helpers.privatbank;

public class Currency {

    private final String name;
    private final float buy; // to UAH
    private final float sell; // from UAH

    public Currency(String name, float buy, float sell) {
        this.name = name;
        this.buy = buy;
        this.sell = sell;
    }

    public String getName() {
        return name;
    }

    public float getBuy() {
        return buy;
    }

    public float getSell() {
        return sell;
    }

    @Override
    public String toString() {
        return String.format("Currency: %s. (Course to UAH: buy - %f, sell - %f)", name, buy, sell);
    }

}
