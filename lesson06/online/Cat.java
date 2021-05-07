package lesson06.online;

import java.util.Random;

/**
 * Created by Olga Shestakova
 * Date 06.05.2021
 */
public class Cat extends Animals {

    public Cat(String name, int run, int swim) {
        super(name, run, swim);
    }

    private static Random random = new Random();

    @Override
    public void run(int run){
        int min = 1; int max = 200; int diff = max - min;
        int i = random.nextInt(diff + 1);
        System.out.println(name + " run "  + i + " м!");
    }
    @Override
    public void swim(int swim){
        System.out.println(name + " I don't swim");
    }
}

