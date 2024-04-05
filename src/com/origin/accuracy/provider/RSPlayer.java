package com.origin.accuracy.provider;

public interface RSPlayer {
    Class<? extends RSPlayer> get();
    Class<? extends RSCombatSpecial> getCombatSpecial();
    boolean isSpecialActivated();
}
