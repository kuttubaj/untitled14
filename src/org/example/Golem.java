package org.example;

import org.example.game.Boss;
import org.example.game.Hero;
import org.example.game.SuperAbility;


public class Golem extends Hero {


    public Golem(int health, int damage, SuperAbility ability, String name) {
        super(health, damage, ability, name);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {

    }
}
