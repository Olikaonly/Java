package lesson06.online;

import java.util.Random;

/**
 * Created by Olga Shestakova
 * Date 06.05.2021
 */
public class Animals {
    protected String name;
    protected int run;
    protected int swim;

    public Animals(String name, int run, int swim){
        this.name = name;
        this.run = run;
        this.swim = swim;
    }

    public void speak() {
        System.out.println(name + " says Hello!");
    }
    private static Random random = new Random();

    public void run(int run){
        int min = 1; int max = 500; int diff = max - min;
        int i = random.nextInt(diff + 1);

        System.out.println(name + " run "  + i + " м!");
    }
    public void swim(int swim){
        int min = 1; int max = 10; int diff = max - min;
        int i = random.nextInt(diff + 1);
        System.out.println(name + " swim "  + i + " м!");
    }

    }
