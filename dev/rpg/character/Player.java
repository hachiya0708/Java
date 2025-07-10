package rpg.character;

import java.lang.Math.*;

public class Player {
    private String name;
    private int hp;
    private int attack;

    // コンストラクタ：プレイヤーの初期ステータスを設定
    public Player(String name) {
        this.name = name;
        this.hp = 100;         // 初期HP
        this.attack = 20;      // 初期攻撃力
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public int attack() {
        return attack;
    }

    // オーバーロード：相手の名前を渡すと特別処理
    public int attack(String targetName) {
        int damage = this.attack + (int)(Math.random() * 5);
        System.out.println(this.name + "は " + targetName + " に特別攻撃！");
        return damage;
    }

    // ダメージを受けたときにHPを減らす
    public void takeDamage(int damage) {
        this.hp -= damage;
        if (this.hp < 0) {
            this.hp = 0;
        }
    }

    public boolean isAlive() {
        return this.hp > 0;
    }
}
