package com.origin.accuracy;

import com.origin.accuracy.provider.RSCombatType;
import com.origin.accuracy.provider.RSEntity;
import com.origin.accuracy.provider.RSPlayer;

/**
 * AbstractAccuracy interface represents the accuracy of an attack in a combat scenario
 * between an attacker and a defender.
 *
 * @author OriginRsPs
 * @see <a href="https://github.com/OriginRsPs">GitHub: OriginRsPs</a>
 * @since April 5, 2024
 */
public interface AbstractAccuracy {

    /**
     * Retrieves the attacker entity involved in the combat.
     *
     * @return The attacker entity.
     */
    RSEntity attacker();

    /**
     * Retrieves the defender entity involved in the combat.
     *
     * @return The defender entity.
     */
    RSEntity defender();

    /**
     * Retrieves the combat type (e.g., melee, ranged, magic).
     *
     * @return The combat type.
     */
    RSCombatType getCombatType();

    /**
     * Retrieves the modifier for the attack.
     *
     * @return The attack modifier.
     */
    int modifier();

    /**
     * Retrieves the equipment bonus for the attacker.
     *
     * @return The equipment bonus for the attacker.
     */
    int getEquipmentBonusForAttacker();

    /**
     * Retrieves the equipment bonus for the defender.
     *
     * @return The equipment bonus for the defender.
     */
    int getEquipmentBonusForDefender();

    /**
     * Retrieves the offensive skill level of the attacker.
     *
     * @return The offensive skill level of the attacker.
     */
    int getOffensiveSkillLevelAttacker();

    /**
     * Retrieves the defensive skill level of the defender.
     *
     * @return The defensive skill level of the defender.
     */
    int getDefensiveSKillLevelDefender();

    /**
     * Retrieves the prayer bonus for the attacker.
     *
     * @return The prayer bonus for the attacker.
     */
    double getPrayerBonusAttacker();

    /**
     * Retrieves the prayer bonus for the defender.
     *
     * @return The prayer bonus for the defender.
     */
    double getPrayerBonusDefender();

    /**
     * Retrieves the offensive style bonus.
     *
     * @return The offensive style bonus.
     */
    int getOffensiveStyleBonus();

    /**
     * Retrieves the defensive style bonus.
     *
     * @return The defensive style bonus.
     */
    int getDefensiveStyleBonus();

    /**
     * Calculates the success of an attack based on the selected chance.
     *
     * @param selectedChance The selected chance of success.
     * @return True if the attack is successful, otherwise false.
     * @throws RuntimeException if the attacker is null.
     */
    default boolean success(double selectedChance) throws RuntimeException {
        double chance;
        double specialMultiplier = 0.0D;
        if (this.attacker() == null) throw new RuntimeException("Null Entity");
        if (this.attacker() instanceof RSPlayer player) specialMultiplier = getSpecialMultiplier(player);
        int attackRoll = this.getAttackRoll();
        if (specialMultiplier > 0.0D) attackRoll *= specialMultiplier;
        int defenceRoll = this.getDefenceRoll();
        if (attackRoll > defenceRoll) chance = 1D - (defenceRoll + 2D) / (2D * (attackRoll + 1D));
        else chance = attackRoll / (2D * (defenceRoll + 1D));
        return chance > selectedChance;
    }

    /**
     * Calculates the attack roll based on various factors such as modifier, skill levels, etc.
     *
     * @return The attack roll.
     */
    default int getAttackRoll() {
        double modification = this.modifier();
        double prayerBonus = this.getPrayerBonusAttacker();
        int attackLevel = this.getOffensiveSkillLevelAttacker();
        attackLevel *= prayerBonus;
        attackLevel += 8;
        int effectiveAttack = attackLevel + this.getEffectiveLevel();
        int equipmentBonus = this.getEquipmentBonusForAttacker();
        int attackRoll = effectiveAttack * (equipmentBonus + 64);
        if (modification > 0) attackRoll *= modification;
        return attackRoll;
    }

    /**
     * Calculates the defence roll based on various factors such as equipment bonus, skill levels, etc.
     *
     * @return The defence roll.
     * @throws RuntimeException if the defender is null.
     */
    default int getDefenceRoll() throws RuntimeException {
        int effectiveDefence;
        double prayerBonus = this.getPrayerBonusDefender();
        int defenceLevel = this.getDefensiveSKillLevelDefender();
        defenceLevel *= prayerBonus;
        int equipmentBonus = this.getEquipmentBonusForDefender();
        if (this.defender() == null) throw new RuntimeException("Null Entity");
        if (this.defender() instanceof RSPlayer) {
            effectiveDefence = defenceLevel;
            effectiveDefence += getDefensiveStyleBonus();
        } else effectiveDefence = defenceLevel + 9;
        return effectiveDefence * (equipmentBonus + 64);
    }

    /**
     * Calculates the effective level considering style bonuses for the attacker.
     *
     * @return The effective level for the attacker.
     * @throws RuntimeException if the attacker is null.
     */
    default int getEffectiveLevel() throws RuntimeException {
        int style = this.getOffensiveStyleBonus();
        if (this.attacker() == null) throw new RuntimeException("Null Entity");
        if (this.attacker() instanceof RSPlayer) {
            int modification = (int) this.getModification();
            modification += style;
            return modification;
        }
        return style;
    }

    /**
     * Retrieves the modification value.
     *
     * @return The modification value.
     */
    default double getModification() {
        return 0.0D;
    }

    /**
     * Retrieves the special multiplier for the attack, applicable for certain special cases.
     *
     * @param player The player involved in the combat.
     * @return The special multiplier.
     */
    default double getSpecialMultiplier(RSPlayer player) {
        return 0.0D;
    }
}