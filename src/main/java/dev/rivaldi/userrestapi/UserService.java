package dev.rivaldi.userrestapi;

import java.util.List;

public interface UserService {

    ApiResponse<List<User>> getUsers();

    ApiResponse<User> createUser(CreateUserRequest request);

    ApiResponse<User> getUser(GetSingleUserRequest request);

    ApiResponse<String> deleteUser(DeleteUserRequest request);

    ApiResponse<User> updateUser(UpdateUserRequest request);

}
