public class BankAccount {
    // 残高フィールド（カプセル化のためprivate）
    private double balance;

    // コンストラクタ
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    // 入金メソッド
    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            System.out.println(amount + "円 入金しました");
        } else {
            System.out.println("入金できるのは0円以上です");
        }
    }

    // 出金メソッド
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            this.balance -= amount;
            System.out.println(amount + "円 出金しました");
        } else {
            System.out.println("残高不足、もしくは不正な金額です");
        }
    }

    // 残高照会メソッド
    public double getBalance() {
        return balance;
    }
}
