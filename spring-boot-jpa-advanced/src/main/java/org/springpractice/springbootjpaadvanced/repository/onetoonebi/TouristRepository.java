package org.springpractice.springbootjpaadvanced.repository.onetoonebi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springpractice.springbootjpaadvanced.entity.onetoonebi.Tourist;

@Repository
public interface TouristRepository extends JpaRepository<Tourist, Integer> {
}
