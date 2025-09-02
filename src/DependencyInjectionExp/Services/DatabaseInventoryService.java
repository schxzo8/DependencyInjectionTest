package DependencyInjectionExp.Services;

import DependencyInjectionExp.Interfaces.InventoryService;

// Database inventory implementation
public class DatabaseInventoryService implements InventoryService {
    @Override
    public boolean checkStock(String productId, int quantity) {
        System.out.println("Checking stock for product " + productId + ", quantity: " + quantity);
        // Simulate database check
        return true; // Always in stock for demo
    }

    @Override
    public void updateStock(String productId, int quantity) {
        System.out.println("Updating stock for product " + productId + ", change: " + (-quantity));
    }
}