package com.anas.discountCalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
String op;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            clearAll();
        }

        return super.onOptionsItemSelected(item);
    }

    public void clearAll()
    {
        final TextView Result = (TextView) findViewById(R.id.Result);
        Result.setText("0");
        final EditText Num1 = (EditText) findViewById(R.id.Number1);
        Num1.setText("");
        final EditText Num2 = (EditText) findViewById(R.id.Number2);
        Num2.setText("");
    }

    public static String format(Number n) {
        NumberFormat format = DecimalFormat.getInstance();
        format.setRoundingMode(RoundingMode.FLOOR);
        format.setMinimumFractionDigits(0);
        format.setMaximumFractionDigits(2);
        return format.format(n);
    }

    /** Called when the user clicks the Send button */
    public void sendMessage(View view) {
        EditText Num1 = (EditText) findViewById(R.id.Number1);
        EditText Num2 = (EditText) findViewById(R.id.Number2);

        String message1 = Num1.getText().toString();
        String message2 = Num2.getText().toString();

        float num1,num2,num3=0;

        try {
            num1 = Float.parseFloat(Num1.getText().toString());
            num2 = Float.parseFloat(Num2.getText().toString());
            num3 = (num1 - ((num2/100)*num1));

        } catch(NumberFormatException nfe) {
            Toast.makeText(this, "Invalid Number..." , Toast.LENGTH_SHORT).show();
        }

        //Change Textview Dynamically
            final TextView mTextView = (TextView) findViewById(R.id.Result);
            mTextView.setText(format(num3));
    }
}
