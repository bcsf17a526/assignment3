package com.example.anav;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Cal extends AppCompatActivity {

    private Button add;
    private Button sub;
    private Button mul;
    private Button div;
    private EditText num1;
    private EditText num2;
    private TextView answer;

    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cal);
        drawerLayout=findViewById(R.id.drawer_layout);
        add=findViewById(R.id.add);
        sub=findViewById(R.id.sub);
        mul=findViewById(R.id.mul);
        div=findViewById(R.id.div);
        num1=findViewById(R.id.numb1);
        num2=findViewById(R.id.numb2);
        answer=findViewById(R.id.answer);


        add.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                try {
                    Double value1 = Double.parseDouble(num1.getText().toString());
                    Double value2 = Double.parseDouble(num2.getText().toString());

                    double sum = value1 + value2;
                    answer.setText("Your answer is :" + (sum));
                } catch (NumberFormatException e) {
                    answer.setText("YOU ENTERED INVALID NUMBER");
                }


            }


        });





        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    Double value1 = Double.parseDouble(num1.getText().toString());
                    Double value2 = Double.parseDouble(num2.getText().toString());

                    double sub = value1 - value2;
                    answer.setText("Your answer is :" + (sub));
                } catch (NumberFormatException e) {
                    answer.setText("YOU ENTERED INVALID NUMBER");
                }


            }
        });



        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    Double value1 = Double.parseDouble(num1.getText().toString());
                    Double value2 = Double.parseDouble(num2.getText().toString());

                    double mul = value1 * value2;
                    answer.setText("Your answer is :" + (mul));
                } catch (NumberFormatException e) {
                    answer.setText("YOU ENTERED INVALID NUMBER");
                }


            }
        });




        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    Double value1 = Double.parseDouble(num1.getText().toString());
                    Double value2 = Double.parseDouble(num2.getText().toString());

                    double div = value1 / value2;
                    answer.setText("Your answer is :" + (div));
                } catch (NumberFormatException e) {
                    answer.setText("YOU ENTERED INVALID NUMBER");
                }


            }
        });










    }




    public void Menu(View view){

        MainActivity.openDrawer(drawerLayout);
    }


    public void ClickCal(View view){
        recreate();
    }
    public void ClickQuiz(View view){
        MainActivity.redirectActivity(this,Quiz.class);
    }

    @Override
    protected void onPause() {
        super.onPause();

        MainActivity.closeDrawer(drawerLayout);
    }


}