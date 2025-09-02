package DependencyInjectionExp.Interfaces;

public interface PaymentService {
    boolean processPayment(double amount, String customerId);
    String getProviderName();
}