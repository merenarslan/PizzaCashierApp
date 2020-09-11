/*
    CSS.css
    Author: Melih Eren Arslan
    Date: 07.31.2020

    Description
    Toppings class is an enum class. It has toppings names and toppings price.
 
    @author Melih Eren Arslan
 */
package arslamel;

/**
 * Toppings class has 2 constant variables.
 *
 * @author melih
 */
public enum Toppings {

    CHEESE("Cheese", 1.00),
    MUSHROOMS("Mushrooms", 1.25),
    OLIVES("Olives", 1.50),
    PEPPERONI("Pepperoni", 1.75);

    private String name;
    private double price;

    /**
     * Constructor method of toppings' class
     *
     * @param name of the topping
     * @param price of the toppings' price
     */
    private Toppings(String name, double price) {
        this.name = name;
        this.price = price;
    }

    /**
     * It calls the name of the topping name
     *
     * @return name of the topping
     */
    public String getName() {
        return name;
    }

    /**
     * It calls the price of the topping price
     *
     * @return price of the name
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
        return String.format("%10s  @  $%5.2f", this.name, this.price);
    }

}
