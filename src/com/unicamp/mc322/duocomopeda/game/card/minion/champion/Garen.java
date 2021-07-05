package com.unicamp.mc322.duocomopeda.game.card.minion.champion;

import java.util.EnumSet;

import com.unicamp.mc322.duocomopeda.game.card.minion.Trait;
import com.unicamp.mc322.duocomopeda.game.player.Player;
import com.unicamp.mc322.duocomopeda.game.card.minion.Minion;

public class Garen extends Champion {

    public Garen(Player owner) {
        super(
            "Garen", 
            5, 
            5, 
            5, 
            EnumSet.of(Trait.ELUSIVE), 
            owner,
            4,
            "Effect: Heals himself at the end of the round. Level Up: After striking twice. Evolution: Gain \"Elusive\"; +1 power; +1 health."
        );
    }

    @Override
    public void onHit(Player owner, Minion attacker, Minion defender, int damage) {
        this.incrementMission(1);        
    }

    @Override
    void upgrade() {
        this.buff(1, 1);
        this.addTrait(Trait.ELUSIVE);
    }
}
