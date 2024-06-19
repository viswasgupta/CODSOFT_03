import java.util.Scanner;

public class ATM {
    private BankAccount account;
    private Scanner scanner;

    public ATM(BankAccount account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        boolean exit = false;

        while (!exit) {
            showMenu();
            int choice = getUserChoice();

            switch (choice) {
                case 1:
                    handleDeposit();
                    break;
                case 2:
                    handleWithdrawal();
                    break;
                case 3:
                    account.checkBalance();
                    break;
                case 4:
                    exit = true;
                    System.out.println("Exiting. Thank you for using the ATM.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void showMenu() {
        System.out.println("\nATM Menu:");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    private int getUserChoice() {
        int choice = -1;
        if (scanner.hasNextInt()) {
            choice = scanner.nextInt();
        } else {
            scanner.next(); // Clear the invalid input
        }
        return choice;
    }

    private void handleDeposit() {
        System.out.print("Enter deposit amount: ");
        if (scanner.hasNextDouble()) {
            double amount = scanner.nextDouble();
            account.deposit(amount);
        } else {
            System.out.println("Invalid deposit amount.");
            scanner.next(); // Clear the invalid input
        }
    }

    private void handleWithdrawal() {
        System.out.print("Enter withdrawal amount: ");
        if (scanner.hasNextDouble()) {
            double amount = scanner.nextDouble();
            account.withdraw(amount);
        } else {
            System.out.println("Invalid withdrawal amount.");
            scanner.next(); // Clear the invalid input
        }
    }
}
