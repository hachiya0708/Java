public class Enemy {
    private String name;
    private int hp;
    private int attack;

    // 敵の初期ステータス
    public Enemy(String name) {
        this.name = name;
        this.hp = 80;
        this.attack = 15;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public int getAttack() {
        return attack;
    }

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
