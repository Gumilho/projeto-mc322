package com.unicamp.mc322.duocomopeda.game.card.event;

import com.unicamp.mc322.duocomopeda.game.card.Card;
import com.unicamp.mc322.duocomopeda.game.card.minion.Minion;

public interface MinionEventHandler {

    public void onPlay(Card playedCard);

    public void onKill(Minion killer, Minion killed);

    public void onDeath(Minion killed);

    public void onHit(Minion attacker, Minion defender, int damage);

    public void onTakeDamage(Minion target, int damage);

    public void onDefense(Minion attacker, Minion defender, int damage);

    public void onRoundEnd();

}