package DependencyInjectionExp.Processor;

import DependencyInjectionExp.Interfaces.InventoryService;
import DependencyInjectionExp.Interfaces.NotificationService;
import DependencyInjectionExp.Interfaces.PaymentService;

public class OrderProcessor {
    private final PaymentService paymentService;
    private final InventoryService inventoryService;
    private NotificationService notificationService;

    // Constructor Injection
    public OrderProcessor(PaymentService paymentService, InventoryService inventoryService, NotificationService notificationService) {
        this.paymentService = paymentService;
        this.inventoryService = inventoryService;
        this.notificationService = notificationService;
    }

    public boolean processOrder(Order order) {
        System.out.println("Processing order: " + order.orderId());

        // Check inventory
        if (!inventoryService.checkStock(order.productId(), order.quantity())) {
            System.out.println("Insufficient stock for order: " + order.orderId());
            return false;
        }

        // Process payment
        if (!paymentService.processPayment(order.totalAmount(), order.customerId())) {
            System.out.println("Payment failed for order: " + order.orderId());
            return false;
        }

        // Update inventory
        inventoryService.updateStock(order.productId(), order.quantity());

        // Send confirmation
        notificationService.sendOrderConfirmation(order.orderId(), order.customerEmail());

        System.out.println("Order processed successfully using: " + paymentService.getProviderName());
        return true;
    }

    // Optional setter for changing notification service at runtime
    public void setNotificationService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }
}

