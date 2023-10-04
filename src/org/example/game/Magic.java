package org.example.game;

import org.example.GameEntity;

public class Magic extends Hero {

    public Magic(int health, int damage, SuperAbility ability, String name) {
        super(health, damage, ability, name);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        int damageImprovement = 5;
        for (int i = 0; i < heroes.length; i++) {
            if (this.getHealth() > 0) {
                heroes[i].setDamage(heroes[i].getDamage() + damageImprovement);
            }
        }
        System.out.println(this.getName() + " использовал суперспособность и усилил урон ");


        }


    }

