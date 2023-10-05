import java.util.HashMap;
import java.util.Scanner;

public class ATMinterface {
    private HashMap<String, Double> accounts;

    public ATMinterface() {
        accounts = new HashMap<>();
        // Sample account data (accountNumber, balance)
        accounts.put("123456789", 1000.00);
        accounts.put("987654321", 500.00);
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the ATM!");
        System.out.print("Enter your account number: ");
        String accountNumber = scanner.nextLine();

        if (validateAccount(accountNumber)) {
            while (true) {
                System.out.println("\nMenu:");
                System.out.println("1. Check Balance");
                System.out.println("2. Withdraw Money");
                System.out.println("3. Exit");
                System.out.print("Enter your choice (1/2/3): ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        checkBalance(accountNumber);
                        break;
                    case 2:
                        withdrawMoney(accountNumber);
                        break;
                    case 3:
                        System.out.println("Thank you for using the ATM!");
                        return;
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            }
        } else {
            System.out.println("Invalid account number. Exiting...");
        }
    }

    private boolean validateAccount(String accountNumber) {
        // Simple account validation check
        return accounts.containsKey(accountNumber);
    }

    private void checkBalance(String accountNumber) {
        double balance = accounts.get(accountNumber);
        System.out.println("Your account balance is: $" + balance);
    }

    private void withdrawMoney(String accountNumber) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the amount to withdraw: ");
        double amount = scanner.nextDouble();

        if (amount <= 0) {
            System.out.println("Invalid amount. Withdrawal failed.");
        } else {
            double balance = accounts.get(accountNumber);
            if (balance >= amount) {
                balance -= amount;
                accounts.put(accountNumber, balance);
                System.out.println("Withdrawal successful. Remaining balance: $" + balance);
            } else {
                System.out.println("Insufficient funds. Withdrawal failed.");
            }
        }
    }

    public static void main(String[] args) {
        ATMinterface atm = new ATMinterface();
        atm.run();
    }
}