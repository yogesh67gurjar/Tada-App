package com.example.tadaapp.Modal;


public class UserLogin {

    private boolean status;
    private int status_code;
    private String message;
    private USERDATA user_data;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getStatus_code() {
        return status_code;
    }

    public void setStatus_code(int status_code) {
        this.status_code = status_code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public USERDATA getUser_data() {
        return user_data;
    }

    public void setUser_data(USERDATA user_data) {
        this.user_data = user_data;
    }
}
