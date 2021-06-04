package lesson10.online;
import java.util.*;

/**
 * Created by Olga Shestakova
 * Date 03.06.2021
 */
public class TelephoneBook {

    private Map<String, HashSet<String>> map;

    TelephoneBook() {
        this.map = new HashMap<>();
    }

    void add(String surname, String phone) {
        HashSet<String> numbers;

        if (map.containsKey(surname)) {
            numbers = map.get(surname);
        } else {
            numbers = new HashSet<>();
        }
        numbers.add(phone);
        map.put(surname, numbers);

    }

    Set<String> get(String surname) {
        return map.get(surname);
    }

}
