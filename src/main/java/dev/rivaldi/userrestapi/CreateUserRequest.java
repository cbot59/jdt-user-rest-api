package dev.rivaldi.userrestapi;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class CreateUserRequest {

    @NotNull(message = "Nama tidak boleh null")
    private String name;

    @Min(value = 11, message = "Usia minimal 11")
    private Integer age;

    public CreateUserRequest() {
    }

    public CreateUserRequest(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }
}
