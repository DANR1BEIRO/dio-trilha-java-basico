import java.util.Scanner;

public class TerminalAccount {

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        Client client = new Client();

        System.out.println("To create an account, fill in the fields below.");

        while (true) {
            System.out.print("\nEnter your name: ");
            String name = input.nextLine().trim();

            if (!name.isEmpty() && name.matches("[a-zA-Z\\s]+")) {
                client.setName(name);
                break;
            } else {
                System.out.println("Name can't be empty and must contain only letters! Enter a valid name.");
            }
        }

        while (true) {
            System.out.print("Enter your bank branch (numbers only): ");
            
            if (input.hasNextInt()) { 
                int bankBranch = input.nextInt();
                input.nextLine(); 

                if (bankBranch > 0) { 
                    client.setBankBranch(bankBranch);
                    break;
                } else {
                    System.out.println("\nBank branch must be a positive number.");
                }
            } else {
                System.out.println("\nBank branch must contain only numbers.");
                input.nextLine(); 
            }
        }

        while (true) {
            System.out.print("\nEnter your account number (numbers only): ");

            if (input.hasNextInt()) {
                int accountNumber = input.nextInt();
                input.nextLine();

                if (accountNumber > 0) {
                    client.setAccountNumber(accountNumber);
                    break;    
                } else {
                    System.out.println("\nAccount number must be a positive number.");
                }
            } else {
                System.out.println("\nAccount number must contain only numbers.");
                input.nextLine();
            }

        }

        while (true) {
            System.out.print("\nEnter how much you want to deposit: $");

            if (input.hasNextDouble()) {
                double balance = input.nextDouble();
                input.nextLine();

                if (balance > 0) {
                    client.setBalance(balance);
                    break;
                } else {
                    System.out.println("\nDeposit amount can't be zero or negative");
                }

            } else {
                System.out.println("Enter a valid amount (only numbers)");
                input.nextLine();
            }
        }

        System.out.print("\nAccount successfully created!");
        System.out.println("\nName: " + client.getName() +
                           "\nBank branch: " + client.getBankBranch() + 
                           "\nAccount number: " +client.getAccountNumber() + 
                           "\nBalance: $" + client.getBalance());

        input.close();
    }
}
