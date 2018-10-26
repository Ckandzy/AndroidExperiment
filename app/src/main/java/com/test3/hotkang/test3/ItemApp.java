package com.test3.hotkang.test3;

public class ItemApp {
    private int aId;
    private String aName;

    public ItemApp() {
    }

    public ItemApp(int aId, String iName) {
        this.aId = aId;
        this.aName = iName;
    }

    public int getiId() {
        return aId;
    }

    public String getiName() {
        return aName;
    }

    public void setiId(int aId) {
        this.aId = aId;
    }

    public void setiName(String aName) {
        this.aName = aName;
    }
}
