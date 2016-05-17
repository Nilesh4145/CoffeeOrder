package nilesh4145.justjava;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */

public class MainActivity extends AppCompatActivity {
    int quantity;
    int price;
    int pricePerCup=10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This Method is used to calculate the price.
     */
    private int calculatePrice(int quantity, int pricePerCup){
        int price= quantity*pricePerCup;
        return price;
    }
    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view){
        //String priceMessage= "Total : $ " + price + "\nThank You!";
        //display(quantity);
        int price=calculatePrice(quantity, pricePerCup);
        String priceMessage=createOrderSummary(price);
        displayMessage(priceMessage);
    }

    private String createOrderSummary(int price){
        String summary="You have ordered " +quantity+" cups of coffee!\nYour total payable amount " +
                "would be " + price + "\nThank You!";
        return summary;
    }

    /**
     * This method is called when + button is clicked.
     */
    public void decrement(View view){
        if(quantity==0){
            display(0);
        }
        else{
            quantity-=1;
            display(quantity);
        }
    }

    /**
     * This method is called when - button is clicked.
     */
    public void increment(View view){
        quantity+=1;
        display(quantity);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText(""+number);
    }
    /**
     * This method dislays the given quantity value on the screen.
     */
    private void displayPrice(int number) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message){
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }
}