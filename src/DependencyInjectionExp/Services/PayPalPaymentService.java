package DependencyInjectionExp.Services;

import DependencyInjectionExp.Interfaces.PaymentService;

// PayPal payment implementation
public class PayPalPaymentService implements PaymentService {
    @Override
    public boolean processPayment(double amount, String customerId) {
        System.out.println("Processing PayPal payment of $" + amount + " for customer: " + customerId);
        return Math.random() > 0.05; // 95% success rate
    }

    @Override
    public String getProviderName() {
        return "PayPal";
    }
}
