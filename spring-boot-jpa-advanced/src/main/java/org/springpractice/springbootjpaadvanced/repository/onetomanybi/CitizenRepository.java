package org.springpractice.springbootjpaadvanced.repository.onetomanybi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springpractice.springbootjpaadvanced.entity.onetomanybi.Citizen;

@Repository
public interface CitizenRepository extends JpaRepository<Citizen,Integer> {
}
