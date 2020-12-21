package com.example.anav;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.anav.MainActivity.openDrawer;
//public class Quiz extends AppCompatActivity{
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_quiz);}
//
//}
public class Quiz extends AppCompatActivity implements View.OnClickListener {
    private Button falseButton;
    private Button trueButton;
    private ImageButton nextButton;
    private ImageButton prevButton;
    private TextView questionTextView;

    DrawerLayout drawerLayout;

    private int currentQuestionIndex = 0;

    private Question[] questionBank = new Question[]{
            new Question(R.string.question_1, true), //correct: 27
            new Question(R.string.question_2, true),
            new Question(R.string.question_3, false),
            new Question(R.string.question_4, true),
            new Question(R.string.question_5, false),


    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);


        falseButton = findViewById(R.id.false_button);
        trueButton = findViewById(R.id.true_button);
        nextButton = findViewById(R.id.next_button);
        prevButton = findViewById(R.id.prev_button);
        questionTextView = findViewById(R.id.answer_text_view);

        drawerLayout=findViewById(R.id.drawer_layout);

        falseButton.setOnClickListener(this); //register our buttons to listen to click events
        trueButton.setOnClickListener(this);
        nextButton.setOnClickListener(this);
        prevButton.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.false_button:
                checkAnswer(false);
                break;

            case R.id.true_button:
                checkAnswer(true);
                break;

            case R.id.next_button:
                //go to next question
                currentQuestionIndex = (currentQuestionIndex + 1) % questionBank.length; // we are safe now!
                updateQuestion();
                break;
            case R.id.prev_button:
                if (currentQuestionIndex > 0) {
                    currentQuestionIndex = (currentQuestionIndex - 1) % questionBank.length;
                    updateQuestion();
                }


        }

    }

    private void updateQuestion() {
        Log.d("Current", "onClick: " + currentQuestionIndex);
        questionTextView.setText(questionBank[currentQuestionIndex].getAnswerResId());
    }

    private void checkAnswer(boolean userChooseCorrect) {
        boolean answerIsTrue = questionBank[currentQuestionIndex].isAnswerTrue();
        int toastMessageId;

        if (userChooseCorrect == answerIsTrue) {
            toastMessageId = R.string.correct_answer;
        } else {
            toastMessageId = R.string.wrong_answer;
        }

        Toast.makeText(Quiz.this, toastMessageId,
                Toast.LENGTH_SHORT)
                .show();

    }

    public void Menu(View view){

        MainActivity.openDrawer(drawerLayout);
    }


    public void ClickCal(View view){
        MainActivity.redirectActivity(this,Cal.class);

    }
    public void ClickQuiz(View view){
        recreate();
    }

    @Override
    protected void onPause() {
        super.onPause();

        MainActivity.closeDrawer(drawerLayout);
    }


}