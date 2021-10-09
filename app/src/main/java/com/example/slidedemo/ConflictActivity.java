package com.example.slidedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ConflictActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conflict);
        createList();
    }
    private void createList(){
        ArrayList<String> datas = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            datas.add("name" + i);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(ConflictActivity.this, android.R.layout.simple_list_item_1,datas);
        ListView listView = findViewById(R.id.list);

        listView.setAdapter(adapter);
    }
}