package de.aittr.g_37_jp_shop.logging;

import de.aittr.g_37_jp_shop.domain.dto.ProductDto;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

//AspectJ framework
@Aspect
@Component
public class AspectLogging {
    private Logger logger = LoggerFactory.getLogger(AspectLogging.class);

    @Pointcut("execution(* de.aittr.g_37_jp_shop.service.ProductServiceImpl.save(de.aittr.g_37_jp_shop.domain.dto.ProductDto))")
    public void saveProduct(){}

    @Before("saveProduct()")
    public void beforeSavingProduct(){
        //Advice - the code that will be added to the main code when using a rule in @Pointcut
        logger.info("Method save of the class ProductServiceImpl called");
    }

    @After("saveProduct()")
    public void afterSavingProduct(){
        logger.info("Method save of the class ProductServiceImpl finished its work");
    }

//    @Before("saveProduct()")
//    public void beforeSavingProduct(JoinPoint joinPoint){
//        Advice - the code that will be added to the main code when using a rule in @Pointcut
//        Object[] args = joinPont.getArgs(); = if we want to see a product that we saved. for example
//        logger.info("Method save of the class ProductServiceImpl called with parameters {}", args);
//    }

    @Pointcut("execution(* de.aittr.g_37_jp_shop.service.ProductServiceImpl.getById(..))")//.. for all methods
    public void getProductById(){}

    @AfterReturning("getProductById()")
    public void afterReturningProductById(){
        logger.info("Method getByID of the class ProductServiceImpl successfully returned product");
    }

//    @AfterReturning(pointcut = "getProductById()", returning = "result")
//    public void afterReturningProductById(Object result){
//        logger.info("Method getByID of the class ProductServiceImpl successfully returned product {}", result);
//    } We see what object we returned

    @AfterThrowing(pointcut = "getProductById()", throwing = "e")
    public void afterThrowingAnExceptionWhileGettingProductById(Exception e){
        logger.warn("Method getByID of the class ProductServiceImpl threw an exception while getting product:" +
                "message -  {}", e.getMessage());
    }

    @Pointcut("execution(* de.aittr.g_37_jp_shop.service.ProductServiceImpl.getAll(..))")
    public void getAllProducts(){}

    @Around("getAllProducts()")
    public Object aroundGettingAllProducts(ProceedingJoinPoint joinPoint){
        logger.info("Method getAll of the class ProductServiceInl was called");

        List<ProductDto> result = null;

        try {
            result = ((List<ProductDto>) joinPoint.proceed())
                    .stream()
                    .filter(x -> x.getPrice().compareTo(new BigDecimal(100))>0)
                    .toList();
        }catch (Throwable e){
            logger.error("Method getAll of the class ProductServiceImpl threw an exception: {}", e.getMessage());
        }

        logger.info("Method getAll of the class ProductServiceInl finished its work");
        return result;
    }

    
}
