package DependencyInjectionExp.Controller;

import DependencyInjectionExp.Interfaces.InventoryService;
import DependencyInjectionExp.Interfaces.NotificationService;
import DependencyInjectionExp.Interfaces.PaymentService;
import DependencyInjectionExp.Processor.Order;
import DependencyInjectionExp.Processor.OrderProcessor;
import DependencyInjectionExp.Services.*;

public class ManualDependencyInjectionExample {
    public static void main(String[] args) {
        // Create dependencies manually
        PaymentService creditCardService = new CreditCardPaymentService();
        PaymentService paypalService = new PayPalPaymentService();

        InventoryService inventoryService = new DatabaseInventoryService();

        NotificationService emailService = new EmailNotificationService();
        NotificationService smsService = new SMSNotificationService();

        // Inject dependencies through constructor
        OrderProcessor creditCardProcessor = new OrderProcessor(
                creditCardService, inventoryService, emailService
        );

        OrderProcessor paypalProcessor = new OrderProcessor(
                paypalService, inventoryService, smsService
        );

        // Create test orders
        Order order1 = new Order("ORD001", "CUST123", "customer@example.com",
                "PROD456", 2, 99.98);
        Order order2 = new Order("ORD002", "CUST456", "client@company.com",
                "PROD789", 1, 49.99);

        // Process orders with different configurations
        System.out.println("\nProcessing with Credit Card + Email");
        creditCardProcessor.processOrder(order1);

        System.out.println("\nProcessing with PayPal + SMS");
        paypalProcessor.processOrder(order2);

        // Use setter injection to change behavior at runtime
        System.out.println("\nChanging notification service at runtime");
        creditCardProcessor.setNotificationService(smsService);
        creditCardProcessor.processOrder(order1);
    }
}