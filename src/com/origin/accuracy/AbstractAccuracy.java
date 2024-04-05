package com.origin.accuracy;

import com.origin.accuracy.provider.RSCombatType;
import com.origin.accuracy.provider.RSEntity;
import com.origin.accuracy.provider.RSPlayer;

public interface AbstractAccuracy {
    RSEntity attacker();

    RSEntity defender();

    RSCombatType getCombatType();

    int modifier();

    int getEquipmentBonusForAttacker();

    int getEquipmentBonusForDefender();

    int getOffensiveSkillLevelAttacker();

    int getDefensiveSKillLevelDefender();

    double getPrayerBonusAttacker();

    double getPrayerBonusDefender();

    int getOffensiveStyleBonus();

    int getDefensiveStyleBonus();

    default double getBoost() {
        return 0.0D;
    }

    default boolean success(double selectedChance) {
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

    default int getDefenceRoll() {
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

    default int getEffectiveLevel() {
        int style = this.getOffensiveStyleBonus();
        if (this.attacker() == null) throw new RuntimeException("Null Entity");
        if (this.attacker() instanceof RSPlayer) {
            int modification = (int) this.getModification();
            modification += style;
            return modification;
        }
        return style;
    }

    default double getModification() {
        return 0.0D;
    }

    default double getSpecialMultiplier(RSPlayer player) {
        return 0.0D;
    }
}
