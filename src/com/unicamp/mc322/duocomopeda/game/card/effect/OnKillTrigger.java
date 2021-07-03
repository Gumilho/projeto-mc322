package com.unicamp.mc322.duocomopeda.game.card.effect;

import com.unicamp.mc322.duocomopeda.game.card.Card;
import com.unicamp.mc322.duocomopeda.game.card.minion.Minion;
import com.unicamp.mc322.duocomopeda.game.player.Player;

public class OnKillTrigger extends Trigger {
    public OnKillTrigger(Player owner, Minion killer, Minion deadCard) {
        super(owner);
        this.killer = killer;
        this.deadCard = deadCard;
    }

    private Player owner;
    private Minion deadCard;
    private Minion killer;
    private EffectTrigger trigger = EffectTrigger.ON_KILL;

    public Player getOwner() {
        return owner;
    }

    public Minion getKiller() {
        return killer;
    }

    public Card getDeadCard() {
        return deadCard;
    }

    public EffectTrigger getTrigger() {
        return trigger;
    }
}
