package sync;

public class BankMain {

    public static void main(String[] args) throws InterruptedException {
        BankAccountV1 account = new BankAccountV1(1000);

        Thread t1 = new Thread(new WithdrawTask(account, 800), "t1");
        t1.start();
        t1.join();

        System.out.println("최종 잔액: " + account.getBalance());
    }
}
