import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BankAccountTest {

    // --- 入金（deposit）メソッドのテスト ---

    @Test
    void depositIncreasesBalance() {
        BankAccount account = new BankAccount(1000);
        account.deposit(500);
        assertEquals(2000, account.getBalance());
    }

    @Test
    void depositZeroNotChangeBalance() {
        BankAccount account = new BankAccount(1000);
        account.deposit(0); // 不正な金額
        assertEquals(1000, account.getBalance());
    }

    @Test
    void depositMinusNotChangeBalance() {
        BankAccount account = new BankAccount(1000);
        account.deposit(-100); // 不正な金額
        assertEquals(1000, account.getBalance());
    }

    // --- 出金（withdraw）メソッドのテスト ---

    @Test
    void withdrawDecreasesBalance() {
        BankAccount account = new BankAccount(1000);
        account.withdraw(400);
        assertEquals(600, account.getBalance());
    }

    @Test
    void withdrawNotEnoughBalance() {
        BankAccount account = new BankAccount(1000);
        account.withdraw(2000); // 残高不足
        assertEquals(1000, account.getBalance());
    }

    @Test
    void withdrawMinusNotChangeBalance() {
        BankAccount account = new BankAccount(1000);
        account.withdraw(-500); // 不正な金額
        assertEquals(1000, account.getBalance());
    }

    @Test
    void withdrawZeroNotChangeBalance() {
        BankAccount account = new BankAccount(1000);
        account.withdraw(0); // 不正な金額
        assertEquals(1000, account.getBalance());
    }

    // --- getBalanceメソッドのテスト ---

    @Test
    void balanceSetCorrectly() {
        BankAccount account = new BankAccount(500);
        assertEquals(500, account.getBalance());
    }
}

