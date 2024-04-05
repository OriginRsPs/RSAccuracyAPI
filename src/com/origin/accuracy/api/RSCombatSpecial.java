package com.origin.accuracy.api;

/**
 * RSCombatSpecial interface represents a combat special attack in a combat scenario.
 */
public interface RSCombatSpecial {

    /**
     * Retrieves the combat special.
     *
     * @return The combat special.
     */
    RSCombatSpecial get();

    /**
     * Retrieves the accuracy multiplier associated with the combat special.
     *
     * @return The accuracy multiplier.
     */
    double getAccuracyMultiplier();
}

