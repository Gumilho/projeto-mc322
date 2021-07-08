package com.unicamp.mc322.duocomopeda.game;

import java.util.ArrayList;

import com.unicamp.mc322.duocomopeda.game.player.Player;
import com.unicamp.mc322.duocomopeda.game.card.minion.Minion;

public class EffectManager {

    public static void drawSpecificCard(Player player, String cardName) {
        player.getFromDeck(cardName);
    }

    public static void drawCard(Player player, int numberOfCards) {
        player.draw(numberOfCards);
    }

    public static void attackNexus(Player player) {
        Minion ally = player.chooseAllyUnit();
        Game game = Game.getInstance();
        Player otherPlayer = game.getOpponent(player);
        ally.attack(otherPlayer);
    }

    public static void attackNexus(Player player, int damage) {
        Game game = Game.getInstance();
        Player otherPlayer = game.getOpponent(player);
        otherPlayer.takeDamage(damage);
    }

    public static void buffSingleAlly(Player player, int power, int health) {
        Minion ally = player.chooseAllyUnit();
        ally.buff(power, health);
    }

    public static void buffAllAllies(Player player, int power, int health) {
        Board board = Board.getInstance();
        ArrayList<Minion> minions = board.getBenchArraylist(player);
        for (Minion minion : minions) {
            minion.buff(power, health);
        }
    }

    public static void hitAllDefenders(Player player) {
        Board board = Board.getInstance();
        Game game = Game.getInstance();
        Minion minion = player.chooseAllyUnit();
        ArrayList<Minion> defenders = board.getBenchArraylist(game.getOpponent(player));
        for (Minion defender : defenders) {
            minion.strike(defender);
        }
    }

    public static void duel(Player player) {
        Minion ally = player.chooseAllyUnit();
        Minion enemy = player.chooseEnemyUnit();
        ally.attack(enemy);
    }

    public static void healCompletely(Minion target) {
        target.healCompletely();
    }

    public static void healCompletely(Player player) {
        Minion ally = player.chooseAllyUnit();
        ally.healCompletely();
    }

    public static void doubleStats(Player player) {
        Minion ally = player.chooseAllyUnit();
        ally.doubleStats();
    }

    public static void zeroPower(Player player) {
        Minion enemy = player.chooseEnemyUnit();
        enemy.zeroPower();
    }

    public static void addBarrier(Player player) {
        Minion ally = player.chooseAllyUnit();
        ally.addBarrier();
    }
}
