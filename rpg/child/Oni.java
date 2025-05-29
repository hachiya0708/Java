package child;

import parent.Character;

public class Oni extends Character {
  public Oni() {
      super("Oni", 40, 10);
  }

  @Override
  public int attack() {
      int damage = attackPower;
      System.out.println(name + " が金棒を振りかざす！ " + damage + " のダメージ！");
      return damage;
  }
}
