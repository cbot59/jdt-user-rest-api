package dev.rivaldi.userrestapi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class UserServiceImplTest {

    private UserService userService;

    @BeforeEach
    void setUp() {
        userService = new UserServiceImpl(Collections.emptyList());
    }

    @Nested
    class GetUsers {
        @Test
        void shouldReturnEmpty() {
            // when
            ApiResponse<List<User>> users = userService.getUsers();

            // then
            assertTrue(users.getData().isEmpty());
        }

        @Test
        void shouldReturnUsers() {
            // given
            userService = new UserServiceImpl(Arrays.asList(new User("Aldi", 20)));

            // when
            ApiResponse<List<User>> users = userService.getUsers();

            // then
            assertFalse(users.getData().isEmpty());
        }
    }

    @Nested
    class GetUserBy {
        @Test
        void shouldReturnNullWhenUserNotFound() {
            // when
            ApiResponse<User> response = userService.getUser(new GetSingleUserRequest("Robot"));

            // then
            assertNull(response.getData());
        }

        @Test
        void shouldReturnUsersWhenUserFound() {
            // given
            userService = new UserServiceImpl(Arrays.asList(new User("Potter", 10)));

            // when
            ApiResponse<User> response = userService.getUser(new GetSingleUserRequest("Potter"));

            // then
            assertNotNull(response.getData());
        }
    }

    @Nested
    class CreateUser {
        @Test
        void shouldAddUser() {
            // given
            userService = new UserServiceImpl(new ArrayList<>());

            // when
            ApiResponse<User> response = userService.createUser(new CreateUserRequest("Aldi", 20));

            // then
            assertNotNull(response.getData());
            assertEquals("Aldi", response.getData().getName());
            assertEquals(20, response.getData().getAge());
        }
    }

    @Nested
    class DeleteUser {
        @Test
        void shouldReturnNullWhenUserNotExist() {
            // when
            ApiResponse<String> response = userService.deleteUser(new DeleteUserRequest("Aldi"));

            // then
            assertNull(response.getData());
        }

        @Test
        void shouldReturnUserNameWhenUserDeleted() {
            // given
            ArrayList<User> users = new ArrayList<>();
            users.add(new User("Aldi", 50));
            userService = new UserServiceImpl(users);

            // when
            ApiResponse<String> response = userService.deleteUser(new DeleteUserRequest("Aldi"));

            // then
            assertNotNull(response.getData());
            assertEquals("Aldi", response.getData());
        }
    }

    @Nested
    class UpdateUser {
        @Test
        void shouldReturnNullWhenUserNotFound() {
            // when
            ApiResponse<User> response = userService.updateUser(new UpdateUserRequest("Aldi", "AldiBaru"));

            // then
            assertNull(response.getData());
        }

        @Test
        void shouldReturnUpdatedUser() {
            // given
            userService = new UserServiceImpl(Arrays.asList(new User("Aldi", 20)));

            // when
            ApiResponse<User> response = userService.updateUser(new UpdateUserRequest("Aldi", "AldiBaru"));

            // then
            assertNotNull(response.getData());
            assertEquals("AldiBaru", response.getData().getName());
        }
    }
}
