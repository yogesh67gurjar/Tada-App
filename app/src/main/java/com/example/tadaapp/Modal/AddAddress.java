package com.example.tadaapp.Modal;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "addaddress")
public class AddAddress {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String title;
    private String desc;

    public AddAddress(String title, String desc) {
        this.title = title;
        this.desc = desc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
