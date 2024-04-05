package com.origin.accuracy;

import com.origin.accuracy.provider.*;
import lombok.Getter;
import lombok.Setter;

public final class MagicAccuracy implements AbstractAccuracy {

    @Getter
    @Setter
    public int modifier;
    @Getter
    RSEntity attacker;
    @Getter
    RSEntity defender;
    RSCombatType combatType;

    public MagicAccuracy(RSEntity attacker, RSEntity defender, RSCombatType combatType) {
        this.attacker = attacker;
        this.defender = defender;
        this.combatType = combatType;
    }

    @Override
    public RSEntity attacker() {
        return this.attacker;
    }

    @Override
    public RSEntity defender() {
        return this.defender;
    }

    @Override
    public RSCombatType getCombatType() {
        return this.combatType;
    }

    @Override
    public int modifier() {
        return this.modifier;
    }

    @Override
    public int getEquipmentBonusForAttacker() {
        return 0;
    }

    @Override
    public int getEquipmentBonusForDefender() {
        return 0;
    }

    @Override
    public int getOffensiveSkillLevelAttacker() {
        return 0;
    }

    @Override
    public int getDefensiveSKillLevelDefender() {
        return 0;
    }

    @Override
    public double getPrayerBonusAttacker() {
        return 0;
    }

    @Override
    public double getPrayerBonusDefender() {
        return 0;
    }

    @Override
    public int getOffensiveStyleBonus() {
        return 0;
    }

    @Override
    public int getDefensiveStyleBonus() {
        return 0;
    }

    @Override
    public int getDefenceRoll() {
        double prayer = this.getPrayerBonusDefender();
        int defenceLevel = (int) Math.floor(this.getDefensiveSKillLevelDefender() * prayer);
        int bonus = this.getEquipmentBonusForDefender();
        int effectiveDefence = 0;
        int effectiveMagic = this.getOffensiveSkillLevelAttacker();
        if (this.defender() instanceof RSNpc) effectiveDefence = defenceLevel + 9;
        else if (this.defender() instanceof RSPlayer) {
            bonus += this.getDefensiveStyleBonus();
            effectiveMagic *= 0.7D;
            effectiveMagic += defenceLevel;
            effectiveMagic *= 0.3D;
            effectiveMagic += 8;
            effectiveDefence += effectiveMagic;
        }
        return effectiveDefence * (bonus + 64);
    }
}
