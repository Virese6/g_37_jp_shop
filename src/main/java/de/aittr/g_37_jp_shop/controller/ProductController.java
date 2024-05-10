package de.aittr.g_37_jp_shop.controller;

import de.aittr.g_37_jp_shop.domain.dto.ProductDto;
import de.aittr.g_37_jp_shop.exception_handling.Response;
import de.aittr.g_37_jp_shop.exception_handling.exceptions.FirstTestException;
import de.aittr.g_37_jp_shop.service.interfaces.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    // GET - localhost:8080/products/example/5  -> the first variant
    // @PathVariable <- add annotation in parameter for the first variant
    // /example/{id} <- add in annotation for the first variant
    //    @GetMapping("/example/{id}")
    //    public Product getById(@PathVariable Long id){
    //        return service.getById(id);
    //    }

    // GET - localhost:8080/products/example?id=5  -> the second variant. Main variant

    //only register user can view a product, also unregistered ones
    @GetMapping
    public ProductDto getById(@RequestParam Long id){
        return service.getById(id);
    }

    //only admin can save a new product
    @PostMapping
    public ProductDto save(@RequestBody ProductDto product){
        return service.save(product);
    }

    //All users, even unregistered ones, can view all products
    @GetMapping("/all")
    public List<ProductDto> getAll(){
        return service.getAll();
    }

    //the first way exception handling
    //plus - we can configure exception handling for this case if we need a different logic exception handling
    //for different controllers
    //minus - if we don't need a different logic for handling in different controllers so this handler we need to write
    //for every controller
    @ExceptionHandler(FirstTestException.class)
    @ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
    public Response handleException(FirstTestException e){
        return new Response(e.getMessage());
    }
}
