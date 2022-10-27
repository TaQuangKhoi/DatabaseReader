package com.taquangkhoi.databasereader;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class RecentDBHandler extends SQLiteOpenHelper {

    private static final String DB_NAME = "RecentDB";

    private static final int DB_VERSION = 1;

    private static final String TABLE_NAME = "Recent";

    private static final String ID_COL = "id";

    private static final String PATH_COL = "path";

    private static final String OPEN_TIME_COL = "open_time";

    public RecentDBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + PATH_COL + " TEXT,"
                + OPEN_TIME_COL + " TEXT)";
        sqLiteDatabase.execSQL(query);
    }

    public void addNewRecent(String path, String openTime) {
        SQLiteDatabase db = getWritableDatabase();
        String query = "INSERT INTO " + TABLE_NAME + " ("
                + PATH_COL + ", "
                + OPEN_TIME_COL + ") VALUES ("
                + "'" + path + "', "
                + "'" + openTime + "')";
        db.execSQL(query);
        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // Kiểm tra xem CSDL có tồn tại không
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public ArrayList<RecentRecord> readRecentRecords() {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursorRecentRecords = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        ArrayList<RecentRecord> recentRecords = new ArrayList<>();

        if(cursorRecentRecords.moveToFirst()) {
            do {
                int id = cursorRecentRecords.getInt(0);
                String path = cursorRecentRecords.getString(1);
                String openTime = cursorRecentRecords.getString(2);
                RecentRecord recentRecord = new RecentRecord(id, path, openTime);

                recentRecords.add(recentRecord);
            } while (cursorRecentRecords.moveToNext());
        }

        cursorRecentRecords.close();
        return recentRecords;
    }
}
