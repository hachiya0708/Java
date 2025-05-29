package parent;

public abstract class Character {
    protected String name;
    protected int hp;
    protected int attackPower;

    public Character(String name, int hp, int attackPower) {
        this.name = name;
        this.hp = hp;
        this.attackPower = attackPower;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    //HP判定
    public boolean isAlive() {
        return hp > 0;
    }

    //ダメージを受ける
    public void takeDamage(int damage) {
        hp -= damage;
        if (hp < 0) hp = 0;
    }

    //攻撃
    public abstract int attack();
}
