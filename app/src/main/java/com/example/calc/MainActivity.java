package com.example.calc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void decHex(View v) {
        switch (v.getId()) {
            case R.id.dec:
                int b;
                break;

            case R.id.hex:
                int a;
                break;

        }
    }

    public void pressButton(View v) {
        TextView textbox = (TextView) findViewById(R.id.textBox);
        Button button = (Button) v;

        String text = textbox.getText().toString();
        String add;

        if (v.getId() == R.id.mul) {
            add = text + "*";
            textbox.setText(add);
        } else {
            add = text + button.getText().toString();
            textbox.setText(add);
        }
    }

    public void enter(View v) {

    }

    public void erase(View v) {
        TextView answer = (TextView) findViewById(R.id.textAnswer);
        TextView textbox = (TextView) findViewById(R.id.textBox);

        String text = textbox.getText().toString();

        if (!answer.getText().toString().equals(""))
            textbox.setText("");
        else
            textbox.setText(text.substring(0, text.length() - 1));

    }
}