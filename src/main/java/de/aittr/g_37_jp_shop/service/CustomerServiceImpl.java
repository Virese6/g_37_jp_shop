package de.aittr.g_37_jp_shop.service;

import de.aittr.g_37_jp_shop.domain.entity.Customer;
import de.aittr.g_37_jp_shop.repository.CustomerRepository;
import de.aittr.g_37_jp_shop.service.interfaces.CustomerService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository repository;

    public CustomerServiceImpl(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public Customer save(Customer customer) {
        return null;
    }

    @Override
    public List<Customer> getAll() {
        return null;
    }

    @Override
    public Customer getById(Long id) {
        if(id ==null || id<1){
            throw new RuntimeException("Customer's id is incorrect!");
        }

        Customer customer = repository.findById(id).orElse(null);
        if(customer == null){
            throw new RuntimeException("Customer not found!");
        }
        return customer;
    }

    @Override
    public void update(Customer customer) {

    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void deleteByName(String name) {

    }

    @Override
    public void restoreById(Long id) {

    }

    @Override
    public int getTotalQuantity() {
        return 0;
    }

    @Override
    public BigDecimal getTotalPrice(Long id) {
        return null;
    }

    @Override
    public BigDecimal getAveragePrice(Long id) {
        return null;
    }
}
