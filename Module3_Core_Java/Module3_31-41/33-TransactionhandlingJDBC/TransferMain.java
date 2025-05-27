public class TransferMain {
    public static void main(String[] args) {
        AccountDAO dao = new AccountDAO();

        // Show balances before transfer
        dao.showBalances();

        // Perform a transfer: Alice (id=1) sends $100 to Bob (id=2)
        dao.transfer(1, 2, 100.0);

        // Show balances after transfer
        dao.showBalances();
    }
}
