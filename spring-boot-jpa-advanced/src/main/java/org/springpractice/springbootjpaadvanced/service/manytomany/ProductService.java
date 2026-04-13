package org.springpractice.springbootjpaadvanced.service.manytomany;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import org.springpractice.springbootjpaadvanced.entity.manytomany.Category;
import org.springpractice.springbootjpaadvanced.entity.manytomany.Product;
import org.springpractice.springbootjpaadvanced.repository.manytomany.CategoryRepository;
import org.springpractice.springbootjpaadvanced.repository.manytomany.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    private final CategoryRepository categoryRepository;

    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @PostConstruct
    public void init() {

        System.out.println("Many to Many Bi Directional Mapping");
        System.out.println("Deleting all Data.");

        productRepository.deleteAll();
        categoryRepository.deleteAll();

        System.out.println("Saving Data.");

        Product product1 = new Product(101, "Samsung S20", "Mobile Phone");
        Product product2 = new Product(102, "Google Pixel 10", "Mobile Phone");
        Product product3 = new Product(103, "Dell Inspiron", "Laptop");
        Product product4 = new Product(104, "Samsung TV 132", "Television");

        Category category1 = new Category(1001, "Electronics", "Electronics");
        Category category2 = new Category(1002, "Mobiles", "Mobiles");
        Category category3 = new Category(1003, "Television", "Television");

        product1.setCategories(List.of(category1, category2));
        product2.setCategories(List.of(category1, category2));
        product3.setCategories(List.of(category1));
        product4.setCategories(List.of(category1, category3));

        /*category1.setProducts(List.of(product1, product2, product3, product4));
        category2.setProducts(List.of(product1, product2));
        category3.setProducts(List.of(product4));*/

        //categoryRepository.saveAll(List.of(category1, category2, category3));
        productRepository.saveAll(List.of(product1, product2, product3, product4));

        System.out.println("Saved Data.");
        System.out.println("Loading Data.");

        Optional<Category> category = categoryRepository.findById(1002);
        category.ifPresent(c -> c.getProducts().forEach(p -> System.out.println(p.getProductName())));

        System.out.println("Deleting Product.");

        Optional<Product> product = productRepository.findById(101);
        if (product.isPresent()) {
            product.get().setCategories(List.of());
            productRepository.save(product.get());
        }

        productRepository.deleteById(101);

        System.out.println("Category size after deletion.");

        System.out.println(categoryRepository.findAll().size());

    }

}
