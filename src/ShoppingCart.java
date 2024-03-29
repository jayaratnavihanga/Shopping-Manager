import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Product> productList;

    public ShoppingCart() {
        this.productList = new ArrayList<>();
    }

    public void addProducts(Product product) {
        productList.add(product);
        System.out.println(product.getProductName() + " added to the shopping cart");
    }

    public void removeProducts(Product product) {
        productList.remove(product);
        System.out.println(product.getProductName() + " removed from the shopping cart");
    }

    public double totalCost() {
        double total = 0;
        for (Product product : productList) {
            total += product.getPrice();
        }
        return total;
    }

    public void displayCart() {
        System.out.println("Shopping cart:");
        for (Product product : productList) {
            product.productInfo();
        }
        System.out.println("Total cost: $" + totalCost());
    }
}

