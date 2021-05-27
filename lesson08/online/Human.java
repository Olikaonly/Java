package lesson08.online;

/**
 * Created by Olga Shestakova
 * Date 25.05.2021
 */
public class Human implements OvercomeObstacles {

    private String name;

    public Human(String name) {
        this.name = name;
    }

    public void run(Obstacles obstacles) {
        obstacles.run(obstacles);
        System.out.println(name + " Бежит по дорожке");
    }

    public void jump(Obstacles obstacles) {
        obstacles.jump(obstacles);
        System.out.println(name + " Прыгает через стену");
    }

}
