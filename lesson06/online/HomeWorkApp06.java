package lesson06.online;

import java.util.Random;
/**
 * Created by Olga Shestakova
 * Date 06.05.2021
 */
public class HomeWorkApp06 {
    private static Random random = new Random();

    public static void main(String[] args){

        Dog dog = new Dog("Milo", 500, 10);
        Cat cat = new Cat("Luna", 200, 0);
        Dog dog1 = new Dog("Teddy", 500,10);
        Cat cat1 = new Cat("Bella", 200, 0);

        dog.speak();
        cat.speak();
        dog1.speak();
        cat1.speak();

        System.out.println("************************");

        dog.run(random.nextInt());
        cat.run(random.nextInt());
        dog1.run(random.nextInt());
        cat1.run(random.nextInt());

        System.out.println("************************");

        dog.swim(random.nextInt());
        cat.swim(random.nextInt());
        dog1.swim(random.nextInt());
        cat1.swim(random.nextInt());
    }
}
