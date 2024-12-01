package problem_five;

public class Pizza {
    private PizzaSize size;
    private PizzaType type;
    private int quantity;
    private double price = 0.0;
    private double tax = 0.0;
    private double totalPrice = 0.0;

    public Pizza(PizzaSize size, PizzaType type, int quantity) {
        this.size = size;
        this.type = type;
        this.quantity = quantity;
        calculatePrice(size, type);
    }
    //An attribute to calculate the price based on PizzaSize and PizzaType using calculatePrice() private method
    private void calculatePrice(PizzaSize size, PizzaType type){
        double sizePrice = switch(size){
            case SMALL -> 8.0;
            case MEDIUM -> 10.0;
            case LARGE -> 12.0;
        };
        double typePrice = switch(type){
            case VEGGIE -> 1.0;
            case PEPPERONI -> 2.0;
            case CHEEZE -> 1.5;
            case BBQCHICKEN -> 2;
        };
        this.price = (sizePrice + typePrice) * quantity;
        this.tax = this.price * 0.03;
        this.totalPrice = this.price + this.tax;
    }
    String printOrderSummary(){
        return String.format("Pizza Order:%nSize: %s%nType: %s%nQty: %d%nPrice: $%.2f%nTax: $%.2f%nTotal Price: $%.2f%n", size.name(), type.name(), quantity, price, tax, totalPrice);
    }
    // getter and setter methods
}
