package rpg.strategy;

import rpg.character.Player;
import rpg.character.Enemy;

@FunctionalInterface
public interface Strategy {
    int execute(Player player, Enemy enemy);
}
