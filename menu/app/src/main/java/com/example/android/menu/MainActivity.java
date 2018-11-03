package com.example.android.menu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void printToLogs(View view) {
        TextView menuItem1 = findViewById(R.id.menu_item_1);
        TextView menuItem2 = findViewById(R.id.menu_item_2);
        TextView menuItem3 = findViewById(R.id.menu_item_3);

        // Find first menu item TextView and print the text to the logs
        Log.i("menuItem1", "printToLogs:" + menuItem1.getText());
        // Find second menu item TextView and print the text to the logs
        Log.i("menuItem2", "printToLogs:" + menuItem2.getText());
        // Find third menu item TextView and print the text to the logs
        Log.i("menuItem3", "printToLogs:" + menuItem3.getText());

    }
}