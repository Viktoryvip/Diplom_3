package user;
import net.datafaker.Faker;

public class UserGenerator {

    static Faker faker = new Faker();

    public static User getRandomUser() {
        String name = faker.name().firstName();
        String email = faker.internet().emailAddress();
        String password = faker.password().toString();

        return new User(email, password, name );
    }
}