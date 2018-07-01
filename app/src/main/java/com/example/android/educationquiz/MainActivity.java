package com.example.android.educationquiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int score;
    int count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // This is the method that is called when the submit button is called, it call totalScore method.
    public void submitQuiz(View view) {
        double percentageScore = totalScore();
        Toast.makeText(this, "Your score got " + score + " out of " + count + " which is " + percentageScore + "%", Toast.LENGTH_LONG).show();
        display();
        Button button = findViewById(R.id.submitButton);
        button.setClickable(false);
    }

    //This method checks the answer of the first question.
    public void questionOne() {
        CheckBox checkBoxA = findViewById(R.id.optionOneA);
        boolean tickedA = checkBoxA.isChecked();
        CheckBox checkBoxB = findViewById(R.id.optionOneB);
        boolean tickedB = checkBoxB.isChecked();
        CheckBox checkBoxC = findViewById(R.id.optionOneC);
        boolean tickedC = checkBoxC.isChecked();
        CheckBox checkBoxD = findViewById(R.id.optionOneD);
        boolean tickedD = checkBoxD.isChecked();

        if (tickedA && tickedB && !tickedC && tickedD) {
            score = score + 1;
        }
        count++;
    }

    //This method checks the answer of the second question.
    public void questionTwo() {
        RadioButton radioButton = findViewById(R.id.answerTwo);
        if (radioButton.isChecked()) {
            score = score + 1;
        }
        count++;
    }

    //This method checks the answer of the third question.
    public void questionThree() {
        EditText editText = findViewById(R.id.answerThree);
        String value = editText.getText().toString();
        if (value.equalsIgnoreCase("Jetbrains") || value.equalsIgnoreCase("Jetbrains.")) {
            score = score + 1;
        }
        count++;
    }

    //This method checks the answer of the fourth question.
    public void questionFour() {
        CheckBox checkBoxA = findViewById(R.id.optionFourA);
        boolean tickedA = checkBoxA.isChecked();
        CheckBox checkBoxB = findViewById(R.id.optionFourB);
        boolean tickedB = checkBoxB.isChecked();
        CheckBox checkBoxC = findViewById(R.id.optionFourC);
        boolean tickedC = checkBoxC.isChecked();
        CheckBox checkBoxD = findViewById(R.id.optionFourD);
        boolean tickedD = checkBoxD.isChecked();

        if (tickedA && !tickedB && tickedC && !tickedD) {
            score = score + 1;
        }
        count++;
    }

    //This method checks the answer of the fifth question.
    public void questionFive() {
        RadioButton radioButton = findViewById(R.id.answerFive);
        if (radioButton.isChecked()) {
            score = score + 1;
        }
        count++;
    }

    //This method checks the answer of the sixth question.
    public void questionSix() {
        CheckBox checkBoxA = findViewById(R.id.optionSixA);
        boolean tickedA = checkBoxA.isChecked();
        CheckBox checkBoxB = findViewById(R.id.optionSixB);
        boolean tickedB = checkBoxB.isChecked();
        CheckBox checkBoxC = findViewById(R.id.optionSixC);
        boolean tickedC = checkBoxC.isChecked();
        CheckBox checkBoxD = findViewById(R.id.optionSixD);
        boolean tickedD = checkBoxD.isChecked();

        if (!tickedA && tickedB && !tickedC && tickedD) {
            score = score + 1;
        }
        count++;
    }

    //This method checks the answer of the seventh question.
    public void questionSeven() {
        RadioButton radioButton = findViewById(R.id.answerSeven);
        if (radioButton.isChecked()) {
            score = score + 1;
        }
        count++;
    }

    // This method calls all the question methods and returns a Integer which is the percentage score
    // of the Quiz participant.
    public int totalScore() {
        questionOne();
        questionTwo();
        questionThree();
        questionFour();
        questionFive();
        questionSix();
        questionSeven();
        return (100 * score / count);
    }

    // This method displays the participant's personal information as well as his score,
    public void display() {
        String sex;
        String title;
        TextView textView1 = findViewById(R.id.name);
        String name = textView1.getText().toString();


        TextView textView2 = findViewById(R.id.age);
        String age = textView2.getText().toString();

        RadioButton radioButton1 = findViewById(R.id.male);
        boolean male = radioButton1.isChecked();
        RadioButton radioButton2 = findViewById(R.id.female);
        boolean female = radioButton2.isChecked();
        if (male) {
            sex = "Male";
            title = "Mr ";
        } else if (female) {
            sex = "Female";
            title = "Ms ";
        } else {
            sex = "Unspecified";
            title = "";
        }

        TextView textView3 = findViewById(R.id.nation);
        String nation = textView3.getText().toString();


        TextView textView = findViewById(R.id.finalReport);
        textView.setText("RESULT PRINTOUT" + "\nName: " + title + "" + name + "\nAge: " + age +
                "\nSex: " + sex + "\nCountry: " + nation + "\nQuiz Score: " + totalScore() + "%");
    }
}
