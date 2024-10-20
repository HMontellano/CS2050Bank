import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Program5 {
    public static void main(String[] args) {
        AccountStack<CheckingAccount> checkStack = new AccountStack<>();
        AccountStack<SavingsAccount> saveStack = new AccountStack<>();
        Queue<Customer> customerQueue = new LinkedList<>();
        Random random = new Random();

        // Generate 25 CheckingAccount objects
        for (int i = 0; i < 25; i++) {
            String accountNumber = String.valueOf(random.nextInt(1000000));
            CheckingAccount checkingAccount = new CheckingAccount(accountNumber, "Holder" + i, 1000.0, 500.0);
            checkStack.push(checkingAccount);
        }

        // Generate 25 SavingsAccount objects
        for (int i = 0; i < 25; i++) {
            String accountNumber = String.valueOf(random.nextInt(1000000));
            SavingsAccount savingsAccount = new SavingsAccount(accountNumber, "Holder" + i, 1000.0, 0.05);
            saveStack.push(savingsAccount);
        }

        // Write checkStack to file
        writeStackToFile(checkStack, "CheckStack.dat");

        // Write saveStack to file
        writeStackToFile(saveStack, "SaveStack.dat");

        // Generate 10 Customer objects and add to queue
        for (int i = 0; i < 10; i++) {
            String customerID = "CUST" + i;
            String name = "Customer" + i;
            Account account = (i % 2 == 0) ? checkStack.pop() : saveStack.pop();
            Customer customer = new Customer(customerID, name, account);
            customerQueue.add(customer);
        }

        // Write customerQueue to file
        writeQueueToFile(customerQueue, "Customers.dat");
    }

    private static <T> void writeStackToFile(AccountStack<T> stack, String fileName) {
        try (FileOutputStream fos = new FileOutputStream(fileName);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(stack.getStack());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeQueueToFile(Queue<Customer> queue, String fileName) {
        try (FileOutputStream fos = new FileOutputStream(fileName);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(queue);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
