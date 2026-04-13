package org.springpractice.springbootjpaadvanced.repository.manytomany;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springpractice.springbootjpaadvanced.entity.manytomany.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
