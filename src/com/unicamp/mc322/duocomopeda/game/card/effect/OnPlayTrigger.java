package com.unicamp.mc322.duocomopeda.game.card.effect;

import com.unicamp.mc322.duocomopeda.game.card.Card;
import com.unicamp.mc322.duocomopeda.game.player.Player;

public class OnPlayTrigger extends Trigger {
    public OnPlayTrigger(Player owner, Card playedCard) {
        super(owner);
        this.playedCard = playedCard;
    }

    private Player owner;
    private Card playedCard;

    public Player getOwner() {
        return owner;
    }

    public Card getPlayedCard() {
        return playedCard;
    }
}
