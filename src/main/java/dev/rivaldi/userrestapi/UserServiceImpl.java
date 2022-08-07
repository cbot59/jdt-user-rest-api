package dev.rivaldi.userrestapi;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private List<User> users = new ArrayList<>();

    public UserServiceImpl(List<User> users) {
        this.users = users;
    }

    @Override
    public ApiResponse<List<User>> getUsers() {
        return new ApiResponse<>("Sukses",
            users,
            "Berikut semua data user"
        );
    }

    @Override
    public ApiResponse<User> createUser(CreateUserRequest request) {
        // buat object User
        User user = new User(request.getName(), request.getAge());

        // simpan object User ke global variable
        users.add(user);

        // kembalikan create user response
        return new ApiResponse<>(
            "Sukses",
            user,
            "User berhasil dibuat"
        );
    }

    @Override
    public ApiResponse<User> getUser(GetSingleUserRequest request) {
        return users.stream()
            .filter(user -> request.getName().equals(user.getName()))
            .findAny()
            .map(user -> new ApiResponse<>(
                "Sukses",
                user,
                "Berikut data user"
            ))
            .orElse(new ApiResponse<>("Sukses", null, "Berikut data user"));
    }

    @Override
    public ApiResponse<String> deleteUser(DeleteUserRequest request) {
        // hapus user dari global variable
        boolean userDeleted = users.removeIf(user -> request.getName().equals(user.getName()));

        // jika berhasil, kembalikan response dengan nama user
        if (userDeleted) {
            return new ApiResponse<>(
                "Sukses",
                request.getName(),
                "User berhasil dihapus"
            );
        }

        // kembalikan delete response
        return new ApiResponse<>(
            "Gagal",
            null,
            "User tidak ditemukan"
        );
    }

    @Override
    public ApiResponse<User> updateUser(UpdateUserRequest request) {
        return users.stream()
            .filter(user -> request.getName().equals(user.getName()))
            .findAny()
            .map(user -> updateUser(user, request))
            .map(user -> new ApiResponse<>("Sukses", user, "User berhasil diupdate"))
            .orElse(new ApiResponse<>("Gagal", null, "User tidak ditemukan"));
    }

    private User updateUser(User user, UpdateUserRequest request) {
        user.setName(request.getNewName());

        return user;
    }
}
