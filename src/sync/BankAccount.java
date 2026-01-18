package sync;

public interface BankAccount {

    boolean withdraw(int amount) throws InterruptedException; // 출고
    int getBalance(); // 잔고확인

}
