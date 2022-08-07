package dev.rivaldi.userrestapi;

public class UpdateUserRequest {
    private String name;

    private String newName;

    public UpdateUserRequest() {
    }

    public UpdateUserRequest(String name, String newName) {
        this.name = name;
        this.newName = newName;
    }

    public String getName() {
        return name;
    }

    public String getNewName() {
        return newName;
    }

}
