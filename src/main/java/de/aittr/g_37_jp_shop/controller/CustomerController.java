package de.aittr.g_37_jp_shop.controller;

import de.aittr.g_37_jp_shop.domain.entity.Customer;
import de.aittr.g_37_jp_shop.service.interfaces.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    private CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @GetMapping
    public Customer getById(@RequestParam Long id){
        return service.getById(id);
    }

    @PostMapping
    public Customer save(@RequestBody Customer customer){
        return service.save(customer);
    }

    @GetMapping("/all")
    public List<Customer> getAll(){
        return service.getAll();
    }
}
