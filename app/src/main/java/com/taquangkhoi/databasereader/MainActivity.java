package com.taquangkhoi.databasereader;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    Button btnNewDatabase;
    Button btnOpenDatabase;
    ListView lvwRecentDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AddControls();
        AddEvents();
    }

    private void AddControls() {
        btnNewDatabase = findViewById(R.id.btn_new_database);
        btnOpenDatabase = findViewById(R.id.btn_open_database);
        lvwRecentDatabase = findViewById(R.id.lvw_recent_database);
    }

    private void AddEvents() {
        btnNewDatabase.setOnClickListener(v -> {

        });
        btnOpenDatabase.setOnClickListener(v -> {

        });
    }

    // Read SQLite Database to get recent database list
    private void GetRecentDatabase() {
        
    }
}