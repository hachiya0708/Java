package rpg.inventory;

import rpg.character.Player;
import java.util.*;

//アイテム在庫管理クラス
public class Inventory<T> {
    private Map<T, Integer> items = new HashMap<>();
    private Set<T> uniqueItems = new HashSet<>();
    private Player player;

    public Inventory(Player player) {
        this.player = player;
    }

    public void addItem(T item, int quantity) {
        items.put(item, items.getOrDefault(item, 0) + quantity);
        uniqueItems.add(item);
    }

    public void showInventory() {
        System.out.println("===" + this.player.getName() + "のアイテム状況===");
        for (Map.Entry<T, Integer> entry : items.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue() + "個");
        }
        System.out.println("（ユニークアイテム）" + uniqueItems);
    }
}
