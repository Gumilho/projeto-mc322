package com.unicamp.mc322.duocomopeda.game.card.spell;

import com.unicamp.mc322.duocomopeda.game.card.Card;
import com.unicamp.mc322.duocomopeda.game.card.effect.Effect;
public class Spell extends Card {

    public Spell(String id, String name, int cost, Effect[] effects) {
        super(id, name, cost, effects);
    }
}