package com.unicamp.mc322.duocomopeda.game.event.handler;

import com.unicamp.mc322.duocomopeda.game.player.Player;
import com.unicamp.mc322.duocomopeda.game.card.Card;

public interface SpellEventHandler {
    
    public void onPlay(Player owner, Card playedCard);

}
