package DependencyInjectionExp.Interfaces;

public interface InventoryService {
    boolean checkStock (String productId, int quantity);
    void updateStock (String productId, int quantity);
}
