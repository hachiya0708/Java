package rpg.character;

public class Enemy extends Character {

    public Enemy(String name, int hp, int attack) {
        super(name, hp, attack); // 明示的にsuper呼び出し
    }

    // 自己紹介のオーバーライド
    @Override
    public String introduce() {
        return "私は" + getName() + "といいます。どうしたのかな？";
    }

    // 攻撃メソッドのオーバーライド
    @Override
    public int attack() {
        return super.attack + (int)(Math.random() * 3);
    }
}
