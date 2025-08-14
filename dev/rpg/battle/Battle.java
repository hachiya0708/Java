package rpg.battle;

import java.util.*;
import rpg.character.Character;
import rpg.character.Player;
import rpg.character.Enemy;
import rpg.strategy.Strategy;
import rpg.message.Message;

public class Battle {
    private Player player;
    private Enemy enemy;
    private Strategy strategy;

    public Battle(Player player, Enemy enemy, Strategy strategy) {
        this.player = player;
        this.enemy = enemy;
        this.strategy = strategy;
    }

    public void start() {
        // 両者の挨拶（Iterator使用）
        List<Character> characters = Arrays.asList(player, enemy);
        System.out.println("=== 両者の挨拶 ===");
        Iterator<Character> iterator = characters.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().introduce());
        }

        // 戦闘
        System.out.println("=== バトル開始 ===");
        if (player instanceof Character && enemy instanceof Character) {
            while (player.isAlive() && enemy.isAlive()) {
                strategy.execute(player, enemy);
                if (!enemy.isAlive()) break;
                strategy.execute(enemy, player);
            }
            Message.printMessages(player.getName() + "のHP：" + player.getHp());
            Message.printMessages(enemy.getName() + "のHP：" + enemy.getHp());
        }
        System.out.println("=== バトル終了 ===");
    }
}
