import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Program7 {
    public static void main(String[] args) {
        // Initialize stacks and queues
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

        // Generate 10 Customer objects and add to queue
        for (int i = 0; i < 10; i++) {
            String customerID = "CUST" + i;
            String name = "Customer" + i;
            Customer customer = new Customer(customerID, name, null);
            customerQueue.add(customer);
        }

        // Simulation process
        for (int i = 0; i < 30; i++) {
            Customer customer = customerQueue.poll();

            if (customer.getAccount() == null) {
                Account account = (i % 2 == 0) ? checkStack.pop() : saveStack.pop();
                customer = new Customer(customer.getCustomerID(), customer.getName(), account);
            }

            double transactionAmount = random.nextDouble() * 200 - 100; // Random value between -100 and 100
            if (transactionAmount > 0) {
                customer.getAccount().deposit(transactionAmount);
            } else {
                customer.getAccount().withdraw(-transactionAmount);
            }

            customerQueue.add(customer);
        }

        // Print each Customer object's details
        for (Customer customer : customerQueue) {
            System.out.println(customer);
        }

        // Save the customerQueue to a file
        writeQueueToFile(customerQueue, "Customers.dat");
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
