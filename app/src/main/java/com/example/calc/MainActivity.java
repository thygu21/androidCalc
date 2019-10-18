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
        TextView answer = (TextView) findViewById(R.id.textAnswer);

        switch (v.getId()) {
            case R.id.dec:
                answer.setText(String.valueOf(Long.parseLong(answer.getText().toString(), 16)));
                break;

            case R.id.hex:
                answer.setText(Long.toHexString(Long.parseLong(answer.getText().toString())));
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
        TextView answerbox = (TextView)findViewById(R.id.textAnswer);
        String answer = answerbox.getText().toString();

        while(!answer.equals(""))
        {
            int end = answer.indexOf(")");
            if(end == -1)
                break;
            int start = answer.lastIndexOf("(", end);
            String subresult = calc(answer.substring(start + 1, end - 1).toString());
            answer = answer.substring(0, start - 1) + subresult + answer.substring(end + 1, answer.length());
        }
        answer = calc(answer);

        answerbox.setText(answer);
    }

    public String calc(String s)
    {
        int mul = s.indexOf("*");
        int div = s.indexOf("/");
        int minus = s.indexOf("-");
        int plus = s.indexOf("+");
        int sign;

        while(mul != -1 || div != -1) // 곱셈이나 나눗셈이 없어질 때까지 반복
        {
            if(mul == -1)
                sign = div;
            else if(div == -1)
                sign = mul;
            else if(mul < div)
                sign = mul;
            else
                sign = div;

            int frontstart, backend;
            frontstart = answer.
            if(sign == mul)
                int subresult = Integer.parseInt((s.substring(sign-1,sign-1))*Integer.parseInt((s.substring(sign+1,sign+1));
            else
                int subresult = Integer.parseInt((s.substring(sign-1,sign-1))/Integer.parseInt((s.substring(sign+1,sign+1));

        }

        while(plus != -1 || minus != -1) // 덧셈이나 뺄셈이 없어질 때까지 반복
        {
            if(plus == -1)
                sign = minus;
            else if(minus == -1)
                sign = plus;
            else if(plus < minus)
                sign = plus;
            else
                sign = minus;


        }



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