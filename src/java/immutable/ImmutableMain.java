package immutable;

public class ImmutableMain {

    public static void main(String[] args) {
        Age age = new Age();
        age.setDate(3);
        age.setMonth(12);
        age.setYear(1992);

        Age newAge = age;

        System.out.println("age == newAge " + (age == newAge));
        System.out.println("age.equals(newAge) : " + age.equals(newAge));

        Age newAge1 = new Age();
        newAge1.setDate(3);
        newAge1.setMonth(12);
        newAge1.setYear(1992);

        System.out.println("age==newAge1 " + (age == newAge1));
        System.out.println("age.equals(newAge1) : " + age.equals(newAge1));

        User user = new User(1, "Deepak Chaturvedi", "Fatehgarh", age);

        User newUser = new User(1, "Deepak Chaturvedi", "Fatehgarh", newAge1);

        System.out.println("user.equals(newUser)" + user.equals(newUser));

        System.out.println(user);
        age.setYear(1991);
        System.out.println(user);
        user.getAge().setYear(1993);
        System.out.println("User Age : " + user.getAge());
    }
}
