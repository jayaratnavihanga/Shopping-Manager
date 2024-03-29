import java.io.Serializable;

public abstract class Product implements Serializable {
    private static final long serialVersionUID = 1L;

    private String productId;
    private String productName;
    private int itemCount;
    private double price;

    public Product(String productId, String productName, int itemCount, double price) {
        this.productId = productId;
        this.productName = productName;
        this.itemCount = itemCount;
        this.price = price;
    }

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public int getItemCount() {
        return itemCount;
    }

    public double getPrice() {
        return price;
    }

    public abstract void productInfo();
}


