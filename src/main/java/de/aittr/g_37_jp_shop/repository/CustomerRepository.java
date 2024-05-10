package de.aittr.g_37_jp_shop.repository;

import de.aittr.g_37_jp_shop.domain.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    //@Query(value = "SELECT * FROM product WHERE name = :name", nativeQuery = true)
    Customer findByName(String name);
}

