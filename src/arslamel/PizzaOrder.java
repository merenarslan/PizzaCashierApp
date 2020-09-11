/*
    CSS.css
    Author: Melih Eren Arslan
    Date: 07.31.2020

    Description
    PizzaOrder class has toString method and ArrayList.
 
    @author Melih Eren Arslan
 */
package arslamel;

import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Toppings class has 6 constant variables.
 *
 * @author melih
 */
public class PizzaOrder {

    private static final double HST = 0.13;
    private PizzaSize size;
    private ArrayList<Toppings> toppings = new ArrayList<>();
    private Drinks drinks;
    private int numPizza;
    private int numDrinks;

    /**
     * PizzaOrder class has an empty constructor
     */
    public PizzaOrder() {

    }

    /**
     * this method is checking if the topping arraylist is empty
     *
     * @return
     */
    public boolean isToppingsEmpty() {
        return toppings.isEmpty();
    }

    /**
     * set the size of the pizza
     *
     * @param size of the pizza
     */
    public void setSize(PizzaSize size) {
        this.size = size;
    }

    /**
     * this method adds items into arraylist
     *
     * @param topping
     */
    public void addTopping(Toppings topping) {
        this.toppings.add(topping);
    }

    /**
     * this method sets the size of the drink
     *
     * @param drinks
     */
    public void setDrinks(Drinks drinks) {
        this.drinks = drinks;
    }

    /**
     * this methods set the number of pizza
     *
     * @param numPizza
     * @throws IllegalArgumentException
     */
    public void setNumPizza(int numPizza) throws IllegalArgumentException {
        if (numPizza >= 0) {
            this.numPizza = numPizza;
        } else {
            throw new IllegalArgumentException("Error: The number of pizza can not be negative number");
        }

    }

    /**
     * this method sets the number of drink
     *
     * @param numDrinks
     * @throws IllegalArgumentException
     */
    public void setNumDrinks(int numDrinks) throws IllegalArgumentException {
        if (numDrinks >= 0) {
            this.numDrinks = numDrinks;
        } else {
            throw new IllegalArgumentException("Error: The number of drink can not be negative number");
        }

        /**
         * return numPizza toppings.toString()
         */
    }

    public String returnToppings() {
        String toppi = "\n";
        for (Toppings top : toppings) {
            toppi += "\t" + numPizza + "  " + top.toString() + "\n";
        }
        return toppi;
    }

    /**
     * this methods returns total price of the toppings
     *
     * @return the total price of toppings
     */
    public double calculateToppings() {
        double topTotal = 0;
        for (Toppings top : toppings) {
            topTotal += top.getPrice();
        }
        return topTotal * numPizza;
    }

    /**
     * this method remove all the toppings' arraylist.
     */
    public void removeToppings() {
        toppings.removeAll(toppings);

    }

    /**
     * this method clears the toppings' arraylist.
     */
    public void clearArrayList() {
        toppings.clear();
    }

    /**
     * this method calculate the total bill
     *
     * @return subtotal,tax,total
     */
    public String totalBill() {
        double subTotal = 0;
        if (size == null) {
            subTotal = (drinks.getPrice() * numDrinks) + calculateToppings();
        } else if (drinks == null) {
            subTotal = (size.getPrice() * numPizza) + calculateToppings();
        } else {
            subTotal = ((size.getPrice() * numPizza) + (drinks.getPrice() * numDrinks) + calculateToppings());
        }
        double tax = HST * subTotal;
        double total = tax + subTotal;
        return String.format("\n=============================\nSubtotal:\t\t\t\t\t%.2f\nHST:\t\t\t\t\t\t%2.2f\nTotal:\t\t\t\t\t%.2f", subTotal, tax, total);
    }

    /**
     *
     * @return
     */
    public String toString() {
        if (size == null && drinks == null) {

            return "Please choose at least drink or pizza";
        }

        if (size == null && numPizza >= 0) {
            return "Drinks:\t\t\t\t\t" + drinks.getPrice() * numDrinks
                    + "\n\t" + numDrinks + "  " + drinks.toString()
                    + totalBill();
        } else if (drinks == null && numDrinks >= 0) {
            return String.format("Pizza:\t\t\t\t\t%.2f", size.getPrice() * numPizza)
                    + "\n\t" + numPizza + "  " + size.toString()
                    + "\nToppings:\t\t\t\t\t" + (calculateToppings() + returnToppings())
                    + totalBill();

        }
        return "Pizza:\t\t\t\t\t" + size.getPrice() * numPizza
                + "\n\t" + numPizza + "  " + size.toString()
                + "\nToppings:\t\t\t\t\t" + calculateToppings() + returnToppings()
                + "\nDrinks:\t\t\t\t\t" + drinks.getPrice() * numDrinks
                + "\n\t" + numDrinks + "  " + drinks.toString()
                + totalBill();

    }

}
