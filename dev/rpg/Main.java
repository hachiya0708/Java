package rpg;

import java.util.Scanner;
import rpg.character.Player;
import rpg.character.Enemy;
import rpg.battle.Battle;
import rpg.strategy.Strategy;
import rpg.character.Character;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== 冒険スタート ===");
        System.out.print("プレイヤーの名前を入力してください：");
        String pname = scanner.nextLine();
        System.out.print("プレイヤーのHPを入力してください：");
        int php = scanner.nextInt();
        System.out.print("プレイヤーの攻撃力を入力してください：");
        int pattack = scanner.nextInt();

        Player player = new Player(pname, php, pattack);
        Enemy enemy = new Enemy("嫌な上司", 1000, 200);

        //ラムダ式で攻撃戦術を立てる
        Strategy strategy = (p, e) -> {
            System.out.println("[戦略: 同僚や先輩に陰口]");
            int damage = p.attack();
            e.takeDamage(damage);
            return damage;
        };

        //バトル開始前に両者の挨拶
        Character[] characters = { player, enemy };
        System.out.println("=== 両者の挨拶 ===");
        for (Character c : characters) {
            System.out.println(c.introduce());
        }


        Battle battle = new Battle(player, enemy, strategy);
        battle.start();

        scanner.close();
    }
}

