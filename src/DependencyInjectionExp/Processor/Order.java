package DependencyInjectionExp.Processor;

//Simple Order class
public record Order(String orderId, String customerId, String customerEmail, String productId, int quantity,double totalAmount) {
    // Constructor, getters, and setters

}

