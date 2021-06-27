package com.unicamp.mc322.duocomopeda.game.card.effect;

public abstract class Effect {

    private EffectTriggerTypes trigger;
    private boolean repeatable;

    public Effect(boolean repeatable) {
        this.repeatable = repeatable;
    }

    public EffectTriggerTypes getTrigger() {
        return trigger;
    }

    public boolean isRepeatable() {
        return repeatable;
    }

    public abstract void activate();

    /*
     * 
     * compromisso entre ser simples e funcional - uma classe pra cada efeito - cada
     * efeito pode ser um subscriber - ter uma noção do estado dojogo
     * 
     * 
     * 
     */

}