package sync;

import static java.lang.Thread.sleep;

public class BankAccountV1 implements BankAccount {

    private int balance; // 잔고

    public BankAccountV1(int initialBalance) {
        balance = initialBalance;
    }

    @Override
    public boolean withdraw(int amount) throws InterruptedException {
        System.out.println("거래 시작: " + getClass().getSimpleName());
        System.out.println("[검증 시작] 출금액: " + amount + ", 잔액 : " + balance);

        if (balance < amount) {
            System.out.println("[검증 실패] 출금액: " + amount + ", 잔액 : " + balance);
            return false;
        }

        System.out.println("[검증 완료] 출금액: " + amount + ", 잔액 : " + balance);
        sleep(1000);
        balance = balance - amount;

        System.out.println("[출금 완료] 출금액: " + amount + ", 잔액 : " + balance);
        System.out.println("거래 종료");

        return true;
    }

    @Override
    public int getBalance() {
        return balance;
    }
}
