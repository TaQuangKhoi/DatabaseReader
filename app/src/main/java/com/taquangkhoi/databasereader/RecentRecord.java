package com.taquangkhoi.databasereader;

public class RecentRecord {
    private int id;
    private String path;
    private String openTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getOpenTime() {
        return openTime;
    }

    public void setOpenTime(String openTime) {
        this.openTime = openTime;
    }

    public RecentRecord(int id, String path, String openTime) {
        this.id = id;
        this.path = path;
        this.openTime = openTime;
    }
}
