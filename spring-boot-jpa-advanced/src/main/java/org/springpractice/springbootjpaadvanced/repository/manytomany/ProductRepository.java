package org.springpractice.springbootjpaadvanced.repository.manytomany;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springpractice.springbootjpaadvanced.entity.manytomany.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
}
