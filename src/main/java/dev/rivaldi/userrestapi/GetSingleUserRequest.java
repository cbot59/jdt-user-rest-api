package dev.rivaldi.userrestapi;

public class GetSingleUserRequest {
    private String name;

    public GetSingleUserRequest() {
    }

    public GetSingleUserRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
