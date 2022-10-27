package com.taquangkhoi.databasereader;

import android.widget.ArrayAdapter;
import android.widget.ListView;

public class RecentRecordsLVAdapter extends ArrayAdapter<RecentRecord> {
    ListView lvwRecentDatabase;
    RecentDBHandler recentDBHandler;

    public RecentRecordsLVAdapter(MainActivity context, int resource, ListView lvwRecentDatabase, RecentDBHandler recentDBHandler) {
        super(context, resource);
        this.lvwRecentDatabase = lvwRecentDatabase;
        this.recentDBHandler = recentDBHandler;
    }

    @Override
    public int getCount() {
        return recentDBHandler.getRecentCount();
    }
}

