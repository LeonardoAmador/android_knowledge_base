package com.example.secondlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        String[] data = {"item 1", "item 2", "item 3"};

        ListView ltvList = findViewById(R.id.ltvList);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, data);

        ltvList.setAdapter(adapter);

        ltvList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(MainActivity.this, "Item " + ++position + "clicked", Toast.LENGTH_SHORT).show();

                Intent openItemDetail = new Intent(MainActivity.this, itemDetailActivity.class);

                openItemDetail.putExtra("itemIdClicked", position);
                startActivity(openItemDetail);
            }
        });
    }
}