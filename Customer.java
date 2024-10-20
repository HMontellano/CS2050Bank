import java.io.Serializable;

public class Customer implements Serializable {
    private String customerID;
    private String name;
    private Account account;

    public Customer(String customerID, String name, Account account) {
        this.customerID = customerID;
        this.name = name;
        this.account = account;
    }

    public String getCustomerID() {
        return customerID;
    }

    public String getName() {
        return name;
    }

    public Account getAccount() {
        return account;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerID='" + customerID + '\'' +
                ", name='" + name + '\'' +
                ", account=" + account +
                '}';
    }
}