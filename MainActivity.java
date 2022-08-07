package com.wish.contractorcalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    //Declare the views used
    //declare the button
    Button btnCalculate;
    //declare the textViews
    TextView textViewSubTotal,textViewTax,textViewTotal;
    //EditText used
    EditText editTextLabour;
    EditText editTextMatCost;
    //to store labour
    int labour;
    //to store material cost
    int matCost;
    //to store subTotal
    double subTotal;
    //to store tax
    double tax;
    //to store total
    double total;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //reference to the views
        btnCalculate = findViewById(R.id.btnCalculate);
        textViewSubTotal = findViewById(R.id.textViewSubTotal);
        textViewTotal = findViewById(R.id.textViewTotal);
        textViewTax = findViewById(R.id.textViewTax);
        editTextLabour = findViewById(R.id.editTextLabour);
        editTextMatCost  =findViewById(R.id.editTextMatCost);

        //handle the button click
        btnCalculate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //when the button is clicked
                //read the input values from edit text
                if(!editTextLabour.getText().toString().isEmpty()&&
                        !editTextMatCost.getText().toString().isEmpty()){
                    //if inputs are valid
                    //read labour value
                    labour = Integer.parseInt(editTextLabour.getText().toString());
                    //read material cost
                    matCost = Integer.parseInt(editTextMatCost.getText().toString());
                    //calculate sub total
                    subTotal = labour + matCost;
                    //calculate tax
                    tax = (subTotal/100)*5;
                    //calculate total
                    total = subTotal + tax;
                    //set the output to text views
                    textViewSubTotal.setText(String.valueOf(subTotal));
                    textViewTax.setText(String.valueOf(tax));
                    textViewTotal.setText(String.valueOf(total));

                }else{
                    //not valid input
                    Toast.makeText(MainActivity.this, "Enter valid input.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
