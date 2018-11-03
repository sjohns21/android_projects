package com.example.android.demo;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView textView = new TextView(this);
        textView.setText(R.string.text_been_set);
        textView.setBackgroundColor(Color.RED);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 28);

        setContentView(textView);

    }
}
