package lesson09.online;

/**
 * Created by Olga Shestakova
 * Date 01.06.2021
 */
public class MyArrayDataException extends Exception {
    public int i;
    public int j;

    public MyArrayDataException (int i, int j) {
        this.i = i;
        this.j = j;
    }
}
