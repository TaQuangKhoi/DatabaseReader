package com.taquangkhoi.databasereader;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

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
}
