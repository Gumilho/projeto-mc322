package com.unicamp.mc322.duocomopeda.game.event;

import com.unicamp.mc322.duocomopeda.game.Board;
import com.unicamp.mc322.duocomopeda.game.card.effect.Trigger;

public class EventManager {
    
    private static EventManager eventManager;

    public static EventManager getInstance() {
        if (eventManager == null) {
            eventManager = new EventManager();
        }
        return eventManager;
    }

    private EventManager() {
    }
/*
    public static void trigger(Event event) {
        Board board = Board.getInstance();
        board.triggerAllCards(event);
    }
    */
}
