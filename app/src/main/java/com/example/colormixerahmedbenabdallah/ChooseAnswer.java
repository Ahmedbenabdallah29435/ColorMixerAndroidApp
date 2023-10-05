package com.example.colormixerahmedbenabdallah;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class ChooseAnswer extends AppCompatActivity {
TextView affiche;
CheckBox checkBox1,checkBox2,checkBox3;
Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_answer);
        affiche=findViewById(R.id.textView12);
        checkBox1=findViewById(R.id.checkBox11);
        checkBox2=findViewById(R.id.checkBox12);
        checkBox3=findViewById(R.id.checkBox13);
        submit=findViewById(R.id.submit);
        // Associate response strings with checkboxes
        checkBox1.setTag("Purple");
        checkBox2.setTag("Orange");
        checkBox3.setTag("Green");


        affiche.setText("Hello"+" "+getIntent().getStringExtra("name") +" " +"You choosed"+" "+ getIntent().getStringExtra("color1")  + " "+
                "and" + " "+
                getIntent().getStringExtra("color2")

        );
        submit.setOnClickListener(e -> {
                    Intent intent = new Intent (this,ChooseAnswer.class);
        // Check color combinations and set 'result' accordingly
        String result="";
        if ((getIntent().getStringExtra("color1").equals("Blue") && getIntent().getStringExtra("color2").equals("Red")) || (getIntent().getStringExtra("color1").equals("Red") && getIntent().getStringExtra("color2").equals("Blue"))) {
            result = "Purple";
        } else if ((getIntent().getStringExtra("color1").equals("Yellow") && getIntent().getStringExtra("color2").equals("Red")) || (getIntent().getStringExtra("color1").equals("Red") && getIntent().getStringExtra("color2").equals("Yellow"))) {
            result = "Orange";
        } else if ((getIntent().getStringExtra("color1").equals("Blue") && getIntent().getStringExtra("color2").equals("Yellow")) || (getIntent().getStringExtra("color1").equals("Yellow") && getIntent().getStringExtra("color2").equals("Blue"))) {
            result = "Green";
        }

        // Create an intent to start the appropriate activity based on the selected response


        if (checkBox1.isChecked() && checkBox1.getTag().equals(result)) {
            intent = new Intent(this, Activity1.class);
        } else if (checkBox2.isChecked() && checkBox2.getTag().equals(result)) {
            intent = new Intent(this, Activity1.class);
        } else if (checkBox3.isChecked() && checkBox3.getTag().equals(result)) {
            intent = new Intent(this, Activity1.class);
        } else {
            intent = new Intent(this, Activity2.class);
        }

        startActivity(intent);
        });
    }

        // Get the associated response from the tag

    }

