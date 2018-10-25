package com.test3.hotkang.test3;

public class ItemContact {
    private String cName;
    private String cPhoneNumber;
    private int cPhoto;

    public ItemContact() {
    }

    public ItemContact(String cName, String cPhoneNumber, int cPhoto)
    {
        this.cName = cName;
        this.cPhoneNumber = cPhoneNumber;
        this.cPhoto = cPhoto;
    }

    public String getcName()
    {
        return cName;
    }

    public String getcPhoneNumber()
    {
        return cPhoneNumber;
    }

    public int getcPhoto()
    {
        return cPhoto;
    }

    public void setcName(String cName)
    {
        this.cName = cName;
    }

    public void setcPhoneNumber(String cPhoneNumber)
    {
        this.cPhoneNumber = cPhoneNumber;
    }

    public void setcPhoto(int cPhoto)
    {
        this.cPhoto = cPhoto;
    }
}
