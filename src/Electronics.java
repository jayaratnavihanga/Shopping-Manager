public class Electronics extends Product {

    private String brand;
    private int warrantyPeriod;

    public Electronics(String productId, String productName, int itemCount, double price, String brand, int warrantyPeriod) {
        super(productId, productName, itemCount, price);
        this.brand = brand;
        this.warrantyPeriod = warrantyPeriod;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getWarrantyPeriod() {
        return warrantyPeriod;
    }

    public void setWarrantyPeriod(int warrantyPeriod) {
        this.warrantyPeriod = warrantyPeriod;
    }

    @Override
    public void productInfo() {
        System.out.println("Electronics - Product ID: " + getProductId() + ", Name: " + getProductName() +
                ", Brand: " + getBrand() + ", Warranty Period: " + getWarrantyPeriod() +
                " months, Price: $" + getPrice() + ", Available Pieces: " + getItemCount());
    }
}


