public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private Gender gender;

    public Person(Gender gender, String firstName, String lastName, int age) {
        this.gender = gender;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }
}
