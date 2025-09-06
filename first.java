import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserInterface u = new UserInterface();
        System.out.println("Welcome to the Banking Application!");
        while(true) {
            u.mainMenu();
        }
    }
}


class Account {
    int accountNumber;
    String accountHolderName;
    double balance;
    String email;
    String phoneNumber;

    // deposit money into account
    void deposit(double amount) {
        // check if amount is positive
        if (amount > 0) {
            balance += amount;
        }
        else {
            System.out.println("Invalid Amount Entered");
        }
    }

    void withdraw(double amount) {
        // check if withdrawn amount causes balance to fall below zero
        if (balance - amount < 0) {
            System.out.println("Insufficient Balance");
            return;
        }

        // check if amount is positive
        if (amount > 0) {
            balance -= amount;
        }
        else {
            System.out.println("Invalid Amount Entered");
        }
    }

    void displayAccountDetails() {
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + balance);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Email:" + email);
    }

    void updateContactDetails(String email, String phoneNumber) {
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
}

class UserInterface {
    // resizable array (ArrayList) to store accounts
    ArrayList<Account> accounts = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    void createAccount() {
        Account account = new Account();
        accounts.add(account);
        System.out.print("Enter account holder name: ");
        account.accountHolderName = scanner.nextLine();
        System.out.print("Enter intial deposit amount: ");
        account.deposit(scanner.nextDouble());
        scanner.nextLine();
        System.out.print("Enter email address: "); 
        account.email = scanner.nextLine();
        System.out.print("Enter phone number: ");
        account.phoneNumber = scanner.nextLine();
        account.accountNumber = 1000 + accounts.size();
        System.out.println("Account successfully created with Account Number: " + account.accountNumber);
    }

    void performDeposit() {
        System.out.print("Enter Account Number: ");
        int accNum = scanner.nextInt();
        // find acount with the matching Account Number
        for (Account acc:accounts) {
            if (acc.accountNumber == accNum) {
                System.out.print("Enter Amount: ");
                acc.deposit(scanner.nextDouble());
                return;
            }
        }
        System.out.println("Account not found");
    }

    void performWithdrawl() {
        System.out.print("Enter Account Number: ");
        int accNum = scanner.nextInt();
        // find acount with the matching Account Number
        for (Account acc:accounts) {
            if (acc.accountNumber == accNum) {
                System.out.print("Enter Amount: ");
                acc.withdraw(scanner.nextDouble());
                return;
            }
        }
        System.out.println("Account not found");
    }

    void showAccountDetails() {
        System.out.print("Enter Account Number: ");
        int accNum = scanner.nextInt();
        // find acount with the matching Account Number
        for (Account acc:accounts) {
            if (acc.accountNumber == accNum) {
                acc.displayAccountDetails();
                return;
            }
        }
        System.out.println("Account not found");
    }

    void updateContact() {
        System.out.print("Enter Account Number: ");
        int accNum = scanner.nextInt();
        scanner.nextLine();
        // find acount with the matching Account Number
        for (Account acc:accounts) {
            if (acc.accountNumber == accNum) {
                System.out.print("Enter new phone number: ");
                String phNum = scanner.nextLine();
                System.out.print("Enter new email: ");
                String email = scanner.nextLine();
                acc.updateContactDetails(email, phNum);
                return;
            }
        }
        System.out.println("Account not found");
    }

    void mainMenu() {
        System.out.println("1. Create a new account");
        System.out.println("2. Deposit money" );
        System.out.println("3. Withdraw money");
        System.out.println("4. View account details");
        System.out.println("5. Update contact details");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        if (choice == 1) {
                createAccount();
        }
        else if (choice == 2) {
                performDeposit();
        }
        else if (choice == 3) {
                performWithdrawl();
        }
        else if (choice == 4) {
                showAccountDetails();
        }
        else if (choice == 5) {
            updateContact();
        }
        else if (choice == 6) {
            System.exit(0);
        }
        else {
            System.out.println("Invalid Input");
        }
    }
}