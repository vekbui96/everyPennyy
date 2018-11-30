package com.tom123my.everypennyy;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;

public class budgetSet extends AppCompatActivity {

    //Varibles
    private EditText income;
    private EditText living;
    private EditText savings;

    //On Create
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budget_set);

        setupEndActivityButton();
    }

    //Button Setup
    private void setupEndActivityButton() {
        Button submit = (Button) findViewById(R.id.submitExpenses);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ifempty();
            }
        });
    }

    //Checks if numbers are entered, then passes numbers back to Main Activity
    private void ifempty(){
        income = (EditText)findViewById(R.id.incomeInput);
        living = (EditText)findViewById(R.id.livingExpenses);
        savings = (EditText)findViewById(R.id.savingGoals);

        int tempIncome = Integer.parseInt(income.getText().toString());
        int tempLiving = Integer.parseInt(living.getText().toString());
        int tempSavings = Integer.parseInt(savings.getText().toString());

        if((income.getText().toString().equals("")) || (living.getText().toString().equals("")) || (savings.getText().toString().equals(""))){
            System.out.println("Nothing Entered");
        } else {
            Intent resultIntent = new Intent();
            resultIntent.putExtra("income", tempIncome);
            resultIntent.putExtra("living", tempLiving);
            resultIntent.putExtra("savings", tempSavings);

            setResult(RESULT_OK, resultIntent);
            finish();
        }
    }

}
