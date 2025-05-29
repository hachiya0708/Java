package child;

import parent.Character;

public class Hero extends Character {
  public Hero() {
      super("Hero", 100, 15);
  }

  //1体攻撃
  @Override
  public int attack() {
      int damage = attackPower;
      System.out.println(name + " がパンチ！ " + damage + " のダメージ！");
      return damage;
  }

  //複数攻撃
  public void attack(Character... monster) {
    int damage = attackPower;
    System.out.println(name + " が複数攻撃の特大パンチ！");
    for (Character m : monster) {
      System.out.println(m.getName() + " に " + damage + " のダメージ！");
      m.takeDamage(damage);
    }
  }
}
