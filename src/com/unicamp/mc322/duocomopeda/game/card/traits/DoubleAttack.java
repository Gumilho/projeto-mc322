package com.unicamp.mc322.duocomopeda.game.card.traits;

import com.unicamp.mc322.duocomopeda.game.card.Minion;
import com.unicamp.mc322.duocomopeda.game.card.effect.EffectTrigger;

public class DoubleAttack extends Trait {
    public static DoubleAttack instance;

    private DoubleAttack(EffectTrigger trigger) {
        super(trigger);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void activate() {
        // TODO Auto-generated method stub

    }

    // como realizar de fato o ataque duplo? eu chamaria a função do minion
    public DoubleAttack getInstance() {
        if (instance == null) {
            return new DoubleAttack(EffectTrigger.ON_HIT);
        } else
            return instance;
    }

}
