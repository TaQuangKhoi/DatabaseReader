package com.taquangkhoi.databasereader;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    Button btnNewDatabase, btnOpenDatabase;
    ListView lvwRecentDatabase;
    RecentDBHandler recentDBHandler;

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
        recentDBHandler = new RecentDBHandler(this);
    }

    private void AddEvents() {
        btnNewDatabase.setOnClickListener(v -> {

        });
        btnOpenDatabase.setOnClickListener(v -> {

        });
    }

    // Read SQLite Database to get recent database list
    private boolean GetRecentDatabase() {
        // Get recent database list
        return true;
    }

    // Create new SQLite database to store recent database list
    private void CreateOneRecentRecord(String path, String openTime) {
        recentDBHandler.addNewRecent(path, openTime);
    }

    private void UpdateOneRecentRecord(String path, String openTime) {
//        recentDBHandler.updateRecent(path, openTime);
    }
}