package problem_one;

public class Main {
    public static void main(String[] args) {
        Customer customer1 = new Customer("Amadu", "Jallo", "6789");
        Customer customer2 = new Customer("Alexander", "Kisekka", "1234");
        Customer customer3 = new Customer("John", "Doe", "5678");

        // Address(String street, String city, String state, String zipCode)
        customer1.setBillingAddress(new Address("456 Elm Street, Suite 3", "Los Angeles", "CA", "90001"));
        customer1.setShippingAddress(new Address("789 Pine Avenue, Apt 5", "San Diego", "CA", "92101"));

        customer2.setBillingAddress(new Address("123 Maple Drive", "New York", "NY", "10001"));
        customer2.setShippingAddress(new Address("456 Oak Lane", "Brooklyn", "NY", "11201"));

        customer3.setBillingAddress(new Address("789 Birch Road", "Chicago", "IL", "60601"));
        customer3.setShippingAddress(new Address("321 Cedar Street", "Naperville", "IL", "60540"));

        //add instances to an array
        Customer[] customers = {customer1, customer2, customer3};
        for (Customer customer : customers) {
            if(customer.getBillingAddress().getCity().equals("Chicago")){
                System.out.printf("Customer with billing address in %s is: %n", customer.getBillingAddress().getCity());
                System.out.println(customer.toString());
                System.out.println("Billing address:");
                System.out.println(customer.getBillingAddress());
            }
        }
    }
}
