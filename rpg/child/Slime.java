package child;

import parent.Character;

public class Slime extends Character {
  public Slime() {
      super("Slime", 20, 6);
  }

  @Override
  public int attack() {
      int damage = attackPower;
      System.out.println(name + " が液体をかける！ " + damage + " のダメージ！");
      return damage;
  }
}
