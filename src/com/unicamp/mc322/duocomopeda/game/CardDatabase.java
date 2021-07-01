package com.unicamp.mc322.duocomopeda.game;

import java.util.ArrayList;

import com.unicamp.mc322.duocomopeda.game.card.Card;
import com.unicamp.mc322.duocomopeda.game.card.effect.Effect;
import com.unicamp.mc322.duocomopeda.game.card.effect.EffectTrigger;
import com.unicamp.mc322.duocomopeda.game.card.minion.champion.Champion;
import com.unicamp.mc322.duocomopeda.game.card.traits.Fury;

public class CardDatabase {

    public static CardDatabase cardDatabase;

    private ArrayList<Card> cards;

    public static CardDatabase getInstance() {
        if (cardDatabase == null) {
            cardDatabase = new CardDatabase();
        }
        return cardDatabase;
    }

    private CardDatabase() {
        cards = new ArrayList<Card>();
    }

    public void load() {
        cards.add(new Champion("DE001", "Garen", 5, 5, 5, 
            [new Effect(EffectTrigger.ON_ROUND_END, EffectType.HEAL_FULL)]
        ));
        cards.add(new Minion("DE002", "Tiana", 8, 7, 7,
            [new Effect(EffectTrigger.ON_PLAY, EffectType.ATTACK_NEXUS)],
            []
        ));
        cards.add(new Minion("DE003", "Vanguard", 5, 5, 5,
            [new Effect(EffectTrigger.ON_PLAY, EffectType.BUFF_ALL)],
            []
        ));
        cards.add(new Minion("DE004", "Duelist", 3, 3, 2, 
            [new Effect(EffectTrigger.ON_MINION_KILL, EffectType.ADD_CARD)],
            []
        ));
        cards.add(new Minion("DE005", "Defender", 2, 2, 2
            [],
            [new Fury()]
        ));
        cards.add(new Minion("DE006", "Poro", 1, 2, 1, 
            [],
            []
        ));
        cards.add(new Minion("DE007", "Poro Defender", 1, 1, 2, 
            [new Effect(EffectTrigger.ON_DEATH, EffectType.DRAW_CARD)],
            []
        ));
        cards.add(new Spell("DE008", "Judgement", 8, 
            [new Effect(EffectType.ATTACK_ALL)]
        ));
        cards.add(new Spell("DE009", "Redoubled Valor", 6,
            [new Effect(EffectType.HEAL_FULL),
            new Effect(EffectType.DOUBLE_ATTACK_DEFENSE)]
        ));
        cards.add(new Spell("DE010", "Radiant Strike", 1,
            [new Effect(EffectType.BUFF)]
        ));
        cards.add(new Spell("DE011", "Single Combat", 2,
            [new Effect(EffectType.DUEL)]
        ));
        
    }

    public Card getCard(String cardID) {
        for (Card card : cards) {
            if (card.hasID(cardID)) {
                return card;
            }
        }
        System.out.println("Card not found.");
        return null;
    }
}
