package com.tom123my.everypennyy;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class homescreen extends AppCompatActivity {

    //Varibles Setup
    public static final int REQUEST_CODE = 1024;
    private EditText spendingLabel;
    private Button budgetButton;
    private Button submitButton;
    private TextView mIncome;

    public int i = 1000;
    private int spendingAmount;

    private int income;
    private int savigns;
    private int living;
    private int leasureMoney;


    //On Create Setup
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homescreen);

        //Setting up Labels and Buttons
        budgetButton = (Button) findViewById(R.id.spendingButton);
        submitButton = (Button) findViewById(R.id.submit);

        spendingLabel = (EditText)findViewById(R.id.spendingAmount);

        mIncome = findViewById(R.id.incomeLab);


        budgetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBudgetScreen();
            }
        });

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                subtractFromBudget();
            }
        });


    }

    //Button Functions

    public void openBudgetScreen(){
        Intent intent = new Intent(this, budgetSet.class);
        startActivityForResult(intent, 1);
    }

    public void subtractFromBudget(){
        spendingAmount = Integer.parseInt(spendingLabel.getText().toString());
        leasureMoney = leasureMoney - spendingAmount;

        mIncome.setText(""+(leasureMoney));
    }

    //Getting Data back from Activity Budget
    @Override
    protected void onActivityResult(int requestcode, int resultcode, Intent data){
        super.onActivityResult(requestcode, resultcode, data);

        if (requestcode == 1){
            if (resultcode == RESULT_OK) {
                income = data.getIntExtra("income",0);
                savigns = data.getIntExtra("savings",0);
                living = data.getIntExtra("living", 0);
                leasureMoney = income-savigns-living;

                mIncome.setText(""+(leasureMoney));
            }
        }
    }
}
