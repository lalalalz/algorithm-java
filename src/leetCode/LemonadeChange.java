package leetCode;

public class LemonadeChange {

    private int[] changes = new int[21];
    private static final int FIVE = 5;
    private static final int TEN = 10;

    public boolean lemonadeChange(int[] bills) {
        boolean canAllChange = true;

        for (int bill : bills) {
            chargeChanges(bill, changes);

            if (!canChange(bill, changes)) {
                canAllChange = false;
                break;
            }
        }

        return canAllChange;
    }

    private void chargeChanges(int bill, int[] changes) {
        changes[bill]++;
    }

    private boolean canChange(int bill, int[] changes) {
        int change = bill - 5;

        while (changes[TEN] > 0 && change >= TEN) {
            changes[TEN]--;
            change -= TEN;
        }

        while (changes[FIVE] > 0 && change >= FIVE) {
            changes[FIVE]--;
            change -= FIVE;
        }

        return change == 0;
    }
}
