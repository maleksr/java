import java.util.List;
import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.Comparator;
import java.util.stream.Stream;
import java.util.Collections;

public class ProductManagement implements Management {

    @Override
    public void displayProducts(List<Product> products, Consumer<Product> con) {
        for (Product product : products) {
            con.accept(product);
        }
    }

    @Override
    public void displayProductsByFilter(List<Product> products, Predicate<Product> pre, Consumer<Product> con) {
        for (Product product : products) {
            if (pre.test(product)) {
                con.accept(product);
            }
        }
    }

    @Override
    public String returnProductsNames(List<Product> products, Function<Product, String> fun) {
        StringBuilder result = new StringBuilder();
        for (Product product : products) {
            result.append(fun.apply(product)).append("; ");
        }
        // Retirer le dernier "; " si la liste n'est pas vide
        if (result.length() > 0) {
            result.setLength(result.length() - 2);
        }
        return result.toString();
    }

    @Override
    public Product createProduct(Supplier<Product> sup) {
        return sup.get();
    }

    @Override
    public List<Product> sortProductsById(List<Product> products, Comparator<Product> com) {
        List<Product> sortedList = new ArrayList<>(products);
        Collections.sort(sortedList, com);
        return sortedList;
    }

}