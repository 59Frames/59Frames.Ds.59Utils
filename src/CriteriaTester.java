import _59frames.Ds._59utils.filter.AndCriterion;
import _59frames.Ds._59utils.filter.Criterion;
import _59frames.Ds._59utils.filter.OrCriterion;

import java.util.ArrayList;
import java.util.List;

public class CriteriaTester {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();

        people.add(new Person(Gender.FEMALE, "Jessica", "Daniels", 32));
        people.add(new Person(Gender.MALE, "Timothy", "Trick", 18));
        people.add(new Person(Gender.FEMALE, "Daniela", "Bulma", 32));
        people.add(new Person(Gender.FEMALE, "Jessica", "Storm", 32));
        people.add(new Person(Gender.MALE, "Daniel", "Seifert", 18));
        people.add(new Person(Gender.MALE, "Mikail", "Aksoy", 16));
        people.add(new Person(Gender.MALE, "Mattheus", "Rigisberger", 17));
        people.add(new Person(Gender.FEMALE, "Nikita", "Ruegsegger", 17));
        people.add(new Person(Gender.FEMALE, "Natalia", "Stincil", 32));
        people.add(new Person(Gender.MALE, "Bowser", "Bilbo", 32));
        people.add(new Person(Gender.FEMALE, "Stormy", "Daniels", 32));

        Criterion<Person> gender = new GenderCriterion<>(Gender.FEMALE);

        Criterion<Person> andCriterion = new AndCriterion<>(gender);

        printPersons(andCriterion.meetCriteria(people));
    }

    private static void printPersons(List<Person> persons){
        for (Person person : persons) {
            System.out.println("Person : [ Name : " + person.getFirstName() + " " + person.getLastName() + ", Gender : " + person.getGender() + ", Age : " + person.getAge() + " ]");
        }
    }
}
