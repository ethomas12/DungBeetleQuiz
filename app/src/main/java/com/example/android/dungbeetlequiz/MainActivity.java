package com.example.android.dungbeetlequiz;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View.OnClickListener;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    int sumFalse = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    // ************ Question 1 ************* //
        ImageButton imageButton1 = findViewById(R.id.europe_pic); //europe
        imageButton1.setOnClickListener(this);

        ImageButton imageButton2 = findViewById(R.id.antarctica_pic); //antarctica
        imageButton2.setOnClickListener(this);

        ImageButton imageButton3 = findViewById(R.id.na_pic); //north america
        imageButton3.setOnClickListener(this);

        ImageButton imageButton4 = findViewById(R.id.australia_pic); //australia
        imageButton4.setOnClickListener(this);
    }

        //implement the onClick method here
        public void onClick(View v) {
            // Perform action on click
            switch(v.getId()) {

                case R.id.europe_pic:
                    //Make Toast
                    Toast.makeText(getApplicationContext(), "Try again",
                            Toast.LENGTH_SHORT).show();
                    break;
                case R.id.antarctica_pic:
                    Toast.makeText(getApplicationContext(), "That's right!",
                            Toast.LENGTH_SHORT).show();

                    //show answer
                    TextView answer1TextView = findViewById(R.id.answer_1);
                    answer1TextView.setText(R.string.fact_1);
                    break;
                case R.id.na_pic:
                    Toast.makeText(getApplicationContext(), "Not quite",
                            Toast.LENGTH_SHORT).show();
                    break;
                case R.id.australia_pic:
                    Toast.makeText(getApplicationContext(), "Nope",
                            Toast.LENGTH_SHORT).show();
                    break;

            }
        }


    public int submitScore(View view) {

        // ************ Question 2 ************* //
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

        if (!isTunnelers | !isDwellers | !isRollers) {
            sumFalse += 1;
        }

        else if (isBuilders || isPoopers) {
            sumFalse += 1;
        }

        // ************ Question 3 ************* //
        RadioButton checkbox3a = findViewById(R.id.true_radio_button);
        boolean isTrue_3 = checkbox3a.isChecked();

        RadioButton checkBox3b = findViewById(R.id.false_radio_button);
        boolean isFalse_3 = checkBox3b.isChecked();


        if (isTrue_3 | !isFalse_3) {
            sumFalse += 1;
        }

        // ************ Question 5 ************* //
        RadioButton checkbox5a = findViewById(R.id.babies_adults_radio_button);
        boolean isTrue_5 = checkbox5a.isChecked();

        RadioButton checkBox5b = findViewById(R.id.adults_babies_radio_button);
        boolean isFalse_5 = checkBox5b.isChecked();

        if (isFalse_5 || !isTrue_5) {
            sumFalse += 1;
        }


        // ************ Question 6 ************* //

        CheckBox checkbox6a = findViewById(R.id.checkbox_6_a);
        boolean isCandles = checkbox6a.isChecked();

        CheckBox checkBox6b = findViewById(R.id.checkbox_6_b);
        boolean isEat = checkBox6b.isChecked();

        CheckBox checkbox6c = findViewById(R.id.checkbox_6_c);
        boolean isSnake = checkbox6c.isChecked();

        CheckBox checkbox6d = findViewById(R.id.checkbox_6_d);
        boolean isLive = checkbox6d.isChecked();

        CheckBox checkbox6e = findViewById(R.id.checkbox_6_e);
        boolean isMarbles = checkbox6e.isChecked();

        if (!isEat | !isLive) {

            sumFalse += 1;

        } else if (isCandles || isSnake || isMarbles) {

            sumFalse += 1;
        }

        //************* Calculate score ************//

        int startScore = 6;

        int finalScore = startScore - sumFalse;

        TextView quantityTextView = findViewById(R.id.final_score_message);
        quantityTextView.setText("You got " + finalScore + " out of " + startScore + " correct!");

        return finalScore;
    }

    //  Question 2 checkboxes
    public void checkBtn2(View view) {
        TextView answer2TextView = findViewById(R.id.answer_2);
        answer2TextView.setText(R.string.fact_2);
    }

    //  Question 3 true / false
    public void checkBtn3(View view) {
        TextView answer3TextView = findViewById(R.id.answer_3);
        answer3TextView.setText(R.string.fact_3);
    }

    // Question 4 fill in the blank
    public void checkBtn4(View view) {
        TextView answer4TextView = findViewById(R.id.answer_4);
        answer4TextView.setText(R.string.fact_4);
    }

    // Question 5  choose A/B
    public void checkBtn5(View view) {
        TextView answer5TextView = findViewById(R.id.answer_5);
        answer5TextView.setText(R.string.fact_5);
    }

    //  Question 6 checkboxes
    public void checkBtn6(View view) {
        TextView answer6TextView = findViewById(R.id.answer_6);
        answer6TextView.setText(R.string.fact_6);
    }
}