package com.unicamp.mc322.duocomopeda.game.event;

import com.unicamp.mc322.duocomopeda.game.card.Card;
import com.unicamp.mc322.duocomopeda.game.player.Player;

public class OnPlayEvent extends Event {

    public OnPlayEvent(Player owner, Card playedCard) {
        super(owner);
        this.playedCard = playedCard;
    }

    private Card playedCard;

    public Card getPlayedCard() {
        return playedCard;
    }
}
