package ru.netology;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductRepositoryTest {

    Product item1 = new Book(19, "Стрелок", 350, "Стивен Кинг");
    Product item2 = new Book(24, "Зелёная миля", 525, "Стивен Кинг");
    Product item3 = new Book(80, "Прислуга", 588, "Кэтрин Стокетт");
    Product item4 = new Book(11, "Граф Монте-Кристо", 884, "Александра Дюма");
    Product item5 = new Smartphone(67, "iPhone XR", 44_995, "Apple");
    Product item6 = new Smartphone(70, "Galaxy S22 Ultra", 94_499, "Samsung");
    Product item7 = new Smartphone(22, "Poco X4 Pro", 22_770, "Poco");
    Product item8 = new Smartphone(53, "Xiaomi 12 Pro", 42_990, "Xiaomi");
    Product item9 = new Smartphone(19, "Xiaomi 12 Pro", 42_990, "Xiaomi");

    ProductRepository repo = new ProductRepository();


    @Test
    public void saveProductsWithDifferentId() {
        repo.saveProduct(item1);
        repo.saveProduct(item2);
        repo.saveProduct(item5);
        repo.saveProduct(item8);

        Product[] expected = {item1, item2, item5, item8};
        Product[] actual = repo.getProducts();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void saveProductsWithTheSameId() {
        repo.saveProduct(item1);

        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            repo.saveProduct(item9);
        });

    }



    @Test
    public void removeByIdProductInStock() {
        repo.saveProduct(item3);
        repo.saveProduct(item4);
        repo.saveProduct(item6);
        repo.saveProduct(item7);

        repo.removeById(item4.getId());
        repo.removeById(item6.getId());

        Product[] expected = {item3, item7};
        Product[] actual = repo.getProducts();

        Assertions.assertArrayEquals(expected, actual);

    }
    @Test
    public void removeByIdProductIsMissing() {
        repo.saveProduct(item1);
        repo.saveProduct(item2);
        repo.saveProduct(item3);
        repo.saveProduct(item4);


        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(item8.getId());
        });

    }



    @Test
    public void findById(){
        repo.saveProduct(item1);
        repo.saveProduct(item2);
        repo.saveProduct(item5);
        repo.saveProduct(item8);

        Product expected = item1;
        Product actual = repo.findById(19);

        Assertions.assertEquals(expected, actual);


    }


}
