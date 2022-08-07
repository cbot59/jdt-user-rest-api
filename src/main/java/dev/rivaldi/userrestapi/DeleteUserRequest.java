package dev.rivaldi.userrestapi;

public class DeleteUserRequest {

    private final String name;

    public DeleteUserRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
