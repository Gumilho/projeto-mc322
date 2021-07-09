package com.unicamp.mc322.duocomopeda.game.stats;

public class Mana {

    private final int MAX = 10;
    private final int MAX_SPELL = 3;

    private int currentMax;

    private int currentMana;

    private int spellMana;

    public Mana() {
        currentMana = 1;
        spellMana = 0;
        currentMax = 1;
    }

    public int getCurrentMana() {
        return currentMana;
    }

    public int getCurrentMana(Boolean spell) {
        if (spell) {
            return currentMana + spellMana;
        } else
            return currentMana;
    }

    public void spend(int quantity) {
        if (currentMana - quantity < 0) {
            throw new IllegalArgumentException("Out of mana");
        }
        currentMana -= quantity;
    }

    public void spendSpell(int quantity) {
        if (currentMana + spellMana - quantity < 0) {
            throw new IllegalArgumentException("Out of mana");
        }
        currentMana -= quantity;
    }

    public void update() {
        if (currentMana > 0) {
            bankSpellMana();
        }
        getNewMaxMana();
        recover();
    }

    private void recover() {
        currentMana = currentMax;
    }

    private void bankSpellMana() {
        spellMana += currentMana;
        if (spellMana > MAX_SPELL) {
            spellMana = MAX_SPELL;
        }
    }

    private void getNewMaxMana() {
        currentMax++;
        if (currentMax > MAX) {
            currentMax = MAX;
        }
    }

    public int getMaxMana() {
        return currentMax;
    }

    public int getCurrentSpellMana() {
        return spellMana;
    }

    public int getMaxSpellMana() {
        return MAX_SPELL;
    }

}