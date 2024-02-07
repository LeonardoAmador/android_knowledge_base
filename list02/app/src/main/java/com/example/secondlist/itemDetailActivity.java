package com.example.secondlist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class itemDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);

        String[] data = {"item 1", "item 2", "item 3"};

        Intent receivedIntent = getIntent();

        if (receivedIntent.hasExtra("clickedItemId")) {
            int code = receivedIntent.getIntExtra("clickedItemId", 0);

            TextView txvClickedItem = findViewById(R.id.txvClickedItem);
            txvClickedItem.setText(data[code]);
        }

    }
}