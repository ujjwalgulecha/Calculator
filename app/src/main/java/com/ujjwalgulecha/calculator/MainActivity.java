package com.ujjwalgulecha.calculator;

import android.app.DialogFragment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

    public String firstValue=" ";
    public int flag=1;

    TextView answer_display;
    EditText v1,v2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        answer_display = (TextView) findViewById(R.id.result_display);
        v1 = (EditText) findViewById(R.id.value1);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            DialogFragment myFragment = new myDialogFragment();
            myFragment.show(getFragmentManager(),"theDialog");
            return true;
        }
        else if(id == R.id.exit_the_app)
        {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void clickSeven(View view) {
        if(flag==1) {
            firstValue = "7";
            flag=0;
        }
        else
        {
            firstValue  = firstValue + "7";
        }

        v1.setText(firstValue);
        v1.setSelection(v1.getText().length());
    }

    public void clickEight(View view) {
        if(flag==1) {
            firstValue = "8";
            flag=0;
        }
        else
        {
            firstValue  = firstValue + "8";
        }

        v1.setText(firstValue);
        v1.setSelection(v1.getText().length());
    }

    public void clickNine(View view) {
        if(flag==1) {
            firstValue = "9";
            flag=0;
        }
        else
        {
            firstValue  = firstValue + "9";
        }

        v1.setText(firstValue);
        v1.setSelection(v1.getText().length());
    }

    public void clickFour(View view) {
        if(flag==1) {
            firstValue = "4";
            flag=0;
        }
        else
        {
            firstValue  = firstValue + "4";
        }

        v1.setText(firstValue);
        v1.setSelection(v1.getText().length());
    }

    public void clickFive(View view) {
        if(flag==1) {
            firstValue = "5";
            flag=0;
        }
        else
        {
            firstValue  = firstValue + "5";
        }

        v1.setText(firstValue);
        v1.setSelection(v1.getText().length());
    }

    public void clickSix(View view) {
        if(flag==1) {
            firstValue = "6";
            flag=0;
        }
        else
        {
            firstValue  = firstValue + "6";
        }

        v1.setText(firstValue);
        v1.setSelection(v1.getText().length());
    }

    public void clickOne(View view) {
        if(flag==1) {
            firstValue = "1";
            flag=0;
        }
        else
        {
            firstValue  = firstValue + "1";
        }

        v1.setText(firstValue);
        v1.setSelection(v1.getText().length());
    }

    public void clickTwo(View view) {
        if(flag==1) {
            firstValue = "2";
            flag=0;
        }
        else
        {
            firstValue  = firstValue + "2";
        }

        v1.setText(firstValue);
        v1.setSelection(v1.getText().length());
    }

    public void clickThree(View view) {
        if(flag==1) {
            firstValue = "3";
            flag=0;
        }
        else
        {
            firstValue  = firstValue + "3";
        }

        v1.setText(firstValue);
        v1.setSelection(v1.getText().length());
    }

    public void clickZero(View view) {
        if(flag==1) {
            firstValue = "0";
            flag=0;
        }
        else
        {
            firstValue  = firstValue + "0";
        }

        v1.setText(firstValue);
        v1.setSelection(v1.getText().length());
    }

    public void clickDot(View view) {
        if(flag==1) {
            firstValue = ".";
            flag=0;
        }
        else
        {
            firstValue  = firstValue + ".";
        }

        v1.setText(firstValue);
        v1.setSelection(v1.getText().length());
    }

    public void clickClear(View view) {
        firstValue  = " ";
        flag=1;
        v1.setText(firstValue);
        answer_display.setText(" ");

    }

    public void clickBack(View view) {
        if(firstValue.length()==0)
        {
            v1.setText(" ");
            flag=1;
        }
        else
        {
            String abc = firstValue.substring(0,firstValue.length()-1);
            firstValue = abc;
            v1.setText(firstValue);
            v1.setSelection(v1.getText().length());
        }

    }

    public void clickEqual(View view) {

        Double answer = evaluate(firstValue);
        String a = Double.toString(answer);
        answer_display.setText(a);

    }
    public static double evaluate(final String str) {
        class Parser {
            int pos = -1, c;

            void eatChar() {
                c = (++pos < str.length()) ? str.charAt(pos) : -1;
            }

            void eatSpace() {
                while (Character.isWhitespace(c)) eatChar();
            }

            double parse() {
                eatChar();
                double v = parseExpression();
                if (c != -1) throw new RuntimeException("Unexpected: " + (char)c);
                return v;
            }

            // Grammar:
            // expression = term | expression `+` term | expression `-` term
            // term = factor | term `*` factor | term `/` factor | term brackets
            // factor = brackets | number | factor `^` factor
            // brackets = `(` expression `)`

            double parseExpression() {
                double v = parseTerm();
                for (;;) {
                    eatSpace();
                    if (c == '+') { // addition
                        eatChar();
                        v += parseTerm();
                    } else if (c == '-') { // subtraction
                        eatChar();
                        v -= parseTerm();
                    } else {
                        return v;
                    }
                }
            }

            double parseTerm() {
                double v = parseFactor();
                for (;;) {
                    eatSpace();
                    if (c == '/') { // division
                        eatChar();
                        v /= parseFactor();
                    } else if (c == '*' || c == '(') { // multiplication
                        if (c == '*') eatChar();
                        v *= parseFactor();
                    } else {
                        return v;
                    }
                }
            }

            double parseFactor() {
                double v;
                boolean negate = false;
                eatSpace();
                if (c == '(') { // brackets
                    eatChar();
                    v = parseExpression();
                    if (c == ')') eatChar();
                } else { // numbers
                    if (c == '+' || c == '-') { // unary plus & minus
                        negate = c == '-';
                        eatChar();
                        eatSpace();
                    }
                    StringBuilder sb = new StringBuilder();
                    while ((c >= '0' && c <= '9') || c == '.') {
                        sb.append((char)c);
                        eatChar();
                    }
                    if (sb.length() == 0) throw new RuntimeException("Unexpected: " + (char)c);
                    v = Double.parseDouble(sb.toString());
                }
                eatSpace();
                if (c == '^') { // exponentiation
                    eatChar();
                    v = Math.pow(v, parseFactor());
                }
                if (negate) v = -v; // exponentiation has higher priority than unary minus: -3^2=-9
                return v;
            }
        }
        return new Parser().parse();
    }

    public void clickAdd(View view) {
        if(flag==1) {
            firstValue = "+";
            flag=0;
        }
        else
        {
            firstValue  = firstValue + "+";
        }

        v1.setText(firstValue);
        v1.setSelection(v1.getText().length());

    }
    public void clickSubtract(View view) {
        if(flag==1) {
            firstValue = "-";
            flag=0;
        }
        else
        {
            firstValue  = firstValue + "-";
        }

        v1.setText(firstValue);
        v1.setSelection(v1.getText().length());

    }
    public void clickMultiply(View view) {
        if(flag==1) {
            firstValue = "*";
            flag=0;
        }
        else
        {
            firstValue  = firstValue + "*";
        }

        v1.setText(firstValue);
        v1.setSelection(v1.getText().length());

    }

    public void clickDivide(View view) {
        if(flag==1) {
            firstValue = "/";
            flag=0;
        }
        else
        {
            firstValue  = firstValue + "/";
        }

        v1.setText(firstValue);
        v1.setSelection(v1.getText().length());

    }

}
