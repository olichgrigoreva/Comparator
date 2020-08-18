package lesson;

import java.util.*;
import java.util.stream.Collectors;

public class Collections {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        //перебор
        System.out.println("Обход коллекци: ");
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            Integer item = it.next();
            System.out.print(item + ":");
        }

        System.out.println("\nУдаление: ");
        it = list.iterator(); //нужен новый итератор!!!
        while (it.hasNext()) {
            Integer item = it.next();
            if (item < 3) {
                it.remove();
            }
        }
        for (Integer item : list) {
            System.out.print(item + ":");
        }
        //одновременно обходить и редактировать коллекцию нельзя!!!

        //редактирование с помощью стрима
        System.out.println("\nредактирование с помощью стрима");
        List<Integer> list2 = list.stream()
                .filter((item) -> item > 3)
                .collect(Collectors.toList());

        for (Integer item : list2) {
            System.out.print(item + ":");
        }

        //множества
        System.out.println("\nМножества");
        Set<String> names = new TreeSet<>(); //добавленное отсортируется (можно SortedSet вместо Set)
        //Set<String> names = new HashSet<>(); //Set - без дубликатов
        names.add("Тимур");
        names.add("Ольга");
        names.add("Ольга"); //не добавится
        for (String name : names) {
            System.out.print(name + ": ");
        }

        //Map
        System.out.println("\nMap");
        Map<String, String> capitals = new HashMap<>();
        capitals.put("Россия", "Москва");
        capitals.put("Англия", "Лондон");
        capitals.put("Германия", "Берлин");
        System.out.println("Столица России: " + capitals.get("Россия"));
        for (Map.Entry<String, String> entry : capitals.entrySet()) {
            System.out.println("У страны " + entry.getKey() + " столица " + entry.getValue());
        }
    }
}
