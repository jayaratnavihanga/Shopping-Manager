public class Clothing extends Product {

    private String size;
    private String color;
    private String clothingBrand;

    public Clothing(String productId, String productName, int itemCount, double price, String size, String color, String clothingBrand) {
        super(productId, productName, itemCount, price);
        this.size = size;
        this.color = color;
        this.clothingBrand = clothingBrand;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getClothingBrand() {
        return clothingBrand;
    }

    public void setClothingBrand(String clothingBrand) {
        this.clothingBrand = clothingBrand;
    }

    @Override
    public void productInfo() {
        System.out.println("Clothing - Product ID: " + getProductId() + ", Name: " + getProductName() +
                ", Brand: " + getClothingBrand() + ", Size: " + getSize() + ", Color: " + getColor() +
                ", Price: $" + getPrice() + ", Available Pieces: " + getItemCount());
    }
}
