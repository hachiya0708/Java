package rpg.strategy;

import rpg.character.Character;

@FunctionalInterface
public interface Strategy {
    int execute(Character character_1, Character character_2);
}
