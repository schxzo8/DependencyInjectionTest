package DependencyInjectionExp.Services;

import DependencyInjectionExp.Interfaces.NotificationService;

// SMS notification implementation
public class SMSNotificationService implements NotificationService {
    @Override
    public void sendOrderConfirmation(String orderId, String customerEmail) {
        System.out.println("Sending SMS confirmation to phone associated with: " + customerEmail + " for order: " + orderId);
    }

    @Override
    public void sendShippingUpdate(String orderId, String customerEmail) {
        System.out.println("Sending SMS shipping update to phone associated with: " + customerEmail + " for order: " + orderId);
    }
}