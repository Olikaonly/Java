package lesson10.online;
import java.util.*;

/**
 * Created by Olga Shestakova
 * Date 03.06.2021
 */
public class HomeWorkApp10 {
    public static void main(String[] args) {

        String[] fruits = {"apple", "avocado", "nectarine", "pear", "papaya",

                "apple", "avocado", "nectarine", "lemon", "mango"};

        Set<String> set = new LinkedHashSet<>(Arrays.asList(fruits));

        Map<String, Integer> map = new HashMap<>();
        for (String word : fruits) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        System.out.println("Задание № 1");
        System.out.println(set);
        System.out.println(map);
        System.out.println("****************");


        TelephoneBook book = new TelephoneBook();

        book.add("Ivanov", "11111");
        book.add("Petrov", "22222");
        book.add("Sidorov", "33333");
        book.add("Sizov", "44444");
        book.add("Ivanov", "55555");

        System.out.println("Задание № 2");
        System.out.println(book.get("Ivanov"));
        System.out.println(book.get("Petrov"));

    }
}
