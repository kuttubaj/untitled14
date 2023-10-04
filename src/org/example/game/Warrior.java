package org.example.game;

import org.example.GameEntity;

public class Warrior extends Hero {

    public Warrior(int health, int damage, SuperAbility ability, String name) {
        super(health, damage, ability, name);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {

    }
}
