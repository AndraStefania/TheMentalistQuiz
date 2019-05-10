package com.example.android.thementalistquiz;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.thementalistquiz.R;


public class MainActivity extends AppCompatActivity {

    /**
     * Variables.
     */

    EditText nameField;
    RadioButton secondanswer2;
    RadioButton fourthanswer3;
    RadioButton secondanswer4;
    RadioButton fourthanswer5;
    CheckBox thirdanswer6;
    CheckBox fourthanswer6;

    private int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameField = findViewById(R.id.answer1);

        secondanswer2 = findViewById(R.id.secondanswer2);
        fourthanswer3 = findViewById(R.id.fourthanswer3);
        secondanswer4 = findViewById(R.id.secondanswer4);
        fourthanswer5 = findViewById(R.id.fourthanswer5);
        thirdanswer6 = findViewById(R.id.thirdanswer6);
        fourthanswer6 = findViewById(R.id.fourthanswer6);
    }

    /**
     * This method calculates score.
     */
    private void calculateScore() {

        /**
         * The first question is correct if the answer is 7 and 1 point is added.
         */
        String seasons = nameField.getText().toString().trim();

        score = 0;

        if (seasons.equalsIgnoreCase("7")) {
            score += 1;
        } else {
            score += 0;
        }

        /**
         *  Correct RadioButtons and CheckBoxes answers are pressed and stored in a boolean variable.
         */

        boolean isSecondAnswer2 = secondanswer2.isChecked();
        boolean isFourthAnswer3 = fourthanswer3.isChecked();
        boolean isSecondAnswer4 = secondanswer4.isChecked();
        boolean isFourthAnswer5 = fourthanswer5.isChecked();
        boolean isThirdAnswer6 = thirdanswer6.isChecked();
        boolean isFourthAnswer6 = fourthanswer6.isChecked();

        /**
         * Evaluates if the correct RadioButtons pressed, adds 1 point to the score.
         */
        score = 0;

        if (isSecondAnswer2) {
            score += 1;
        } else {
            score += 0;
        }

        if (isFourthAnswer3) {
            score += 1;
        } else {
            score += 0;
        }

        if (isSecondAnswer4) {
            score += 1;
        } else {
            score += 0;
        }

        if (isFourthAnswer5) {
            score += 1;
        } else {
            score += 0;
        }

        /**
         * Checks if both CheckBoxes are correct and adds 1 points to the score, else adds 0 points.
         */

        if (isThirdAnswer6 && isFourthAnswer6) {
            score += 2;
        } else {
            score += 0;
        }
    }

    /**
     * This method is called when the Submit button is pressed.
     *
     * @param view
     */

    public void setScore(View view) {

        /**
         * This method is called to update the latest value stored in the variable score.
         */

        calculateScore();

        /**
         * Show an message with the score as a toast.
         */

        Toast toast = Toast.makeText(this, getString(R.string.toast_string, score), Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();

        /**
         * Send an intent with the score to an e-mail address.
         */

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.subject));
        intent.putExtra(Intent.EXTRA_TEXT, getString(R.string.score1));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}