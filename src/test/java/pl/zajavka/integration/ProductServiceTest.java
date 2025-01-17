package pl.zajavka.integration;

import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import pl.zajavka.business.*;
import pl.zajavka.domain.Opinion;
import pl.zajavka.domain.Product;
import pl.zajavka.domain.Purchase;
import pl.zajavka.infrastructure.configuration.ApplicationConfiguration;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringJUnitConfig(classes = ApplicationConfiguration.class)
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ProductServiceTest {

    private ReloadDataService reloadDataService;
    private CustomerService customerService;
    private PurchaseService purchaseService;
    private OpinionService opinionService;
    private ProducerService producerService;
    private ProductService productService;

    @BeforeEach
    public void setUp() {
        assertNotNull(reloadDataService);
        assertNotNull(customerService);
        assertNotNull(purchaseService);
        assertNotNull(opinionService);
        assertNotNull(producerService);
        assertNotNull(productService);
        reloadDataService.reloadData();
    }

    @Test
    @DisplayName("Exercise 10")
    void thatProductIsWiped() {
        //given
        final var productCode = "60560-1072";
        Product before = productService.find(productCode);
        List<Opinion> opinionsBefore = opinionService.findAllByProductCode(productCode);
        List<Purchase> purchasesBefore = purchaseService.findAllByProductCode(productCode);

        assertEquals(3, opinionsBefore.size());
        assertEquals(5, purchasesBefore.size());

        //when
        productService.removeCompletely(productCode);

        //then
        Throwable exception = Assertions.assertThrows(RuntimeException.class, () -> productService.find(productCode));
        Assertions.assertEquals(String.format("Product with productCode: [%s] doesn't exist", productCode), exception.getMessage());
        assertTrue(opinionService.findAllByProductCode(productCode).isEmpty());
        assertTrue(purchaseService.findAllByProductCode(productCode).isEmpty());

    }
}
