package dev.rivaldi.userrestapi;

import java.util.List;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public ApiResponse<List<User>> getUsers(@RequestHeader("apikey") String header) {
        return userService.getUsers();
    }

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<User> createUser(@Valid @RequestBody CreateUserRequest request) {
        return userService.createUser(request);
    }

    @GetMapping("/users/{userName}")
    public ApiResponse<User> getUserByName(@PathVariable String userName) {
        return userService.getUser(new GetSingleUserRequest(userName));
    }

    @DeleteMapping("/users/{name}")
    public ApiResponse<String> deleteUserByName(@PathVariable String name) {
        return userService.deleteUser(new DeleteUserRequest(name));
    }

    @PutMapping("/users/{name}")
    public ApiResponse<User> updateUserByName(@PathVariable String name, @RequestBody UpdateUserRequest request) {
        return userService.updateUser(new UpdateUserRequest(name, request.getNewName()));
    }
}
