package com.unicamp.mc322.duocomopeda.game.card;

public enum EffectTypes {
    BUFF, // dura uma rodada
    BUFF_ALL, ON_KILL_DRAW_MINION, HEAL_FULL, DOUBLE_ATTACK_DEFENSE, DUEL, // escolhe duas cartas para lutarem
    HIT_NEXUS, HIT_ALL_DEFENDANTS, ON_DEATH_DRAW_CARD, NULL_OPPONENT_ATTACK, // nesta rodada o oponente fica com 0 de
                                                                             // ataque
    BARRIER, // bloqueia próximo ataque, dura uima rodada
    DAMAGE_NEXUS

}
