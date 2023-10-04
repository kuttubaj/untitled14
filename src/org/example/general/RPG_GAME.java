package org.example.general;

import org.example.game.Berserk;
import org.example.Golem;
import org.example.game.*;

public class RPG_GAME {
    public static void start() {
        Boss boss = new Boss(700, 50);
        Magic magic = new Magic(250, 25, SuperAbility.BOOST, "MAG ");
        Golem golem = new Golem(250, 20, SuperAbility.STUN, "Golem ");
        Warrior warrior = new Warrior(250, 25, SuperAbility.CRITICAL_DAMAGE, "Voin ");
        Berserk berserk = new Berserk(250, 60, SuperAbility.SAVE_DAMAGE_AND_REVERT, "Berserk ");
        Medic medic = new Medic(1150,0,SuperAbility.HEAL,"Medic");

        Hero[] heroes = {medic,magic, golem, warrior,berserk};
        printStatistics(boss, heroes);

        while (!iGameFinish(boss, heroes)) {
            round(boss, heroes);
        }
    }

    private static boolean iGameFinish(Boss boss, Hero[] heroes) {
        if (boss.getHealth() <= 0) {
            System.out.println("Heroes won!!!");
            return true;
        }
        boolean allHeroesDead = true;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                allHeroesDead = false;
                break;
            }

        }
        if (allHeroesDead) {
            System.out.println("Boss won");
        }
        return allHeroesDead;
    }


    private static void printStatistics(Boss boss, Hero[] heroes) {
        System.out.println("_____________");
        System.out.println("Boss health" + boss.getHealth() + "[" + boss.getDamage() + "]");
        for (int i = 0; i < heroes.length; i++) {
            System.out.println(heroes[i].getName() + "health" + heroes[i].getHealth() +
                    "[" + heroes[i].getDamage() + "]");

        }
    }

    private static void round(Boss boss, Hero[] heroes) {
        if (boss.getHealth() > 0) {
            bossHits(boss, heroes);
        }

        heroesHits(boss, heroes);
        printStatistics(boss,heroes);
    }

    private static void bossHits(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                heroes[i].setHealth(heroes[i].getHealth() - boss.getDamage());
            }
        }
    }

    private static void heroesHits(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (boss.getHealth() > 0 && heroes[i].getHealth() > 0) {
                boss.setHealth(boss.getHealth() - heroes[i].getDamage());
                heroes[i].applySuperAbility(boss,heroes);
            }

        }
    }
}
