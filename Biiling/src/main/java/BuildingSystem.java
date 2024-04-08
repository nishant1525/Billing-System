import java.util.ArrayList;
import java.util.List;
import com.Product;

public class BuildingSystem {
    private static List<Product> products = new ArrayList<>();

    public static void addProduct(Product product) {
        products.add(product);
    }

    public static List<Product> getProducts() {
        return products;
    }

    public static double calculateTotalBill() {
        double totalBill = 0;
        for (Product product : products) {
            totalBill += product.getTotalWithTaxes();
        }
        return totalBill;
    }
}
