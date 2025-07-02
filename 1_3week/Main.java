import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // スキャナーを使ってユーザー入力を受け取る
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== 冒険スタート ===");
        System.out.print("プレイヤーの名前を入力してください：");
        String name = scanner.nextLine();

        // プレイヤーと敵を作成
        Player player = new Player(name);
        Enemy enemy = new Enemy("スライム");

        // 戦闘開始
        Battle battle = new Battle(player, enemy);
        battle.start();

        scanner.close();
    }
}
