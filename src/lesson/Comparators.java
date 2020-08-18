package lesson;

import java.util.*;

public class Comparators {
    static class PersonAgeComparator implements Comparator<Person>{
        @Override
        public int compare(Person o1, Person o2) {
            return Integer.compare(o1.getAge(), o2.getAge());
        }
    }
    public static void main(String[] args) {
        SortedSet<Person> persons = new TreeSet(); //на вход принимает ещё компаратор (класс должен имплементировать Comparable)
        persons.add(new Person("Ольга", 26));
        persons.add(new Person("Катя", 25));
        persons.add(new Person("Настя", 24));
        for (Person person : persons ){
            System.out.println(person); //сортировка по имени
        }

        //сортировка по возрасту с новым компаратором
        System.out.println();
        persons = new TreeSet(new PersonAgeComparator());
        persons.add(new Person("Ольга", 26));
        persons.add(new Person("Катя", 25));
        persons.add(new Person("Настя", 24));
        for (Person person : persons ){
            System.out.println(person); //сортировка по имени
        }

        //билд компаратора
        System.out.println();
        persons = new TreeSet(Comparator.comparing(Person::getName).thenComparing(Person::getAge));
        //persons = new TreeSet(Comparator.comparing(Person::getAge)); //можно делать многоуровневые компараторы и наоборот
        //persons = new TreeSet(Comparator.comparing(Person::getAge).reversed()); //т.е. в обратном порядке
        persons.add(new Person("Ольга", 26));
        persons.add(new Person("Катя", 25));
        persons.add(new Person("Настя", 24));
        persons.add(new Person("Настя", 15));
        for (Person person : persons ){
            System.out.println(person); //сортировка по имени
        }

        System.out.println("Несортированные коллекции:");
        Comparator<Person> co = Comparator.comparing(Person::getName).thenComparing(Person::getAge);
        List<Person> personsList = new ArrayList<>();
        personsList.add(new Person("Ольга", 26));
        personsList.add(new Person("Катя", 25));
        personsList.add(new Person("Настя", 24));
        personsList.add(new Person("Настя", 15));
        for (Person person : persons ){
            System.out.println(person);
        }

        System.out.println("Sorted");
        personsList.sort(co); //передали компаратор
        for (Person person : persons ){
            System.out.println(person);
        }
    }
}
