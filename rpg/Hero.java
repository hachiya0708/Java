public class Hero extends Character {
  public Hero() {
      super("Hero", 100, 15);
  }

  @Override
  public int attack() {
      int damage = attackPower;
      System.out.println(name + " がパンチ！ " + damage + " のダメージ！");
      return damage;
  }
}
