package de.aittr.g_37_jp_shop.service.interfaces;

import de.aittr.g_37_jp_shop.domain.entity.Customer;
import de.aittr.g_37_jp_shop.domain.entity.Product;

import java.math.BigDecimal;
import java.util.List;

public interface CustomerService {
    Customer save(Customer customer);
    List<Customer> getAll();
    Customer getById(Long id);
    void update(Customer customer);
    void deleteById(Long id);
    void deleteByName(String name);
    void restoreById(Long id);
    int getTotalQuantity();
    BigDecimal getTotalPrice(Long id);
    BigDecimal getAveragePrice(Long id);

}
