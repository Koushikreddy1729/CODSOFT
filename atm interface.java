import java.util.Scanner;

public class ATMInterface {
    

   public static class Bankaccount {
        private double balance;

        public Bankaccount(double firstbalance) {
            this.balance = firstbalance;
        }

        public double getBalance() {
            return balance;
        }

        public boolean deposit(double amount) {
            if (amount > 0) {
                balance += amount;
                return true;
            }
            return false;
        }

        public boolean withdraw(double amount) {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
                return true;
            }
            return false;
        }
    }

    static class ATM {
        private Bankaccount account;
        private Scanner sc;

        public ATM(Bankaccount account) {
            this.account = account;
            this.sc = new Scanner(System.in);
        }

        public void start() {
            int choice;
            do {
                System.out.println("\n ATM Menu ");
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
            System.out.println("Current Balance: " + account.getBalance());
        }

        private void depositMoney() {
            System.out.print("Enter amount to deposit: ");
            double amount = sc.nextDouble();
            if (account.deposit(amount)) {
                System.out.println("Deposit successful. New Balance: " + account.getBalance());
            } else {
                System.out.println("Invalid deposit amount.");
            }
        }

        private void withdrawMoney() {
            System.out.print("Enter amount to withdraw: ");
            double amount = sc.nextDouble();
            if (account.withdraw(amount)) {
                System.out.println("Withdrawal successful. New Balance: " + account.getBalance());
            } else {
                System.out.println("Insufficient balance or invalid amount.");
            }
        }
    }
 
    public static void main(String[] args) {
        Bankaccount account = new Bankaccount(1000.0); // initial balance
        ATM atm = new ATM(account);
        atm.start();
   
    }
}


