package com.example.Tugas_CRUD_20230140090.model;

public class WebResponse<T> {
    private String status;
    private String message;
    private T data;

    public WebResponse() {
    }
    // Constructor
    public WebResponse(String status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }
    // GETTER & SETTER
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public T getData() { return data; }
    public void setData(T data) { this.data = data; }
}
