
import java.util.Scanner;

// Represents a user's bank account
class BankAccount {
    private double Balance;

    public BankAccount(double firstBalance) {
        this.Balance = firstBalance;
    }

    public double getBalance() {
        return Balance;
    }

    public boolean deposit(double amount) {
        if (amount > 0) {
            Balance += amount;
            return true;
        }
        return false;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= Balance) {
            Balance -= amount;
            return true;
        }
        return false;
    }
}

// Represents the ATM machine
class ATM {
    private BankAccount Account;
    private Scanner sc;

    public ATM(BankAccount Account) {
        this.Account = Account;
        this.sc = new Scanner(System.in);
    }

    public void start() {
        int choice;
        do {
            System.out.println("\n===== ATM Menu =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    depositMoney();
                    break;
                case 3:
                    withdrawMoney();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 4);
    }

    private void checkBalance() {
        System.out.println("Current Balance: " + Account.getBalance());
    }

    private void depositMoney() {
        System.out.print("Enter amount to deposit: ");
        double amount = sc.nextDouble();
        if (Account.deposit(amount)) {
            System.out.println("Deposit successful. New Balance: " + Account.getBalance());
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    private void withdrawMoney() {
        System.out.print("Enter amount to withdraw: ");
        double amount = sc.nextDouble();
        if (Account.withdraw(amount)) {
            System.out.println("Withdrawal successful. New Balance: " + Account.getBalance());
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }
}

// Main driver class
public class Main {
    public static void main(String[] args) {
        BankAccount Account = new BankAccount(1000.0); // initial balance
        ATM atm = new ATM(Account);
        atm.start();
    }
}
