package org.example.game;

import org.example.game.Boss;
import org.example.game.Hero;
import org.example.game.SuperAbility;

public class Berserk extends Hero {
    public Berserk(int health, int damage, SuperAbility ability, String name) {
        super(health, damage, ability, name);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if(boss.getHealth() > 0 && this == heroes [i]){
                heroes[i].setDamage(boss.getDamage() / 2 + heroes[i].getDamage());
                System.out.println(this.getName() + " использовал суперспособность и усилил урон ");
            }

        }
    }

}
