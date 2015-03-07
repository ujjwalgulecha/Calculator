package com.ujjwalgulecha.calculator;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;


public class MainActivity extends ActionBarActivity {


    Button addButton,subButton,mulButton;
    TextView answer_display;
    EditText v1,v2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addButton = (Button) findViewById(R.id.add_button);
        subButton = (Button) findViewById(R.id.sub_button);
        mulButton = (Button) findViewById(R.id.mul_button);
        answer_display = (TextView) findViewById(R.id.result_display);
        v1 = (EditText) findViewById(R.id.value1);
        v2 = (EditText) findViewById(R.id.value2);


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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void Add(View view) {

        String val1 = v1.getText().toString();
        String val2 = v2.getText().toString();
        int v1 = Integer.parseInt(val1);
        int v2 = Integer.parseInt(val2);
        int res = v1+v2;
        String ans = Integer.toString(res);
        answer_display.setText(ans);
    }

    public void Sub(View view) {
        String val1 = v1.getText().toString().trim();
        String val2 = v2.getText().toString().trim();
        int v1 = Integer.parseInt(val1);
        int v2 = Integer.parseInt(val2);
        int res = v1-v2;
        String ans = Integer.toString(res);
        answer_display.setText(ans);
    }

    public void Mul(View view) {
        String val1 = v1.getText().toString().trim();
        String val2 = v2.getText().toString().trim();
        int v1 = Integer.parseInt(val1);
        int v2 = Integer.parseInt(val2);
        int res = v1*v2;
        String ans = Integer.toString(res);
        answer_display.setText(ans);
    }
}
