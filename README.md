# RSAccuracyAPI

The RSAccuracyAPI is a Java library designed to handle combat scenarios within a game environment. It provides interfaces and classes for entities involved in combat, combat types, combat specials, and various calculations related to combat accuracy and effectiveness.

## Installation

To use the RSAccuracyAPI in your Java project, you can include the necessary interfaces and classes in your project's source code.

## Usage

To utilize the RSAccuracyAPI in your game project, follow the guidelines below:

1. **Implement Entity Interfaces:** Implement the provided interfaces for entities such as players and NPCs in your game.

2. **Perform Combat Calculations:** Utilize the provided methods for combat calculations and interactions between entities.

3. **Handle Combat Specials:** Manage combat specials and their effects on combat accuracy and effectiveness.

Here's an example demonstrating how to use the **RSAccuracyAPI**:

```java
// Create an instance AbstractAccuracy
AbstractAccuracy accuracy;

// Create Class Instances
MagicAccuracy magicAccuracy = new MagicAccuracy(this.attacker, this.target, this.combatType);
RangeAccuracy rangeAccuracy = new RangeAccuracy(this.attacker, this.target, this.combatType);
MeleeAccuracy meleeAccuracy = new MeleeAccuracy(this.attacker, this.target, this.combatType);

// Check the RSCombatType & Assign
switch (combatType) {
      case MAGIC -> accuracy = magicAccuracy;
      case RANGED -> accuracy = rangeAccuracy;
      case MELEE -> accuracy = meleeAccuracy;
}

  
// Declare Accurate
accurate = accuracy.success(chance);
```

## Implementation Capabilities

Can be used to modify accuracy attributes of **RSNpc** specific or **RSPlayer** specific scenarios.

Example:
```java
public class GraardorCombat extends CommonCombatMethod implements AbstractAccuracy {

    @Override
    public Entity attacker() {
        return null;
    }

    @Override
    public Entity defender() {
        return null;
    }

    @Override
    public CombatType getCombatType() {
        return null;
    }

    @Override
    public int modifier() {
        return 0;
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

```




## Documentation
Interfaces
AbstractAccuracy Interface

1. **attacker()**: Retrieves the attacker entity involved in combat.
2. **defender()**: Retrieves the defender entity involved in combat.
3. **getCombatType()**: Retrieves the combat type.
4. **modifier()**: Retrieves the modifier for the attack.
5. **getEquipmentBonusForAttacker()**: Retrieves the equipment bonus for the attacker.
6. **getEquipmentBonusForDefender()**: Retrieves the equipment bonus for the defender.
7. **getOffensiveSkillLevelAttacker()**: Retrieves the offensive skill level of the attacker.
8. **getDefensiveSKillLevelDefender()**: Retrieves the defensive skill level of the defender.
9. **getPrayerBonusAttacker()**: Retrieves the prayer bonus for the attacker.
10. **getPrayerBonusDefender()**: Retrieves the prayer bonus for the defender.
11. **getOffensiveStyleBonus()**: Retrieves the offensive style bonus.
12. **getDefensiveStyleBonus()**: Retrieves the defensive style bonus.
13. **success(double selectedChance)**: Calculates the success of an attack.
14. **getAttackRoll()**: Calculates the attack roll.
15. **getDefenceRoll()**: Calculates the defence roll.
16. **getEffectiveLevel()**: Calculates the effective level considering style bonuses.
17. **getModification()**: Retrieves the modification value.
18. **getSpecialMultiplier(RSPlayer player)**: Retrieves the special multiplier for the attack. RSCombatType Interface
19. **get()**: Retrieves the combat type. RSCombatSpecial Interface
20. **get()**: Retrieves the combat special.
21. **getAccuracyMultiplier()**: Retrieves the accuracy multiplier associated with the combat special. RSEntity Interface 
22. **getNpc()**: Retrieves the NPC representation of the entity.
23. **getPlayer()**: Retrieves the Player representation of the entity.
24. **getCombatType()**: Retrieves the combat type of the entity. RSNpc Interface
25. **get()**: Retrieves the NPC itself. RSPlayer Interface
26. **get()**: Retrieves the player itself.
27. **getCombatSpecial()**: Retrieves the combat special associated with the player.
28. **isSpecialActivated()**: Checks whether the special attack is activated for the player.

## Contributing
Contributions to the **RSAccuracyAPI** are welcome! If you would like to contribute to the project, please follow these steps:

Fork the repository.
Create a new branch for your feature or bug fix.
Make your changes and ensure that tests pass.
Commit your changes and push them to your fork.
Submit a pull request to the main repository.