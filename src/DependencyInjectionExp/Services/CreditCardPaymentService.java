package DependencyInjectionExp.Services;

import DependencyInjectionExp.Interfaces.PaymentService;

// Credit Card payment implementation
public class CreditCardPaymentService implements PaymentService {
    @Override
    public boolean processPayment(double amount, String customerId) {
        System.out.println("Processing credit card payment of $" + amount + " for customer: " + customerId);
        // Simulate payment processing logic
        return Math.random() > 0.1; // 90% success rate for demo
    }

    @Override
    public String getProviderName() {
        return "Stripe Credit Card Processor";
    }
}