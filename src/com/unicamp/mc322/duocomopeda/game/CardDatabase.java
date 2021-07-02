package com.unicamp.mc322.duocomopeda.game;

import java.util.ArrayList;

import com.unicamp.mc322.duocomopeda.game.card.Card;
import com.unicamp.mc322.duocomopeda.game.card.effect.Effect;
import com.unicamp.mc322.duocomopeda.game.card.effect.EffectTrigger;
import com.unicamp.mc322.duocomopeda.game.card.effect.targeted.instant.Duel;
import com.unicamp.mc322.duocomopeda.game.card.effect.targeted.instant.HealCompletely;
import com.unicamp.mc322.duocomopeda.game.card.effect.targeted.instant.HitAllDefenders;
import com.unicamp.mc322.duocomopeda.game.card.effect.targeted.permanent.DoubleStats;
import com.unicamp.mc322.duocomopeda.game.card.effect.targeted.temporary.BuffSingle;
import com.unicamp.mc322.duocomopeda.game.card.effect.untargeted.BuffAllAllies;
import com.unicamp.mc322.duocomopeda.game.card.effect.untargeted.draw.DrawRandomCard;
import com.unicamp.mc322.duocomopeda.game.card.minion.Minion;
import com.unicamp.mc322.duocomopeda.game.card.minion.champion.Champion;
import com.unicamp.mc322.duocomopeda.game.card.traits.*;
import com.unicamp.mc322.duocomopeda.game.card.effect.*;

public class CardDatabase {

    private static CardDatabase cardDatabase;

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
        /*
        cards.add(new Champion("DE001", "Garen", 5, 5, 5, 
            [new HealCompletely(true, EffectTrigger.ON_ROUND_END)]
        ));
        cards.add(new Minion("DE002", "Tiana", 8, 7, 7,
            [new AttackNexus(false, EffectTrigger.ON_PLAY)],
            []
        ));
        cards.add(new Minion("DE003", "Vanguard", 5, 5, 5,
            [new BuffAllAllies(false, EffectTrigger.ON_PLAY)],
            []
        ));
        cards.add(new Minion("DE004", "Duelist", 3, 3, 2, 
            [new DrawSpecificCard(true, EffectTrigger.ON_OPPONENT_DEATH)],
            []
        ));
        cards.add(new Minion("DE005", "Defender", 2, 2, 2
            [],
            [new Fury()]
        ));
        */
        cards.add(new Minion("DE006", "Poro", 1, 2, 1, 
            new Trait[]{},
            new Effect[]{}
        ));
        /*
        cards.add(new Minion("DE007", "Poro Defender", 1, 1, 2, 
            [new DrawRandomCard(false, EffectTrigger.ON_DEATH)],
            []
        ));
        cards.add(new Spell("DE008", "Judgement", 8, 
            [new HitAllDefenders(false, EffectTrigger.ON_PLAY)]
        ));
        cards.add(new Spell("DE009", "Redoubled Valor", 6,
            [new HealCompletely(false, EffectTrigger.ON_PLAY),
            new DoubleStats(false, EffectTrigger.ON_PLAY)]
        ));
        cards.add(new Spell("DE010", "Radiant Strike", 1,
            [new BuffSingle(false, EffectTrigger.ON_PLAY)]
        ));
        cards.add(new Spell("DE011", "Single Combat", 2,
            [new Duel(false, EffectTrigger.ON_PLAY)]
        ));
        */
    }

    public Card getCardByName(String cardName) {
        for (Card card : cards) {
            if (card.hasID(cardName)) {
                // Cloning the card
                try {
                    return (Card) card.clone();
                } catch (CloneNotSupportedException e) {
                    System.out.println("Unexpected error occured");
                    System.out.println(e);
                }
            }
        }
        System.out.println("Card not found.");
        return null;
    }

    public Card getCardByID(String cardID) {
        for (Card card : cards) {
            if (card.hasID(cardID)) {
                // Cloning the card
                try {
                    return (Card) card.clone();
                } catch (CloneNotSupportedException e) {
                    System.out.println("Unexpected error occured");
                    System.out.println(e);
                }
            }
        }
        System.out.println("Card not found.");
        return null;
    }
}
