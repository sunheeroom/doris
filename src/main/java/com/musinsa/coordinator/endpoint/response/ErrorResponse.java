package com.musinsa.coordinator.endpoint.response;

import java.io.Serializable;
import java.time.LocalDateTime;

public class ErrorResponse implements Serializable {
    String error;
    String message;
    LocalDateTime timestamp;

    public ErrorResponse(String error, String message, LocalDateTime timestamp) {
        this.error = error;
        this.message = message;
        this.timestamp = timestamp;
    }
}
