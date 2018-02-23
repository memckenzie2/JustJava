
/**
 * IMPORTANT: Make sure you are using the correct package name.
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/

 package com.example.android.justjava;


import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int quantity = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        CheckBox whipped = (CheckBox) findViewById(R.id.whipped);
        boolean whipCheck = whipped.isChecked();
        CheckBox choc = (CheckBox) findViewById(R.id.choc);
        boolean chocCheck = choc.isChecked();
        EditText nameID = findViewById(R.id.name);
        Editable name = nameID.getText();
        int calcPrice = calculatePrice(whipCheck, chocCheck);
        String priceMessage = createOrderSummary(name, calcPrice, whipCheck, chocCheck);
        displayMessage(priceMessage);
    }

    public void increment(View view) {
        if (quantity < 100){
            quantity = quantity + 1;
            displayQuantity(quantity);
        } else{
            Toast.makeText(this, "You cannot have more than 100 coffees", Toast.LENGTH_SHORT).show();
        }

    }

    public void decrement(View view) {
        if (quantity > 1){
            quantity = quantity - 1;
            displayQuantity(quantity);
        } else{
            Toast.makeText(this, "You cannot have less than 1 coffee", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int quantity) {
        TextView quantityTextView = findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + quantity);
    }

    /**
     * This method displays the given price on the screen.
     *  private void displayPrice(int number) {
     TextView orderSummaryTextView = findViewById(R.id.order_summary_text_view);
     orderSummaryTextView.setText(NumberFormat.getCurrencyInstance().format(number));
     }
     */

    /**
     * This method displays the given text on the screen.
     * */
     private void displayMessage(String message) {
     TextView priceTextView = (TextView) findViewById(R.id.order_summary_text_view);
     priceTextView.setText(message);
     }




    /**
     * Calculates the price of the order.
     *
     * @param quantity is the number of cups of coffee ordered
     * @return total price
     */
    private int calculatePrice(boolean addWhip, boolean addChoc) {
        int base = 5;
        int choc = 2;
        int whip = 1;

        if(addWhip){
            base = base+ whip;
        }
        if(addChoc){
            base = base+ choc;
        }
        int price = quantity * base;
        return price;
    }

    /**
     * Calculates the price of the order.
     *
     * @param price is the number of cups of coffee ordered
     * @return message with order summary
     */
    private String createOrderSummary(Editable name, int price, boolean whipCheck, boolean chocCheck) {
        String priceMessage = "Name:" + name+ "\nWhipped Cream: " + whipCheck + "\nChocolate: " + chocCheck + "\nQuantity: " + quantity + "\nTotal: $" + price + "\nThank You!";
        return priceMessage;
    }

}