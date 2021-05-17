package lesson07.online;

import lesson07.online.models.Soldier;

/**
 * Created by Olga Shestakova
 * Date 14.05.2021
 */

public class HomeWorkApp07 {
    private static int round = 1;

    public static void main(String[] args) throws InterruptedException {
        LightSoldier lightSoldier = new LightSoldier("LightSoldier", 15, 25f, 100f, 0f);
        DarkSoldier darkSoldier = new DarkSoldier("DarkSoldier", 20, 5f, 150f, 0f);
        HealerSoldier healerSoldier = new HealerSoldier("HealerSoldier", 1, 5f , 50, 7f);


        while (!lightSoldier.isDeadHero() || !darkSoldier.isDeadHero()) {
            System.out.println("*** Round " + round + " ***");
            System.out.println(lightSoldier.getMeInfo());
            System.out.println(darkSoldier.getMeInfo());
            System.out.println(healerSoldier.getMeInfo());

            lightSoldier.attack(darkSoldier);

            if (darkSoldier.isDeadHero()) {
                System.out.println(lightSoldier.getName() + " win!");
                break;
            }

            healerSoldier.healRandom(darkSoldier);

            darkSoldier.attack(lightSoldier);

            if (lightSoldier.isDeadHero()) {
                System.out.println(darkSoldier.getName() + " win!");
                break;
            }

            healerSoldier.healRandom(lightSoldier);

            round++;

            Thread.sleep(3000);
        }
    }
}
