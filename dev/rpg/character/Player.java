package rpg.character;

public class Player extends Character {

    public Player(String name, int hp, int attack) {
        super(name, hp, attack); // 明示的にsuper呼び出し
    }

    // 攻撃メソッドのオーバーライド
    @Override
    public int attack() {
        return super.attack + (int)(Math.random() * 5); // super.field参照
    }

    // 特殊攻撃（オーバーロード）
    public int attack(String targetName) {
        int damage = attack();
        System.out.println(this.name + "は " + targetName + " に特別攻撃！");
        return damage;
    }
}
