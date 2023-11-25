package ua.goit.task1.pojo;

public class UserBuilder {

    private UserBuilder() {
    }

    public static User build(String name) {

        Address address = new Address(
                "Jordan Road",
                "Apt.321",
                "Hong Kong",
                "05836",
                new Geo("33.765", "-46.587"));

        Company company = new Company(
                "DaiWong",
                "Big better future",
                "revolutionize machine learning systems");

        return new User(
                name,
                "Dragon",
                "dragonlion@gmail.com",
                address,
                "885-876-235-123",
                "mongkok.com.hk",
                company);
    }
}
