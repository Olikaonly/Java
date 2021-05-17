package lesson07.online.models;

import lesson07.online.LightSoldier;
import lesson07.online.DarkSoldier;
import lesson07.online.HealerSoldier;

import java.util.Random;

/**
 * Created by Olga Shestakova
 * Date 14.05.2021
 */

public abstract class Soldier {

    protected String name;
    protected float attack;
    protected float defense;
    protected float hp;
    protected float heal;
    private Random random = new Random();

    public Soldier(String name, int attack, float defense, float hp, float heal) {
        this.name = name;
        this.attack = attack;
        this.defense = defense;
        this.heal = heal;
        if (hp < 0) {
            this.hp = -hp;
        } else {
            this.hp = hp;
        }
    }

    public void attack(Soldier enemy) {
        if (enemy != this) {
            float dealDamage = (this.attack - (this.attack / enemy.defense)) * random.nextFloat();
            enemy.hp -= dealDamage;
            System.out.println(this.name + " deal damage > " + enemy.name + " >> " + dealDamage + " dmg.");
        } else {
            System.out.println("It's me");
        }

    }

    public void healRandom(Soldier enemy) {
        if (enemy != this) {
            float heal = (this.heal + (this.heal / enemy.defense)) * random.nextFloat();
            enemy.hp += heal;
            System.out.println(this.name + " heal > " + enemy.name + " >> " + heal + " hp.");
        } else {
            System.out.println("It's me");
        }
    }

    public void healSelf() {
        float summaryHeal = 0.5f * this.defense + 1;
        this.hp += summaryHeal;
        System.out.println(this.name + " heal self " + summaryHeal + ". My hp = " + this.hp);
}

    public String getMeInfo() {
        return "My name is " + this.name + ". My attack " + this.attack + ". My health is " + this.hp;
    }

    public boolean isDeadHero() {

        return this.hp <= 0;
    }

    public String getName() {

        return name;
    }

    public float getAttack() {

        return attack;
    }

    public float getDefense() {

        return defense;
    }

    public float getHp() {

        return hp;
    }
    public float getHeal(){

            return heal;
    }

}
