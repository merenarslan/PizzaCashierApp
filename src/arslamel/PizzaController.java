/*
    CSS.css
    Author: Melih Eren Arslan
    Date: 07.31.2020

    Description
    Control class has buttons and fx:ids.
 
    @author Melih Eren Arslan
 */
package arslamel;

import arslamel.PizzaOrder;
import java.awt.BorderLayout;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

/**
 * FXML Controller class
 *
 * @author melih
 */
public class PizzaController implements Initializable {

    @FXML
    private Insets nodeMargins;
    @FXML
    private ToggleGroup grpSelection;
    @FXML
    private ToggleGroup grpSelection2;
    @FXML
    private Label lblSize;
    @FXML
    private RadioButton optSmall;
    @FXML
    private RadioButton optMedium;
    @FXML
    private RadioButton optLarge;
    @FXML
    private Button btnCancel;
    @FXML
    private Label lblToppings;
    @FXML
    private CheckBox chkCheese;
    @FXML
    private CheckBox chkPepperoni;
    @FXML
    private Label lblOrdered;
    @FXML
    private TextArea txaItems;
    @FXML
    private Label lblDrinsk;
    @FXML
    private RadioButton optCoke;
    @FXML
    private RadioButton optJuice;
    @FXML
    private RadioButton optMilk;
    @FXML
    private Button btnOk;
    @FXML
    private TextField txfNOfPizza;
    @FXML
    private TextField txfNOfDrink;

    private PizzaOrder order = new PizzaOrder();
    @FXML
    private CheckBox chkMushrooms;
    @FXML
    private CheckBox chkOlives;
    @FXML
    private Menu mMain;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void order(ActionEvent event) {
        //Checking for selections
        //Setting variables for the pizza order
        boolean inputValid = true;

        /**
         * this methods finds out if the user selected at least one pizza size,
         * and throw exception according to algorithm
         */
        try {
            if (optSmall.isSelected() == true || optMedium.isSelected() == true || optLarge.isSelected() == true) {
                if (optSmall.isSelected() == true) {
                    order.setSize(PizzaSize.SMALL);
                }
                if (optMedium.isSelected() == true) {
                    order.setSize(PizzaSize.MEDIUM);
                }
                if (optLarge.isSelected() == true) {
                    order.setSize(PizzaSize.LARGE);
                }

                if (txfNOfPizza.getText().trim().isEmpty()) {
                    txaItems.setText("Error: Please enter the number of pizza");
                    inputValid = false;
                } else {
                    order.setNumPizza(Integer.parseInt(txfNOfPizza.getText()));
                    inputValid = true;

                }

            }
        } catch (NumberFormatException ex) {
            txaItems.setText("Error: Number of pizza must be a number!");
            inputValid = false;

        } catch (IllegalArgumentException e) {
            txaItems.setText(e.getMessage());
            inputValid = false;

        }

        /**
         * this methods finds out if the user chooses at least one drink and
         * throws exception according to algorithm
         */
        try {
            if (optJuice.isSelected() == true || optCoke.isSelected() == true || optMilk.isSelected() == true) {
                if (optJuice.isSelected() == true) {
                    order.setDrinks(Drinks.JUICE);
                } else if (optCoke.isSelected() == true) {
                    order.setDrinks(Drinks.COKE);
                } else if (optMilk.isSelected() == true) {
                    order.setDrinks(Drinks.CHOCOLATE_MILK);
                } else {
                    order.setNumDrinks(0);
                }
                if (txfNOfDrink.getText().trim().isEmpty()) {
                    txaItems.setText("Error: Please enter the number of drinks");
                    inputValid = false;

                } else {
                    order.setNumDrinks(Integer.parseInt(txfNOfDrink.getText()));
                    inputValid = true;
                }
            }

        } catch (NumberFormatException ex) {
            txaItems.setText("Error: Number of drink must be a number!");
            inputValid = false;

        } catch (IllegalArgumentException e) {
            txaItems.setText(e.getMessage());
            inputValid = false;

        }

        /**
         * this method finds out if they choose any of the toppings.
         */
        if (chkCheese.isSelected() == true || chkPepperoni.isSelected() || true && chkMushrooms.isSelected() || true
                && chkOlives.isSelected() == true) {

            if (chkCheese.isSelected() == true) {
                order.addTopping(Toppings.CHEESE);
                inputValid = true;

            }
            if (chkPepperoni.isSelected() == true) {
                order.addTopping(Toppings.PEPPERONI);
                inputValid = true;

            }
            if (chkMushrooms.isSelected() == true) {
                order.addTopping(Toppings.MUSHROOMS);
                inputValid = true;

            }

            if (chkOlives.isSelected() == true) {
                order.addTopping(Toppings.OLIVES);
                inputValid = true;

            }
        }

        /**
         * this methods check if the users choose at least one option.
         */
        if (optJuice.isSelected() == false && optCoke.isSelected() == false
                && optMilk.isSelected() == false && optSmall.isSelected() == false && optMedium.isSelected() == false && optLarge.isSelected() == false
                && chkCheese.isSelected() == false && chkPepperoni.isSelected() == false && chkMushrooms.isSelected() == false && chkOlives.isSelected() == false) {
            txaItems.setText("You need to choose at least one drink or pizza");
        }

        /**
         * this method runs the show method
         */
        if (inputValid) {
            show();
        }
    }

    /**
     * show button runs order.toString() method and clear the arraylist to
     * prevent toppings to add two times
     */
    private void show() {
        txaItems.setText(order.toString());
        order.clearArrayList();

    }

    @FXML
    private void clear(ActionEvent event) {
        txaItems.clear();
        txfNOfDrink.clear();
        txfNOfPizza.clear();
        chkOlives.setSelected(false);
        chkMushrooms.setSelected(false);
        chkPepperoni.setSelected(false);
        chkCheese.setSelected(false);
        optMilk.setSelected(false);
        optCoke.setSelected(false);
        optJuice.setSelected(false);
        optSmall.setSelected(false);
        optLarge.setSelected(false);
        optMedium.setSelected(false);
        order.setDrinks(null);
        order.setSize(null);
        order.removeToppings();
        order.setNumPizza(0);
        order.setNumDrinks(0);

    }

    @FXML
    private void exit(ActionEvent event) {
        System.exit(0);
    }

}
