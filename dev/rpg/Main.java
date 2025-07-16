package rpg;

import java.util.Scanner;
import rpg.character.Player;
import rpg.character.Enemy;
import rpg.battle.Battle;


public class Main {
    public static void main(String[] args) {
        // スキャナーを使ってユーザー入力を受け取る
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== 冒険スタート ===");
        System.out.print("プレイヤーの名前を入力してください：");
        String pname = scanner.nextLine();
        System.out.print("プレイヤーのHPを入力してください：");
        int php = scanner.nextInt();
        System.out.print("プレイヤーの攻撃力を入力してください：");
        int pattack = scanner.nextInt();

        // プレイヤーと敵を作成
        Player player = new Player(pname, php, pattack);
        Enemy enemy = new Enemy("嫌な上司", 1000, 200);

        // 戦闘開始
        Battle battle = new Battle(player, enemy);
        battle.start();

        scanner.close();
    }
}
