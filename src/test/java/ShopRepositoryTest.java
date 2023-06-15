import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {

    @Test
    public void shouldRemoveWhenProductExist() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(123, "компьютер", 75_000);
        Product product2 = new Product(45, "сумка", 5_000);
        Product product3 = new Product(99, "мотоцикл", 700_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.remove(123);

        Product[] actual = repo.findAll();
        Product[] expected = {product2, product3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveWhenProductNotExist() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(123, "компьютер", 75_000);
        Product product2 = new Product(45, "сумка", 5_000);
        Product product3 = new Product(99, "мотоцикл", 700_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        Assertions.assertThrows(NotFoundException.class,
                () -> repo.remove(10)
        );
    }
}
