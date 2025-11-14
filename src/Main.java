import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double balance = 0;
        boolean isRunning = true;
        int choice;

        while (isRunning) {
            printMenu();
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> showBalance(balance);
                case 2 -> balance = deposit(balance, scanner);
                case 3 -> balance = withdraw(balance, scanner);
                case 4 -> isRunning = false;
                default -> System.out.println("Error. Enter valid value.");
            }
        }

        scanner.close();
    }

    public static double readDeposit(Scanner scanner) {
        while (true) {
            if (!scanner.hasNextDouble()) { // hasNextDouble() entering data in buffer
                System.out.print("Invalid value. Try again: ");
                scanner.nextLine();
                continue;
            }

            double amount = scanner.nextDouble(); // there data from buffer saves into amount

            if (amount <= 0) {
                System.out.println("Invalid value. Deposit must be positive and above 0.");
                scanner.nextLine();
                continue;
            }

            return amount;
        }
    }

    public static double readWithdraw(Scanner scanner, double balance) {
        if (balance == 0) {
            System.out.println("You have no money to withdraw.");
            return 0;
        }

        while (true) {
            if (!scanner.hasNextDouble()) { // hasNextDouble() entering data in buffer
                System.out.print("Invalid value. Try again: ");
                scanner.nextLine();
                continue;
            }

            double amount = scanner.nextDouble(); // there data from buffer saves into amount

            if (amount <= 0) {
                System.out.println("Invalid value. Value must be positive and above 0.");
                scanner.nextLine();
                continue;
            }
            else if (amount > balance) {
                System.out.println("Invalid value. Value must be below or equal balance.");
                scanner.nextLine();
                continue;
            }

            return amount;
        }
    }

    public static void printMenu() {
        System.out.println("***************");
        System.out.println("BANKING PROGRAM");
        System.out.println("***************");
        System.out.println("1. Show Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
        System.out.println("***************");
        System.out.print("Your choice: ");
    }

    public static void showBalance(double balance) {
        System.out.printf("Your balance is $%.2f\n", balance);
    }

    public static double deposit(double balance, Scanner scanner) {
        System.out.print("How much money would you like to deposit: ");
        double deposit = readDeposit(scanner);
        balance += deposit;

        return balance;
    }

    public static double withdraw (double balance, Scanner scanner) {
        System.out.print("How much money would you like to withdraw: ");
        double withdraw = readWithdraw(scanner, balance);
        balance -= withdraw;

        return balance;
    }
}