package immutable;

public final class User {

    private final int userId;
    private final String name;
    private final String city;
    private final Age age;

    public User(int userId, String name, String city, Age age) {
        this.userId = userId;
        this.name = name;
        this.city = city;
        if (null != age) {
            Age clonedAge = new Age();
            clonedAge.setDate(age.getDate());
            clonedAge.setMonth(age.getMonth());
            clonedAge.setYear(age.getYear());
            this.age = clonedAge;
        } else {
            this.age = null;
        }
    }

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public Age getAge() {
        Age clonedAge = null;
        if (null != age) {
            clonedAge = new Age();
            clonedAge.setDate(this.age.getDate());
            clonedAge.setMonth(this.age.getMonth());
            clonedAge.setYear(this.age.getYear());
        }
        return clonedAge;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (null == o || getClass() != o.getClass()) {
            return false;
        }

        if (o == this) {
            return true;
        }

        User user = (User) o;

        return userId == user.getUserId() && (null != name && name.equals(user.getName()) && (null != city && city.equals(user.getCity())
                && (null != age && age.equals(this.age))));
    }


//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        User user = (User) o;
//        return userId == user.userId &&
//                Objects.equals(name, user.name) &&
//                Objects.equals(city, user.city) &&
//                Objects.equals(age, user.age);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(userId, name, city, age);
//    }
}
