package DependencyInjectionExp.Factory;

import DependencyInjectionExp.Interfaces.InventoryService;
import DependencyInjectionExp.Interfaces.NotificationService;
import DependencyInjectionExp.Interfaces.PaymentService;
import DependencyInjectionExp.Processor.OrderProcessor;

// Using the factory
public class FactoryExample {
    public static void main(String[] args) {
        // Configuration could come from properties file, environment, etc.
        String paymentType = "paypal";
        String notificationType = "sms";

        // Create services through factory
        PaymentService paymentService = ServiceFactory.getPaymentService(paymentType);
        NotificationService notificationService = ServiceFactory.getNotificationService(notificationType);
        InventoryService inventoryService = ServiceFactory.getInventoryService();

        // Inject dependencies
        OrderProcessor processor = new OrderProcessor(
                paymentService, inventoryService, notificationService
        );

        Order order = new Order("ORD003", "CUST789", "user@test.com",
                "PROD123", 3, 149.97);

        System.out.println("=== Processing with factory-configured services ===");
        processor.processOrder(order);
    }
}
