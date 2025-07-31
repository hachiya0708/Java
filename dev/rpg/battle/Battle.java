package rpg.battle;

import rpg.character.Player;
import rpg.character.Enemy;
import rpg.message.Message;
import rpg.strategy.Strategy;

public class Battle {
    private Player player;
    private Enemy enemy;
    private Strategy strategy; // ★関数型インタフェース

    // プレイヤーと敵の情報をセット
    public Battle(Player player, Enemy enemy, Strategy strategy) {
        this.player = player;
        this.enemy = enemy;
        this.strategy = strategy;
    }

    // 戦闘開始
    public void start() {
        System.out.println("\n=== 戦闘開始！ ===");

        while (player.isAlive() && enemy.isAlive()) {
            // プレイヤーの攻撃
            Message.printMessages(player.getName() + "の攻撃！");

            // instanceofで敵の特性チェック
            if (enemy instanceof Enemy) {
                // ラムダ式を使って攻撃
                int damage = strategy.execute(player, enemy);
                Message.printMessages(enemy.getName() + "に" + damage + "のダメージ！");
                Message.printMessages("プレイヤー情報: " + player.toString());
                Message.printMessages("敵情報: " + enemy.toString());
            }

            // 敵が倒れたら終了
            if (!enemy.isAlive()) {
                Message.printMessages(enemy.getName() + "を倒した！");
                break;
            }

            // 敵の攻撃
            Message.printMessages(enemy.getName() + "の攻撃！");
            player.takeDamage(enemy.attack());
            Message.printMessages(player.getName() + "は" + enemy.attack() + "のダメージを受けた！");
            Message.printMessages("プレイヤー情報: " + player.toString());
            Message.printMessages("敵情報: " + enemy.toString());

            if (!player.isAlive()) {
                Message.printMessages(player.getName() + "は倒れてしまった...");
                break;
            }

            Message.printMessages("\n--- 次のターン ---\n");
        }

        Message.printMessages("=== 戦闘終了 ===");
    }
}
