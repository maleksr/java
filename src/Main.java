import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        Product p1 = new Product(1, "Laptop", 999.99);
        Product p2 = new Product(2, "Smartphone", 499.99);
        Product p3 = new Product(3, "Tablet", 299.99);

        List<Product> products = Arrays.asList(p1, p2, p3);

        ProductManagement pm = new ProductManagement();


        System.out.println("=== Tous les produits ===");
        pm.displayProducts(products, System.out::println);


        System.out.println("\n=== Produits > 400€ ===");
        pm.displayProductsByFilter(products, p -> p.getPrix() > 400, System.out::println);


        System.out.println("\n=== Noms des produits ===");
        String names = pm.returnProductsNames(products, Product::getNom);
        System.out.println(names);


        System.out.println("\n=== Création d'un produit ===");
        Product newProduct = pm.createProduct(() -> new Product(4, "Headphones", 99.99));
        System.out.println(newProduct);


        System.out.println("\n=== Produits triés par ID (décroissant) ===");
        List<Product> sortedProducts = pm.sortProductsById(products,Comparator.comparing(Product::getId)
        );
        sortedProducts.forEach(System.out::println);

    }
}