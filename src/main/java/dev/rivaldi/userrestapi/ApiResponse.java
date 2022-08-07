package dev.rivaldi.userrestapi;

public class ApiResponse<T> {

    private final String status;
    private final T data;
    private final String message;

    public ApiResponse(String status, T data, String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public T getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }
}
