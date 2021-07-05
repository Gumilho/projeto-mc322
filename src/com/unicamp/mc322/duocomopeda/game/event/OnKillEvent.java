package com.unicamp.mc322.duocomopeda.game.event;

import com.unicamp.mc322.duocomopeda.game.card.Card;
import com.unicamp.mc322.duocomopeda.game.card.minion.Minion;
import com.unicamp.mc322.duocomopeda.game.player.Player;

public class OnKillEvent extends Event {
    
    public OnKillEvent(Player owner, Minion killer, Minion deadCard) {
        super(owner);
        this.killer = killer;
        this.deadCard = deadCard;
    }

    private Minion deadCard;
    private Minion killer;

    public Minion getKiller() {
        return killer;
    }

    public Card getDeadCard() {
        return deadCard;
    }

}
