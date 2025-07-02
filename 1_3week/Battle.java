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
            System.out.println(player.getName() + "の攻撃！");
            enemy.takeDamage(player.getAttack());
            System.out.println(enemy.getName() + "に" + player.getAttack() + "のダメージ！");
            System.out.println(enemy.getName() + "の残りHP: " + enemy.getHp());

            // 敵が倒れたら終了
            if (!enemy.isAlive()) {
                System.out.println(enemy.getName() + "を倒した！");
                break;
            }

            // 敵の攻撃
            System.out.println(enemy.getName() + "の攻撃！");
            player.takeDamage(enemy.getAttack());
            System.out.println(player.getName() + "は" + enemy.getAttack() + "のダメージを受けた！");
            System.out.println(player.getName() + "の残りHP: " + player.getHp());

            if (!player.isAlive()) {
                System.out.println(player.getName() + "は倒れてしまった...");
                break;
            }

            System.out.println("\n--- 次のターン ---\n");
        }

        System.out.println("=== 戦闘終了 ===");
    }
}
