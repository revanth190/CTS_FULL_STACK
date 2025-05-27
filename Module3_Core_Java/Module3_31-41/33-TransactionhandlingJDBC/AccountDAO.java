import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AccountDAO {
    private Connection connect() throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        return DriverManager.getConnection("jdbc:sqlite:bank.db");
    }

    public void transfer(int fromId, int toId, double amount) {
        String debitSql = "UPDATE accounts SET balance = balance - ? WHERE id = ?";
        String creditSql = "UPDATE accounts SET balance = balance + ? WHERE id = ?";

        try (Connection conn = connect()) {
            conn.setAutoCommit(false);  // Start transaction

            try (
                PreparedStatement debitStmt = conn.prepareStatement(debitSql);
                PreparedStatement creditStmt = conn.prepareStatement(creditSql)
            ) {
                // Debit
                debitStmt.setDouble(1, amount);
                debitStmt.setInt(2, fromId);
                debitStmt.executeUpdate();

                // Credit
                creditStmt.setDouble(1, amount);
                creditStmt.setInt(2, toId);
                creditStmt.executeUpdate();

                // If both succeed, commit
                conn.commit();
                System.out.println("Transfer successful!");

            } catch (SQLException e) {
                System.out.println("Transfer failed, rolling back.");
                conn.rollback(); // Rollback on error
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showBalances() {
        try (Connection conn = connect();
             var stmt = conn.createStatement();
             var rs = stmt.executeQuery("SELECT * FROM accounts")) {

            System.out.println("\n--- Account Balances ---");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double balance = rs.getDouble("balance");
                System.out.println(id + " | " + name + " | $" + balance);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
