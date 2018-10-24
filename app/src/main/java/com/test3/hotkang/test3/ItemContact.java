package com.test3.hotkang.test3;

public class ItemContact {
    private String cName;
    private String cPhoneNumber;
    private int cPhoto;

    public ItemContact() {
    }

    public ItemContact(String cName, String cPhoneNumber, int cPhoto) {
        this.cName = cName;
        this.cPhoneNumber = cPhoneNumber;
        this.cPhoto = cPhoto;
    }

    public String getcName() {
        return cName;
    }

    public String getcSpeak() {
        return cPhoneNumber;
    }

    public int getcIcon() {
        return cPhoto;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public void setcSpeak(String cPhoneNumber) {
        this.cPhoneNumber = cPhoneNumber;
    }

    public void setcIcon(int cPhoto) {
        this.cPhoto = cPhoto;
    }
}
