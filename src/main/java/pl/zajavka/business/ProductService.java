package pl.zajavka.business;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.zajavka.domain.Product;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    @Transactional
    public Product create(Product someProduct1) {
        return productRepository.create(someProduct1);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public void removeAll() {
        productRepository.removeAll();
    }
}