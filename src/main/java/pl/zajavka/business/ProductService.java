package pl.zajavka.business;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.zajavka.domain.Product;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    @Transactional
    public Product create(Product someProduct1) {
        return productRepository.create(someProduct1);
    }

    public void removeAll() {
        productRepository.removeAll();
    }
}