package Volume_I.Chapter14.UnSynch;

/**
 * Created by Star Yang on 2017/3/15.
 */
public class BankTest {
    private static final int NACCOUNTS = 100;
    private static final double INITIAL_BALANCE = 1000;

    public static void main(String[] args) {
        Bank bank = new Bank(NACCOUNTS, INITIAL_BALANCE);
        int i;
        for (i = 0; i < NACCOUNTS; i++) {
            TransferRunnable transferRunnable = new TransferRunnable(bank, i, INITIAL_BALANCE);
            Thread thread = new Thread(transferRunnable);
            thread.start();
        }
    }
}
