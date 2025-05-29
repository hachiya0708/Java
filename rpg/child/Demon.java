package child;

import parent.Character;

public class Demon extends Character {
  public Demon() {
      super("Demon", 30, 12);
  }

  @Override
  public int attack() {
      int damage = attackPower;
      System.out.println(name + " が噛みつく！ " + damage + " のダメージ！");
      return damage;
  }
}
