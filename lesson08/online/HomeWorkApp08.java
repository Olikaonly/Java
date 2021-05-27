package lesson08.online;

import lesson05.online.CoWorker;

/**
 * Created by Olga Shestakova
 * Date 25.05.2021
 */
public class HomeWorkApp08 {
    public static void main(String[] args) {

//        OvercomeObstacles[] overcomeObstacles = {
//                new Human("Bob"),
//                new Cat("Kitty")
//        };

        // Не получается реализовать -
        // Создайте два массива: с участниками и препятствиями, и заставьте всех участников пройти этот набор препятствий.

        Human human = new Human("Bob");
        Cat cat = new Cat("Kitty");

        Obstacles[] obstacles = {
                new Wall(),
                new Treadmill()
        };

        for (Obstacles o : obstacles) {
            human.jump(o);
            human.run(o);
            cat.jump(o);
            cat.run(o);
        }

    }

    }

