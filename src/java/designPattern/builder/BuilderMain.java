package designPattern.builder;

public class BuilderMain {

    public static void main(String[] args) {
        User user = new User.UserBuilder("Deepak", "Chaturvedi").withAge(10).withPhoneNumber(1000).withSiblings(100).build();
        System.out.println(user);
    }
}
