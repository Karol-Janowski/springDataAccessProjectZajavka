package pl.zajavka.business;

import pl.zajavka.domain.Customer;
import pl.zajavka.domain.Product;

public interface ProductRepository {
    Product create(Product product);
}
