package com.unicamp.mc322.duocomopeda.stats;

public class Mana {

    private final int MAX = 10;
    private final int MAX_SPELL = 3;

    private int currentMax;

    private int currentMana;

    private int spellMana;

    public Mana() {
        currentMana = 1;
        spellMana = 0;
        currentMax = 0;
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
        if (currentMana - quantity >= 0) {
            // TODO: tratamento de erro
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

    }

}