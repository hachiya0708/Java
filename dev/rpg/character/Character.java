package rpg.character;

import rpg.character.Attackable;

public abstract class Character implements Attackable {
    protected String name;
    protected int hp;
    protected int attack;

    public Character(String name, int hp, int attack) {
        this.name = name;
        this.hp = hp;
        this.attack = attack;
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

    public void takeDamage(int damage) {
        this.hp -= damage;
        if (this.hp < 0) this.hp = 0;
    }

    public boolean isAlive() {
        return this.hp > 0;
    }

    // Objectクラスのメソッドをオーバーライド
    @Override
    public String toString() {
        return name + " [HP: " + hp + ", [攻撃力: " + attack + "]";
    }

    //自己紹介
    abstract public String introduce();
}
