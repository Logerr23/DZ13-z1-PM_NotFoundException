package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductMenegerTest {

    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);

    Product item1 = new Book(19, "Стрелок", 350, "Стивен Кинг");
    Product item2 = new Smartphone(66, "Стрелок", 19_766, "Sombra Corporation");
    Product item3 = new Book(24, "Зелёная миля", 525, "Стивен Кинг");
    Product item4 = new Book(80, "Прислуга", 588, "Кэтрин Стокетт");
    Product item5 = new Book(11, "Граф Монте-Кристо", 884, "Александра Дюма");
    Product item6 = new Smartphone(67, "iPhone XR", 44_995, "Apple");
    Product item7 = new Smartphone(70, "Galaxy S22 Ultra", 94_499, "Samsung");
    Product item8 = new Smartphone(22, "Poco X4 Pro", 22_770, "Poco");
    Product item9 = new Smartphone(53, "Xiaomi 12 Pro", 42_990, "Xiaomi");


    @BeforeEach
    public void setup(){
        manager.add(item1);
        manager.add(item2);
        manager.add(item3);
        manager.add(item4);
        manager.add(item5);
        manager.add(item6);
        manager.add(item7);
        manager.add(item8);
        manager.add(item9);
    }


    @Test
    public void matchesTest(){

        boolean expected = true;
        boolean actual = manager.matches(item1, "Стрелок");

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void searchByFindMultipleMatches(){

        Product[] expected = {item1, item2,};
        Product[] actual = manager.searchBy("Стрелок");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByTestFindOneMatch() {

        Product[] expected = {item4};
        Product[] actual = manager.searchBy("Прислуга");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByTestFindsNoMatch() {

        Product[] expected = {};
        Product[] actual = manager.searchBy("Извлечение троих");

        Assertions.assertArrayEquals(expected, actual);
    }




}
