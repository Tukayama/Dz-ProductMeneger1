package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.manager.NotFoudExcertion;
import ru.netology.manager.ProductManager;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    ProductRepository repository = new ProductRepository();
    private Book one = new Book(1, "testBook", 50, "Ivanov");
    private Smartphone two = new Smartphone(2, "TestSmartphone", 1000, "Xiaomi");
    private Smartphone three = new Smartphone(3, "TestSmartphone", 1000, "LG");
    private Book four = new Book(4, "testBook", 50, "Ivanov");

    @BeforeEach
    public void example() {

        repository.save(one);
        repository.save(two);
        repository.save(three);
        repository.save(four);
    }

        @Test
    public void deleteId (){
        Product[] expected = new Product[]{one,two,three};
        Product[]actual=repository.removeById(4);
        assertArrayEquals(expected, actual);
    }
    @Test
    public void removeByIdNotFoundException() {

      assertThrows(NotFoudExcertion.class, () -> repository.removeById(9));
    }

}