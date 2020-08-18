package task;

import java.util.Comparator;

/**
 * сортировка
 * 1) по возрасту
 * 2) по имени
 */

public class PersonSuperComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }

    @Override
    public Comparator<Person> thenComparing(Comparator<? super Person> other) {
        return thenComparing(Person::getName);
    }
}
