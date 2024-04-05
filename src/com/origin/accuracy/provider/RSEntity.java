package com.origin.accuracy.provider;

public interface RSEntity {
    Class<? extends RSNpc> getNpc();
    Class<? extends RSPlayer> getPlayer();
    Class<? extends RSCombatType> getCombatType();
}
