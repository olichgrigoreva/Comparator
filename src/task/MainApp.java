package task;

import java.util.SortedSet;
import java.util.TreeSet;

public class MainApp {
    public static void main(String[] args) {
        SortedSet<Person> persons = new TreeSet(new PersonSuperComparator());

        persons.add(new Person("Ольга", 26));
        persons.add(new Person("Катя", 25));
        persons.add(new Person("Настя", 24));
        persons.add(new Person("Вика", 21));
        persons.add(new Person("Ольга", 14));

        for (Person person : persons ){
            System.out.println(person);
        }
    }
}
