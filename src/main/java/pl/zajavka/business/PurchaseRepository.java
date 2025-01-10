package pl.zajavka.business;

import pl.zajavka.domain.Customer;
import pl.zajavka.domain.Purchase;

public interface PurchaseRepository {
    Purchase create(Purchase purchase);

    void removeAll();
}
