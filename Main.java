import java.util.Scanner;

class BankAccount
{
    private double balance;  // Account balance

    // Constructor to initialize balance
    public BankAccount(double initialBalance)
    {
        this.balance = initialBalance;
    }

    // Method to deposit money into the account
    public void deposit(double amount)
    {
        if(amount > 0)
        {
            balance += amount;
            System.out.println("Deposited: " + amount);
        }
        else
        {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Method to withdraw money from the account
    public boolean withdraw(double amount)
    {
        if(amount <= 0)
        {
            System.out.println("Invalid withdrawal amount.");
            return false;
        }
        if(amount > balance)
        {
            System.out.println("Insufficient balance!");
            return false;
        }
        balance -= amount;
        System.out.println("Withdrawn: " + amount);
        return true;
    }

    // Method to check balance
    public double checkBalance()
    {
        return balance;
    }
}

class ATM
{
    private final BankAccount account;  // Reference to a BankAccount object

    // Constructor to initialize ATM with a bank account
    public ATM(BankAccount account)
    {
        this.account = account;
    }

    // Display ATM options and take user action
    public void displayMenu()
    {
        Scanner scanner = new Scanner(System.in);
        int choice;
        double amount;

        while (true)
        {
            System.out.println("\nATM Menu:");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice)
            {
                case 1 ->
                {
                    // Withdraw money
                    System.out.print("Enter the amount to withdraw: ");
                    amount = scanner.nextDouble();
                    if(account.withdraw(amount))
                    {
                        System.out.println("Transaction successful!");
                    }
                    else
                    {
                        System.out.println("Transaction failed!");
                    }
                }

                case 2 ->
                {
                    // Deposit money
                    System.out.print("Enter the amount to deposit: ");
                    amount = scanner.nextDouble();
                    account.deposit(amount);
                    System.out.println("Transaction successful!");
                }

                case 3 -> // Check balance
                    System.out.println("Your current balance is: " + account.checkBalance());

                case 4 ->
                {
                    // Exit
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    scanner.close();
                    return;
                }

                default -> System.out.println("Invalid choice, please try again.");
            }
        }
    }
}

public class Main
{
    public static void main(String[] args)
    {
        try(Scanner scanner = new Scanner(System.in))
        {
            System.out.print("Enter initial balance for your account: $");
            double initialBalance = scanner.nextDouble();

            // Create a bank account and pass it to the ATM
            BankAccount userAccount = new BankAccount(initialBalance);
            ATM atm = new ATM(userAccount);

            // Display ATM menu
            atm.displayMenu();
        }
    }
}