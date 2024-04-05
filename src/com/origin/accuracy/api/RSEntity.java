package com.origin.accuracy.api;

/**
 * RSEntity interface represents an entity in the game, which can be either an NPC or a player.
 */
public interface RSEntity {

    /**
     * Retrieves the NPC representation of this entity, if applicable.
     *
     * @return The NPC representation of this entity, or null if this entity is not an NPC.
     */
    RSNpc getNpc();

    /**
     * Retrieves the Player representation of this entity, if applicable.
     *
     * @return The Player representation of this entity, or null if this entity is not a player.
     */
    RSPlayer getPlayer();

    /**
     * Retrieves the combat type of this entity.
     *
     * @return The combat type of this entity.
     */
    RSCombatType getCombatType();
}

