package designPattern.builder;

public class User {

    private String fName;
    private String lName;
    private int phoneNumber;
    private int age;
    private int siblings;

    private User(UserBuilder userBuilder) {
        this.fName = userBuilder.fName;
        this.lName = userBuilder.lName;
        this.age = userBuilder.age;
        this.phoneNumber = userBuilder.phoneNumber;
        this.siblings = userBuilder.siblings;
    }

    public String getfName() {
        return fName;
    }

    private void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    private void setlName(String lName) {
        this.lName = lName;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    private void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    private void setAge(int age) {
        this.age = age;
    }

    public int getSiblings() {
        return siblings;
    }

    private void setSiblings(int siblings) {
        this.siblings = siblings;
    }

    public UserBuilder getUserBuilder() {
        return new UserBuilder(fName, lName);
    }

    @Override
    public String toString() {
        return "User{" +
                "fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", age=" + age +
                ", siblings=" + siblings +
                '}';
    }

    static class UserBuilder {
        private String fName;
        private String lName;
        private int phoneNumber;
        private int age;
        private int siblings;

        UserBuilder(String fName, String lName) {
            this.fName = fName;
            this.lName = lName;
        }

        public UserBuilder withPhoneNumber(int phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public UserBuilder withAge(int age) {
            this.age = age;
            return this;
        }

        public UserBuilder withSiblings(int siblings) {
            this.siblings = siblings;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

}
