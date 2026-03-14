package com.example.Tugas_CRUD_20230140090.util;

import com.example.Tugas_CRUD_20230140090.model.WebResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseUtil {
    // Fungsi bantu untuk membuat response sukses
    public static <T> ResponseEntity<WebResponse<T>> buildSuccessResponse(String message, T data, HttpStatus status) {
        WebResponse<T> response = new WebResponse<>("success", message, data);
        return new ResponseEntity<>(response, status);
    }

    // Fungsi bantu untuk membuat response error
    public static <T> ResponseEntity<WebResponse<T>> buildErrorResponse(String message, HttpStatus status) {
        WebResponse<T> response = new WebResponse<>("error", message, null);
        return new ResponseEntity<>(response, status);
    }
}
