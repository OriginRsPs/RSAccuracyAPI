package com.origin.accuracy;

import com.origin.accuracy.api.AbstractAccuracy;
import com.origin.accuracy.api.RSCombatType;
import com.origin.accuracy.api.RSEntity;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

public class RangeAccuracy implements AbstractAccuracy {

    @Getter
    @Setter
    public int modifier;
    @Getter
    @Setter
    @NonNull RSEntity attacker, defender;
    RSCombatType combatType;

    public RangeAccuracy(@NonNull RSEntity attacker, @NonNull RSEntity defender, RSCombatType combatType) {
        this.attacker = attacker;
        this.defender = defender;
        this.combatType = combatType;
    }

    @Override
    public @NonNull RSEntity attacker() {
        return this.attacker;
    }

    @Override
    public @NonNull RSEntity defender() {
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

}
