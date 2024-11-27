package problem1;

public class Main {
    public static void main(String[] args) {
        Customer customer1 = new Customer("Amadu","Jallo", "6789");
        customer1.setBillingAddress(new Address("456 Elm Street, Suite 3", " Los Angeles", "CA", "90001"));
        System.out.println(customer1.toString());
    }
}
