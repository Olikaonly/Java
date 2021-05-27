package lesson08.online;

/**
 * Created by Olga Shestakova
 * Date 25.05.2021
 */
public class HomeWorkApp08 {
    public static void main(String[] args) {

        Obstacles[] obstacles = {
                new Treadmill(), new Wall()
        };

        OvercomeObstacles[] overcomeObstacles = {
                new Cat("Kitty") , new Human("Bob")
        };

        for (Obstacles o : obstacles) {
            for (OvercomeObstacles v : overcomeObstacles) {
                v.run(o);
                v.jump(o);
            }
            break;
        }

    }
}

