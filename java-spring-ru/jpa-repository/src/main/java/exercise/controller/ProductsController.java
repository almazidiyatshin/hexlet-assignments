package exercise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.data.domain.Sort;

import java.util.List;

import exercise.model.Product;
import exercise.repository.ProductRepository;
import exercise.exception.ResourceNotFoundException;

@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    private ProductRepository productRepository;

    // BEGIN
    @GetMapping(path = "")
    public List<Product> index(@RequestParam Integer min, @RequestParam Integer max) {
        List<Product> products = productRepository.findAll();

        if (min != null && max != null) {
            products = productRepository.findByPriceBetween(min, max);
        }

        if (min != null && max == null) {
            products = productRepository.findByPriceGreaterThan(min);
        }

        if (min == null && max != null) {
            products = productRepository.findByPriceLessThan(max);
        }

        return products.stream()
                .sorted((a, b) -> Integer.compare(a.getPrice(), b.getPrice()))
                .toList();
    }
    // END

    @GetMapping(path = "/{id}")
    public Product show(@PathVariable long id) {

        var product =  productRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Product with id " + id + " not found"));

        return product;
    }
}
