import java.io.*;
import java.util.*;

public class WestminsterShoppingManager implements ShoppingManager, Serializable {
    private static final long serialVersionUID = 1L;
    private List<Product> productList = new ArrayList<>();

    public WestminsterShoppingManager() {
    }

    @Override
    public void addProducts(Product product) {
        int maximumProducts = 50;
        if (productList.size() < maximumProducts) {
            System.out.println("Product added to the system.");
            productList.add(product);
        } else {
            System.out.println("Cannot add more products. Maximum limit reached.");
        }
    }

    @Override
    public void removeProducts(Product productId) {
        Iterator<Product> iterator = productList.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product != null && product.getProductId() != null && product.getProductId().equals(productId.getProductId())) {
                iterator.remove();
                System.out.println("Product removed successfully.");
                return;
            }
        }
        System.out.println("Product " + productId.getProductId() + " is not found");
    }

    @Override
    public double calculateTotalCost() {
        double totalCost = 0;
        for (Product product : productList) {
            totalCost += product.getPrice();
        }
        return totalCost;
    }

    @Override
    public void displayproducts() {
        for (Product product : productList) {
            System.out.println("Product ID: " + product.getProductId());
            System.out.println("Product Name: " + product.getProductName());
            System.out.println("Product Price: " + product.getPrice());
            System.out.println("Available Product Pieces: " + product.getItemCount());
            if (product instanceof Electronics) {
                System.out.println("Type: Electronics");
            } else if (product instanceof Clothing) {
                System.out.println("Type: Clothing");
            }
            System.out.println();
        }
    }

    public void displaymenu() {
        Scanner scanner = new Scanner(System.in);
        int option;
        do {
            System.out.println("**** Westminster Shopping Manager Menu ****");
            System.out.println("1. Add a new Product");
            System.out.println("2. Remove a product");
            System.out.println("3. Display all products");
            System.out.println("4. Save products");
            System.out.println("5. Load products");
            System.out.println("6. Exit");
            System.out.println("Enter your choice ");

            option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    addProductsForTheManager(scanner);
                    break;
                case 2:
                    removeProductsFromManager(scanner);
                    break;
                case 3:
                    displayproducts();
                    break;
                case 4:
                    saveProducts("savedItems.txt");
                    break;
                case 5:
                    loadProducts();
                    break;
                case 6:
                    System.out.println("Exiting the shopping manager");
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        } while (option != 6);
    }

    public void addProductsForTheManager(Scanner scanner) {
        System.out.println("Add a new product to the system");
        System.out.println("Enter the product type \n1. Electronics \n2. Clothes");
        int productType = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter product ID: ");
        String productId = scanner.nextLine();
        System.out.print("Enter product name: ");
        String productName = scanner.nextLine();
        System.out.print("Enter the number of available items: ");
        int availablePieces = scanner.nextInt();
        System.out.print("Enter the Price: ");
        int price = scanner.nextInt();
        scanner.nextLine();
        if (productType == 1) {
            System.out.print("Enter the brand: ");
            String brand = scanner.nextLine();
            System.out.print("Enter the warranty period in months: ");
            int warrantyperiod = scanner.nextInt();
            addProducts(new Electronics(productId, productName, price, availablePieces, brand, warrantyperiod));
        } else if (productType == 2) {
            System.out.print("Enter the size: ");
            String size = scanner.nextLine();
            System.out.print("Enter the color: ");
            String color = scanner.nextLine();
            System.out.print("Enter the clothing brand: ");
            String brand = scanner.nextLine();
            addProducts(new Clothing(productId, productName, availablePieces, price, brand, color, size));
        } else {
            System.out.println("Invalid product type");
        }
    }

    public void removeProductsFromManager(Scanner scanner) {
        System.out.println("Remove a product from the system");
        System.out.print("Enter product ID: ");
        String productId = scanner.next();
        removeProducts(new Product(productId, null, 0, 0) {
            @Override
            public void productInfo() {
            }
        });
    }

    public void saveProducts(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (Product product : productList) {
                writer.println("Product ID: " + product.getProductId());
                writer.println("Product Name: " + product.getProductName());
                writer.println("Product Price: " + product.getPrice());
                writer.println("Available Product Pieces: " + product.getItemCount());
                if (product instanceof Electronics) {
                    writer.println("Type: Electronics");
                } else if (product instanceof Clothing) {
                    writer.println("Type: Clothing");
                }
                writer.println(); // Add an empty line between products
            }
            System.out.println("Products saved to file successfully.");
        } catch (IOException e) {
            System.out.println("Error saving products to file: " + e.getMessage());
        }
    }

    public void loadProducts() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("savedItems.dat"))) {
            List<Product> loadedProducts = (List<Product>) inputStream.readObject();
            productList.clear();
            productList.addAll(loadedProducts);
            System.out.println("Products loaded from file successfully.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading products from file: " + e.getMessage());
        }
    }
}



