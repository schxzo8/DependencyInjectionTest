package DependencyInjectionExp.Factory;

import DependencyInjectionExp.Interfaces.InventoryService;
import DependencyInjectionExp.Interfaces.NotificationService;
import DependencyInjectionExp.Interfaces.PaymentService;
import DependencyInjectionExp.Services.*;

// Simple factory/injector class
public class ServiceFactory {

    public static PaymentService getPaymentService(String type) {
        return switch (type.toLowerCase()) {
            case "paypal" -> new PayPalPaymentService();
            default -> new CreditCardPaymentService();
        };
    }

    public static NotificationService getNotificationService(String type) {
        return switch (type.toLowerCase()) {
            case "sms" -> new SMSNotificationService();
            default -> new EmailNotificationService();
        };
    }

    public static InventoryService getInventoryService() {
        return new DatabaseInventoryService();
    }
}

