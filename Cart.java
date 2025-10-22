import java.util.ArrayList;

public class Cart {
    private ArrayList<Product> products = new ArrayList<>();
    private ArrayList<Integer> quantities = new ArrayList<>();

    public void addToCart(Product product, int quantity) {
        products.add(product);
        quantities.add(quantity);
        System.out.println("✅ Added " + quantity + " x " + product.getName() + " to cart.");
    }

    public void viewCart() {
        if (products.isEmpty()) {
            System.out.println("🛒 Cart is empty!");
            return;
        }
        System.out.println("\nYour Cart:");
        double total = 0;
        for (int i = 0; i < products.size(); i++) {
            Product p = products.get(i);
            int qty = quantities.get(i);
            double subtotal = p.getPrice() * qty;
            System.out.println(p.getName() + " x " + qty + " = ₹" + subtotal);
            total += subtotal;
        }
        System.out.println("----------------------");
        System.out.println("Subtotal: ₹" + total);
    }

    public double getTotal() {
        double total = 0;
        for (int i = 0; i < products.size(); i++) {
            total += products.get(i).getPrice() * quantities.get(i);
        }
        return total;
    }

    public void clear() {
        products.clear();
        quantities.clear();
    }

    public boolean isEmpty() {
        return products.isEmpty();
    }
}
