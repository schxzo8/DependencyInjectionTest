package DependencyInjectionExp.Testing;

import DependencyInjectionExp.Interfaces.InventoryService;
import DependencyInjectionExp.Interfaces.NotificationService;
import DependencyInjectionExp.Interfaces.PaymentService;
import DependencyInjectionExp.Processor.Order;
import DependencyInjectionExp.Processor.OrderProcessor;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

// Test with mock services
public class OrderProcessorTest {

    @Test
    public void testOrderProcessing() {
        // Create mock services for testing
        PaymentService mockPaymentService = new MockPaymentService();
        InventoryService mockInventoryService = new MockInventoryService();
        NotificationService mockNotificationService = new MockNotificationService();

        // Inject mock dependencies
        OrderProcessor processor = new OrderProcessor(
                mockPaymentService, mockInventoryService, mockNotificationService
        );

        Order testOrder = new Order("TEST001", "TEST_CUST", "test@example.com",
                "TEST_PROD", 1, 100.00);

        // Test the order processing
        boolean result = processor.processOrder(testOrder);

        assertTrue("Order should be processed successfully", result);
    }
}

// Mock implementations for testing
class MockPaymentService implements PaymentService {
    @Override
    public boolean processPayment(double amount, String customerId) {
        return true; // Always succeed for testing
    }

    @Override
    public String getProviderName() {
        return "Mock Payment Service";
    }
}

class MockInventoryService implements InventoryService {
    @Override
    public boolean checkStock(String productId, int quantity) {
        return true; // Always in stock for testing
    }

    @Override
    public void updateStock(String productId, int quantity) {
        // Do nothing - just a mock
    }
}

class MockNotificationService implements NotificationService {
    @Override
    public void sendOrderConfirmation(String orderId, String customerEmail) {
        System.out.println("[MOCK] Would send confirmation to: " + customerEmail);
    }

    @Override
    public void sendShippingUpdate(String orderId, String customerEmail) {
        System.out.println("[MOCK] Would send shipping update to: " + customerEmail);
    }
}