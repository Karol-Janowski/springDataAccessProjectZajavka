package pl.zajavka.business;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.zajavka.domain.Product;

import java.util.List;
import java.util.concurrent.Semaphore;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final OpinionService opinionService;
    private final PurchaseService purchaseService;


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

    public Product find(String productCode) {
        return productRepository.find(productCode)
                .orElseThrow(() -> new RuntimeException(String.format("Product with productCode: [%s] doesn't exist", productCode)));
    }

    @Transactional
    public void removeCompletely(String productCode) {
        purchaseService.removeAllByProductCode(productCode);
        opinionService.removeAllByProductCode(productCode);
        productRepository.remove(productCode);

    }
}