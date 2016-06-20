package com.amoeba.ieee754;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int bitCount = 32;

    private Button buttons[] = new Button[bitCount];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i = 0; i < bitCount; i++) { // put buttons in array
            String buttonID = "btn" + i;
            int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
            buttons[i] = (Button)findViewById(resID);
        } // end for

    } // end onCreate

    public void btnOnClick(View v) {

        updateButton(v.getId());
        updateNumber();

    } // end onClick

    private void updateButton(int btnId) {
        Button clickedBtn = (Button)findViewById(btnId);

        if (clickedBtn.getText().equals("1")) {
            clickedBtn.setText("0");
        }
        else {
            clickedBtn.setText("1");
        }
    } // end updateButton

    private void updateNumber() {

        TextView tvDisplayedNum = (TextView)findViewById(R.id.tvNumber);
        tvDisplayedNum.setText(convertBtnsToFloatStr());

    } // end updateNumber

    private String convertBtnsToFloatStr() {

        // this data conversion seems janky to me
        int tempInt = (int)Long.parseLong(getBtnsAsStr(), 2);
        float tempFloat = Float.intBitsToFloat(tempInt);

        return Float.toString(tempFloat);
    } // end convertBtnsToFloatStr

    private String getBtnsAsStr() {
        String bits = "";

        for (int i = buttons.length - 1; i >= 0; i--) {
            bits = bits.concat(buttons[i].getText().toString());
        } // end for

        return bits;
    } // end getBtnsAsStr

} // end MainActivity
