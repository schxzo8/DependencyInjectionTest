package DependencyInjectionExp.Interfaces;

public interface NotificationService {
    void sendOrderConfirmation (String orderId, String customerEmail);
    void sendShippingUpdate (String orderId, String customerEmail);
}
