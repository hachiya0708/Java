package rpg.message;

public class Message {
    // 可変長引数のメソッド
    public static void printMessages(String... messages) {
        for (String msg : messages) {
            System.out.println(msg);
        }
    }
}