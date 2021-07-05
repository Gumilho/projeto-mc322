package com.unicamp.mc322.duocomopeda.game.event.handler;

import com.unicamp.mc322.duocomopeda.game.card.Card;
import com.unicamp.mc322.duocomopeda.game.card.minion.Minion;
import com.unicamp.mc322.duocomopeda.game.player.*;

public interface MinionEventHandler {

    public void onPlay(Player owner, Card playedCard);
    public void onKill(Player owner, Minion killer, Minion killed);
    public void onDeath(Player owner, Minion killed);
    public void onHit(Player owner, Minion attacker, Minion defender, int damage);
    public void onTakeDamage(Player owner, Minion target, int damage);
    public void onDefense(Player owner, Minion attacker, Minion defender, int damage);
    public void onRoundEnd(Player owner);

}