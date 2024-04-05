package com.origin.accuracy.api;

/**
 * RSPlayer interface represents a player in the game.
 */
public interface RSPlayer {

    /**
     * Retrieves the player itself.
     *
     * @return The player itself.
     */
    RSPlayer get();

    /**
     * Retrieves the combat special associated with the player.
     *
     * @return The combat special associated with the player.
     */
    RSCombatSpecial getCombatSpecial();

    /**
     * Checks whether the special attack is activated for the player.
     *
     * @return True if the special attack is activated, otherwise false.
     */
    boolean isSpecialActivated();
}

