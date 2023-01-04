package com.example.tadaapp.Modal;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "creditcards")
public class CreditCards {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String card_number;

    public CreditCards(String card_number) {
        this.card_number = card_number;
    }

    public int getId() {
        return id;
    }

    public String getCard_number() {
        return card_number;
    }

    public void setId(int id) {
        this.id = id;
    }
}
