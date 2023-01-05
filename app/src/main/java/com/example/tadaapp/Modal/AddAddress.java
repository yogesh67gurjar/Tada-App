package com.example.tadaapp.Modal;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "addaddress")
public class AddAddress {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String fname;
    private String lname;
    private String apartment;
    private String city;
    private String state;
    private String country;
    private String zip;
    private String phone;
    private String defaultState;
    private String typeOfAddress;


    public AddAddress(String fname, String lname, String apartment, String city, String state, String country, String zip, String phone, String defaultState, String typeOfAddress) {

        this.fname = fname;
        this.lname = lname;
        this.apartment = apartment;
        this.city = city;
        this.state = state;
        this.country = country;
        this.zip = zip;
        this.phone = phone;
        this.defaultState = defaultState;
        this.typeOfAddress = typeOfAddress;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getApartment() {
        return apartment;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public String getZip() {
        return zip;
    }

    public String getPhone() {
        return phone;
    }

    public String getDefaultState() {
        return defaultState;
    }

    public String getTypeOfAddress() {
        return typeOfAddress;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setDefaultState(String defaultState) {
        this.defaultState = defaultState;
    }

    public void setTypeOfAddress(String typeOfAddress) {
        this.typeOfAddress = typeOfAddress;
    }
}
