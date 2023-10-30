import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("\u001B[32mDeposit successful. New balance: $" + balance + "\u001B[0m"); // Green color for success
        } else {
            System.out.println("\u001B[31mInvalid deposit amount.\u001B[0m"); // Red color for error
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("\u001B[32mWithdrawal successful. New balance: $" + balance + "\u001B[0m"); // Green color for success
            return true;
        } else {
            System.out.println("\u001B[31mInvalid withdrawal amount or insufficient balance.\u001B[0m"); // Red color for error
            return false;
        }
    }
}

class ATM {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void displayOptions() {
        System.out.println("Welcome to the ATM!");
        // Blue color for options
        System.out.println("\u001B[34m1. Check Balance\u001B[0m"); 
        System.out.println("\u001B[34m2. Deposit\u001B[0m"); 
        System.out.println("\u001B[34m3. Withdraw\u001B[0m"); 
        System.out.println("\u001B[34m4. Exit\u001B[0m"); 
    }

    public void execute() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayOptions();
            // Cyan color for user input prompt
            System.out.print("\u001B[36mSelect an option: \u001B[0m"); 
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                // Cyan color for user input prompt
                    System.out.print("\u001B[36mEnter deposit amount: $\u001B[0m"); 
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 3:
                // Cyan color for user input prompt
                    System.out.print("\u001B[36mEnter withdrawal amount: $\u001B[0m"); 
                    double withdrawalAmount = scanner.nextDouble();
                    account.withdraw(withdrawalAmount);
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM!");
                    return;
                default:
                // Red color for error
                    System.out.println("\u001B[31mInvalid option. Please try again.\u001B[0m"); 
                    break;
            }
        }
    }

    public void checkBalance() {
        // Blue color for balance
        System.out.println("\u001B[34mCurrent balance: $" + account.getBalance() + "\u001B[0m"); 
    }
}

public class ATMInterface {
    public static void main(String[] args) {
        // Initial balance of $1000
        BankAccount userAccount = new BankAccount(1000.0); 
        ATM atm = new ATM(userAccount);
        atm.execute();
    }
}
