package rpg;

import java.util.Scanner;
import rpg.character.Player;
import rpg.character.Enemy;
import rpg.battle.Battle;
import rpg.strategy.Strategy;
import rpg.inventory.Inventory;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== 冒険スタート ===");
        System.out.print("プレイヤーの名前：");
        String pname = scanner.nextLine();
        System.out.print("プレイヤーのHP：");
        int php = scanner.nextInt();
        System.out.print("プレイヤーの攻撃力：");
        int pattack = scanner.nextInt();

        Player player = new Player(pname, php, pattack);
        Enemy enemy = new Enemy("嫌な上司", 1000, 200);

        // 戦略設定（ラムダ式）
        Strategy strategy = (p, e) -> {
            if (p instanceof Player) {
               System.out.println("[戦略: 同僚や先輩に陰口]"); 
            } else {
                System.out.println("[戦略: 休日でも1時間以内に返信しろ]");
            }
            int damage = p.attack();
            e.takeDamage(damage);
            return damage;
        };

        // インベントリ操作
        Inventory<String> inventory = new Inventory<>(player);
        inventory.addItem("回復薬", 3);
        inventory.addItem("爆弾", 1);
        inventory.addItem("回復薬", 2);
        inventory.showInventory();

        // バトル開始
        Battle battle = new Battle(player, enemy, strategy);
        battle.start();

        scanner.close();
    }
}
