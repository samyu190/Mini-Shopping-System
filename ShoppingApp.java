import java.util.ArrayList;
import java.util.Scanner;

public class ShoppingApp {
    // Ensure the class name matches the file name exactly
    static ArrayList<Product> productList = new ArrayList<>();
    static Cart cart = new Cart();
    static Scanner sc = new Scanner(System.in);

    // ✅ Correct main method signature
    public static void main(String[] args) {
        initializeProducts();
        System.out.println("🛍️ Welcome to Mini Shopping Cart 🛒");

        int choice;
        do {
            System.out.println("\n1. View Products");
            System.out.println("2. Add to Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Checkout");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> viewProducts();
                case 2 -> addToCart();
                case 3 -> cart.viewCart();
                case 4 -> checkout();
                case 5 -> System.out.println("Thank you for shopping!");
                default -> System.out.println("❌ Invalid choice!");
            }
        } while (choice != 5);
    }

    static void initializeProducts() {
        productList.add(new Product(1, "T-Shirt", 499.99));
        productList.add(new Product(2, "Jeans", 899.50));
        productList.add(new Product(3, "Sneakers", 1299.00));
        productList.add(new Product(4, "Watch", 699.99));
        productList.add(new Product(5, "Headphones", 499.00));
    }

    static void viewProducts() {
        System.out.println("\nAvailable Products:");
        for (Product p : productList) System.out.println(p);
    }

    static void addToCart() {
        viewProducts();
        System.out.print("\nEnter product ID: ");
        int id = sc.nextInt();
        System.out.print("Enter quantity: ");
        int qty = sc.nextInt();

        Product selected = null;
        for (Product p : productList) {
            if (p.getId() == id) selected = p;
        }

        if (selected != null) {
            cart.addToCart(selected, qty);
        } else {
            System.out.println("❌ Invalid product ID!");
        }
    }

    static void checkout() {
        if (cart.isEmpty()) {
            System.out.println("🛒 Cart is empty!");
            return;
        }
        double total = cart.getTotal();
        System.out.println("\n🧾 Checkout Summary");
        cart.viewCart();
        System.out.println("Total Amount: ₹" + total);
        System.out.print("Enter coupon code (SAVE10 / none): ");
        String code = sc.next();

        if (code.equalsIgnoreCase("SAVE10")) {
            total *= 0.9;
            System.out.println("🎉 Coupon Applied! 10% off");
        }

        System.out.println("Final Amount: ₹" + total);
        System.out.println("✅ Payment successful. Thank you!");
        cart.clear();
    }
}
