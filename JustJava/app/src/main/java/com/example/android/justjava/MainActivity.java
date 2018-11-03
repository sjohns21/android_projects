
package com.example.android.justjava;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
//import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    int quantity = 2;

    /**
     * This method is called when the plus button is clicked.
     */
    public void increment(View view) {
        if (quantity != 99){
            quantity++;
        }
        displayQuantity(quantity);
    }
    /**
     * This method is called when the minus button is clicked.
     */
    public void decrement(View view) {
        if (quantity != 1){
            quantity--;
        }
        else {
            Toast.makeText(getApplicationContext(),"No smaller than 1!", Toast.LENGTH_LONG).show();
        }
        displayQuantity(quantity);
    }
    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int num) {
        String displayNum = String.valueOf(num);
        TextView quantityTextView = findViewById(R.id.quantity_text_view);
        quantityTextView.setText(displayNum);
    }
    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        Log.i("intent","click");
        EditText nameEditText = findViewById(R.id.name_edit_text);
        String name = nameEditText.getText().toString();
        CheckBox whippedCreamCheckBox = findViewById(R.id.whipped_cream_check_box);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();
        CheckBox chocolateCheckBox = findViewById(R.id.chocolate_check_box);
        boolean hasChocolate = chocolateCheckBox.isChecked();
        int price = calculatePrice(hasWhippedCream,hasChocolate);
        composeEmail(name, createOrderSummary(name, hasWhippedCream, hasChocolate, price));
        //displayMessage(createOrderSummary(name, hasWhippedCream, hasChocolate, price));

    }
    public void composeEmail(String name, String text) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        //intent.putExtra(Intent.EXTRA_EMAIL, emails);
        intent.putExtra(Intent.EXTRA_SUBJECT,"Just Java Order for " + name);
        intent.putExtra(Intent.EXTRA_TEXT, text);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
    private int calculatePrice(boolean hasWhippedCream, boolean hasChocolate) {
        int unitCost = 5;
        if (hasWhippedCream) {
            unitCost += 1;
        }
        if (hasChocolate) {
            unitCost += 2;
        }
        return unitCost * quantity;
    }
    private String createOrderSummary (String name, boolean hasWhippedCream, boolean hasChocolate, int price) {
        String orderSummary = "";
        orderSummary += "Name: " + name;
        orderSummary += "\nAdd whipped cream? " + hasWhippedCream;
        orderSummary += "\nAdd chocolate? " + hasChocolate;
        orderSummary += "\nQuantity: " + quantity;
        orderSummary += "\nPrice: $" + price;
        orderSummary += "\nThank You!";
        return orderSummary;
    }
    /**
     * This method displays the given text on the screen.
     */
/*    private void displayMessage(String message) {
        TextView orderSummaryTextView = findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }*/

}