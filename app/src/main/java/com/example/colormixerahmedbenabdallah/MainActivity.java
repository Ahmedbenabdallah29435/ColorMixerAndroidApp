package com.example.colormixerahmedbenabdallah;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText name;
    CheckBox checkBox5,checkBox6,checkBox7;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name=findViewById(R.id.editTextText);
        checkBox5=findViewById(R.id.checkBox5);
        checkBox6=findViewById(R.id.checkBox6);
        checkBox7=findViewById(R.id.checkBox7);
        button=findViewById(R.id.button);
        button.setOnClickListener(e -> {
            Intent intent = new Intent (this,ChooseAnswer.class);
            int checkedCount = 0;

            if (checkBox5.isChecked()) {
                checkedCount++;
            }

            if (checkBox6.isChecked()) {
                checkedCount++;
            }

            if (checkBox7.isChecked()) {
                checkedCount++;
            }

// If more than two checkboxes are checked, uncheck the last one
            if (checkedCount > 2) {
                if (checkBox5.isChecked()) {
                    checkBox5.setChecked(false);
                } else if (checkBox6.isChecked()) {
                    checkBox6.setChecked(false);
                } else if (checkBox7.isChecked()) {
                    checkBox7.setChecked(false);
                }
            }
            String color1 = "no color";
            String color2 = "please go back and pick the other color";

            if (checkBox5.isChecked()) {
                color1 = "Blue";
            }

            if (checkBox6.isChecked()) {
                if (color1 == "no color") {
                    color1 = "Red";
                } else {
                    color2 = "Red";
                }
            }

            if (checkBox7.isChecked()) {
                if (color1== "no color") {
                    color1 = "Yellow";
                } else {
                    color2 = "Yellow";
                }
            }

// Use the 'color1' and 'color2' variables as needed.


// You can add similar code for other checkboxes if needed.

// Use the 'color1' and 'color2' variables as needed.


            intent.putExtra("name",name.getText().toString());

            intent.putExtra("color1",color1);
            intent.putExtra("color2",color2);

                    startActivity(intent);
        });

    }
}
