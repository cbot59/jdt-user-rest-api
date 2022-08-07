package dev.rivaldi.userrestapi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

class UserTest {

    private User user50;

    @BeforeAll
    static void beforeAll() {
        System.out.println("beforeAll dicetak");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("afterAll");
    }

    @BeforeEach
    void setUp() {
        System.out.println("Sebelum test jalan");
    }

    @AfterEach
    void tearDown() {
        System.out.println("Sesudah test jalan");
    }

    @Nested
    class GetName {

        @Test
        void shouldReturnSomeoneNameWhenNameIsSomeone() {
            System.out.println("Test mulai berjalan");
            User user = new User("someoneName", 50);

            assertNotNull(user.getName());
            assertEquals("someoneName", user.getName());
            assertNotEquals("Adele", user.getName());
            assertEquals(11, user.getName().length());

            System.out.println("Test selesai berjalan");
        }

        @Test
        void shouldTruncateWhenNameExceed30() {
            // given
            User user = new User("panjangnamamelebihitigapuluhkarakter", 15);

            // when
            String actual = user.getName();

            // then
            assertEquals(30, actual.length());
            assertEquals("panjangnamamelebihitigapuluhka", actual);
        }

    }

    @Nested
    class GetAge {

        @Test
        void shouldReturn10WhenAgeIs10() {
            // given
            User user = new User("panjangnamamelebihitigapuluhkarakter", 10);

            // when
            Integer age = user.getAge();

            // then
            assertEquals(10, age);
        }

        @Test
        void shouldReturn0WhenAgeIsNegative() {
            // given
            User user = new User("panjangnamamelebihitigapuluhkarakter", -1);

            // when
            Integer age = user.getAge();

            // then
            assertEquals(0, age);
        }

    }
}
