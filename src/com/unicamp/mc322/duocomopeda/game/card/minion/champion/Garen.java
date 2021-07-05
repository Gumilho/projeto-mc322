package com.unicamp.mc322.duocomopeda.game.card.minion.champion;

import com.unicamp.mc322.duocomopeda.game.card.traits.Elusive;
import com.unicamp.mc322.duocomopeda.game.card.traits.Trait;
import com.unicamp.mc322.duocomopeda.game.player.Player;
import com.unicamp.mc322.duocomopeda.game.card.minion.Minion;

public class Garen extends Champion {

    public Garen(Player owner) {
        super(
            "Garen", 
            5, 
            5, 
            5, 
            new Trait[]{}, 
            owner,
            4
        );
    }

    @Override
    public void onHit(Player owner, Minion attacker, Minion defender, int damage) {
        this.incrementMission(1);
        
    }

    @Override
    void upgrade() {
        this.buff(1, 1);
        this.addTrait(new Elusive());
    }
}
