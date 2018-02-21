package com.example.android.dungbeetlequiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View.OnClickListener;


public class MainActivity extends AppCompatActivity {

    ImageButton imageButton1; //europe
    ImageButton imageButton2; //antarctica
    ImageButton imageButton3; //north america
    ImageButton imageButton4; //australia

    int sumFalse = 0;
    int startScore = 6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkBtn1();

    }

    //  Question 1 Image Button
    public void checkBtn1() {

        imageButton1 = findViewById(R.id.europe_pic);
        imageButton2 = findViewById(R.id.antarctica_pic);
        imageButton3 = findViewById(R.id.na_pic);
        imageButton4 = findViewById(R.id.australia_pic);

        //        Begin methods

        imageButton2.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View view) {

                Toast.makeText(getApplicationContext(), "That's right!",
                        Toast.LENGTH_SHORT).show();

                TextView answer1TextView = findViewById(R.id.answer_1);
                answer1TextView.setText(R.string.fact_1);
            }
        });

        imageButton1.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Try again",
                        Toast.LENGTH_SHORT).show();
            }
        });

        imageButton3.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Not quite",
                        Toast.LENGTH_SHORT).show();
            }
        });

        imageButton4.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Nope",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    //  Question 2 checkboxes
    public void checkBtn2(View view) {
        CheckBox checkbox2a = findViewById(R.id.checkbox_2_a);
        boolean isBuilders = checkbox2a.isChecked();

        CheckBox checkBox2b = findViewById(R.id.checkbox_2_b);
        boolean isTunnelers = checkBox2b.isChecked();

        CheckBox checkbox2c = findViewById(R.id.checkbox_2_c);
        boolean isRollers = checkbox2c.isChecked();

        CheckBox checkbox2d = findViewById(R.id.checkbox_2_d);
        boolean isDwellers = checkbox2d.isChecked();

        CheckBox checkbox2e = findViewById(R.id.checkbox_2_e);
        boolean isPoopers = checkbox2e.isChecked();

        if (!isTunnelers || !isDwellers || !isRollers) {
            sumFalse += 1;
        }

        TextView answer2TextView = findViewById(R.id.answer_2);
        answer2TextView.setText(R.string.fact_2);

    }

    //  Question 3 checkboxes
    public void checkBtn3(View view) {

        RadioButton checkbox3a = findViewById(R.id.true_radio_button);
        boolean isTrue_3 = checkbox3a.isChecked();

        RadioButton checkBox3b = findViewById(R.id.false_radio_button);
        boolean isFalse_3 = checkBox3b.isChecked();

        if (isTrue_3) {
            sumFalse = +1;
            Toast.makeText(getApplicationContext(), "Not quite",
                    Toast.LENGTH_SHORT).show();

        } else if (isFalse_3) {
            sumFalse += 0;
            Toast.makeText(getApplicationContext(), "That's right!",
                    Toast.LENGTH_SHORT).show();
        }

        TextView answer3TextView = findViewById(R.id.answer_3);
        answer3TextView.setText(R.string.fact_3);
        Log.v("MainActivity", "After Q3 sumFalse equals =  " + sumFalse);

    }


    // Question 4 fill in the blank
    public void checkBtn4(View view) {
        TextView answer4TextView = findViewById(R.id.answer_4);
        answer4TextView.setText(R.string.fact_4);

    }

    // Question 5 fill in the blank
    public void checkBtn5(View view) {

        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {

            case R.id.babies_adults_radio_button:
                if (checked)
                    Toast.makeText(getApplicationContext(), "That's right!",
                            Toast.LENGTH_SHORT).show();
                    break;

            case R.id.adults_babies_radio_button:
                if (checked)
                    Toast.makeText(getApplicationContext(), "Not quite",
                            Toast.LENGTH_SHORT).show();
                    sumFalse += 1;
                    break;
        }

    }

    public void checkBtn5a(View view) {
        TextView answer5TextView = findViewById(R.id.answer_5);
        answer5TextView.setText(R.string.fact_5);
    }

    //  Question 6 checkboxes
    public void checkBtn6(View view) {
        TextView answer6TextView = findViewById(R.id.answer_6);
        answer6TextView.setText(R.string.fact_6);

//        CheckBox checkbox6a = findViewById(R.id.checkbox_6_a);
//        boolean isCandles = checkbox6a.isChecked();

        CheckBox checkBox6b = findViewById(R.id.checkbox_6_b);
        boolean isEat = checkBox6b.isChecked();

//        CheckBox checkbox6c = findViewById(R.id.checkbox_6_c);
//        boolean isSnake = checkbox6c.isChecked();

        CheckBox checkbox6d = findViewById(R.id.checkbox_6_d);
        boolean isLive = checkbox6d.isChecked();

//        CheckBox checkbox6e = findViewById(R.id.checkbox_6_e);
//        boolean isMarbles = checkbox6e.isChecked();

        if (!isEat || !isLive) {
            Toast.makeText(getApplicationContext(), "Not quite",
                    Toast.LENGTH_SHORT).show();
            sumFalse += 1;
        } else {
            Toast.makeText(getApplicationContext(), "That's right",
                    Toast.LENGTH_SHORT).show();
        }
    }

    public int submitScore(View view) {
        int finalScore = startScore - sumFalse;

        TextView quantityTextView = findViewById(R.id.final_score_message);
        quantityTextView.setText("You got " + finalScore + " out of " + startScore + " correct!");

        return finalScore;
    }

}
