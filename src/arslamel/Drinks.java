/*
    CSS.css
    Author: Melih Eren Arslan
    Date: 07.31.2020

    Description
    Drink class is an enum class and it has drinks' name and price.
 
    @author Melih Eren Arslan
 */
package arslamel;

/**
 * Toppings class has 3 constant variables.
 *
 * @author melih
 */
public enum Drinks {
    COKE("Coke", 1.25),
    JUICE("Juice", 1.95),
    CHOCOLATE_MILK("Chocalate Milk", 2.25);

    private String names;
    private double price;

    /**
     * Constructor method of drink class
     *
     * @param names of the drink
     * @param price of the drinks price
     */
    private Drinks(String names, double price) {
        this.names = names;
        this.price = price;
    }

    /**
     * It calls the name of the drinks' name
     *
     * @return name of the drinks
     */
    public String getNames() {
        return names;
    }

    /**
     * It calls the name of the topping name
     *
     * @return price of the drinks
     */
    public double getPrice() {
        return price;
    }

    /**
     * toString method prints outs.
     *
     * @return the name of the topping and price
     */
    @Override
    public String toString() {
        return String.format("%10s  @  $%5.2f", this.names, this.price);
    }

}
