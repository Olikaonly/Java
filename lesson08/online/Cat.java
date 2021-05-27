package lesson08.online;

/**
 * Created by Olga Shestakova
 * Date 25.05.2021
 */
public class Cat implements OvercomeObstacles {
    private String name;

    public Cat(String name) {
        this.name = name;
    }

    @Override
    public void run(Obstacles obstacles) {
        obstacles.run(obstacles);
        System.out.println(name + " Бежит по дорожке");
    }
    @Override
    public void jump(Obstacles obstacles) {
        obstacles.jump(obstacles);
        System.out.println(name + " Прыгает через стену");
    }

}
