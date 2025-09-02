package DependencyInjectionExp.Services;

import DependencyInjectionExp.Interfaces.NotificationService;

// Email notification implementation
public class EmailNotificationService implements NotificationService {
    @Override
    public void sendOrderConfirmation(String orderId, String customerEmail) {
        System.out.println("Sending order confirmation email to: " + customerEmail + " for order: " + orderId);
    }

    @Override
    public void sendShippingUpdate(String orderId, String customerEmail) {
        System.out.println("Sending shipping update email to: " + customerEmail + " for order: " + orderId);
    }
}