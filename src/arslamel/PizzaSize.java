/*
    CSS.css
    Author: Melih Eren Arslan
    Date: 07.31.2020

    Description
    PizzaSize class is an enum class. It has pizza sizes and prices.
 
    @author Melih Eren Arslan
 */
package arslamel;

/**
 * PizzaSize class has 2 constant variables for sizes and prices.
 *
 * @author melih
 */
public enum PizzaSize {

    SMALL("Small", 5.25),
    MEDIUM("Medium", 7.50),
    LARGE("Large", 9.95);

    private String size;
    private double price;

    /**
     * Constructor method of PizzaSize class
     *
     * @param size of the pizza
     * @param price of the pizza
     */
    private PizzaSize(String size, double price) {
        this.size = size;
        this.price = price;

    }

    /**
     * It calls the name of PizzaSize
     *
     * @return name of PizzaSize
     */
    public String getPizzaSize() {

        return this.size;
    }

    /**
     * It calls the price of pizza price
     *
     * @return price of the PizzaSize
     */
    public double getPrice() {

        return this.price;
    }

    /**
     * toString method prints outs.
     *
     * @return the name of the topping and price
     */
    @Override
    public String toString() {
        return String.format("%10s  @  $%5.2f", this.size, this.price);
    }

}
