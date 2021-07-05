package com.unicamp.mc322.duocomopeda.game.event;

import com.unicamp.mc322.duocomopeda.game.card.Card;
import com.unicamp.mc322.duocomopeda.game.player.Player;

public class OnDeathEvent extends Event {
    
    public OnDeathEvent(Player owner, Card playedCard) {
        super(owner);
        this.playedCard = playedCard;
    }

    private Card playedCard;

    public Card getPlayedCard() {
        return playedCard;
    }
}
