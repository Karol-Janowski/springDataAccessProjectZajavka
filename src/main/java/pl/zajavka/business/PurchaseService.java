package pl.zajavka.business;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.zajavka.domain.Purchase;

import java.util.List;

@Service
@AllArgsConstructor
public class PurchaseService {

    private final PurchaseRepository purchaseRepository;

    @Transactional
    public void removeAll() {
        purchaseRepository.removeAll();
    }

    @Transactional
    public Purchase create(Purchase purchase) {
        return purchaseRepository.create(purchase);
    }

    @Transactional
    public void removeAll(String email) {
        purchaseRepository.removeAll(email);
    }

    public List<Purchase> findAll() {
        return purchaseRepository.findAll();
    }

    public List<Purchase> findAll(String email) {
        return purchaseRepository.findAll(email);
    }

    public List<Purchase> findAll(String email, String productCode) {
        return purchaseRepository.findAll(email, productCode);
    }
}
