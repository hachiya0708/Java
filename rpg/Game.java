import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Hero hero = new Hero();
        Character[] monsters = { new Slime(), new Demon(), new Oni() };

        for (int i = 0; i < monsters.length; i++) {
            Character monster = monsters[i];
            System.out.println("\n== バトル " + (i+1) + ": " + hero.getName() + " vs " + monster.getName() + " ==");

            while (hero.isAlive() && monster.isAlive()) {
                // ヒーローのターン
                int heroDamage = hero.attack();
                monster.takeDamage(heroDamage);
                System.out.println(monster.getName() + "の HP: " + monster.getHp());

                if (!monster.isAlive()) {
                    System.out.println(monster.getName() + " が負けた！");
                    break;
                }

                // モンスターのターン
                int monsterDamage = monster.attack();
                hero.takeDamage(monsterDamage);
                System.out.println(hero.getName() + "の HP: " + hero.getHp());

                if (!hero.isAlive()) {
                    System.out.println("\n" + hero.getName() + " が負けた... ゲームオーバー");
                    return;
                }
            }
        }

        System.out.println("\nモンスターを全て倒した！ " + hero.getName() + " の勝利！");
    }
}
