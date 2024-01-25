import com.github.javafaker.Faker;

public class FakeData {

    private static Faker faker = new Faker();

    public static String generateFirstName() {
        return faker.name().firstName();
    }

    public static String generateLastName() {
        return faker.name().lastName();
    }

    public static String generatePhoneNumber() {
        return faker.phoneNumber().phoneNumber();
    }

    public static String generateEmail() {
        return faker.internet().emailAddress();
    }
}