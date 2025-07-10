package rpg.battle;

import rpg.character.Player;
import rpg.character.Enemy;
import rpg.message.Message;

public class Battle {
    private Player player;
    private Enemy enemy;

    // プレイヤーと敵の情報をセット
    public Battle(Player player, Enemy enemy) {
        this.player = player;
        this.enemy = enemy;
    }

    // 戦闘開始
    public void start() {
        System.out.println("\n=== 戦闘開始！ ===");

        while (player.isAlive() && enemy.isAlive()) {
            // プレイヤーの攻撃
            Message.printMessages(player.getName() + "の攻撃！");

            // instanceofで敵の特性チェック（将来拡張に備えて）
            if (enemy instanceof Enemy) {
                int damage = player.attack(enemy.getName()); //特殊攻撃
                enemy.takeDamage(damage);
                Message.printMessages(enemy.getName() + "に" + damage + "のダメージ！");
                Message.printMessages(enemy.getName() + "の残りHP: " + enemy.getHp());
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
            Message.printMessages(player.getName() + "の残りHP: " + player.getHp());

            if (!player.isAlive()) {
                Message.printMessages(player.getName() + "は倒れてしまった...");
                break;
            }

            Message.printMessages("\n--- 次のターン ---\n");
        }

        Message.printMessages("=== 戦闘終了 ===");
    }
}
