package pl.zajavka.integration;

import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import pl.zajavka.business.*;
import pl.zajavka.domain.*;
import pl.zajavka.infrastructure.configuration.ApplicationConfiguration;

import java.util.List;

@SpringJUnitConfig(classes = ApplicationConfiguration.class)
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ReloadDataServiceTest {

    private ReloadDataService reloadDataService;

    private CustomerService customerService;
    private OpinionService opinionService;
    private ProducerService producerService;
    private ProductService productService;
    private PurchaseService purchaseService;

    @Test
    void thatDataIsReloaded() {
        // given, when
        reloadDataService.reloadData();

        // then
        List<Customer> allCustomers = customerService.findAll();
        List<Opinion> allOpinionServices = opinionService.findAll();
        List<Producer> allProducerServices = producerService.findAll();
        List<Product> allProductServices = productService.findAll();
        List<Purchase> allPurchaseServices = purchaseService.findAll();

        Assertions.assertEquals(100, allCustomers.size());
        Assertions.assertEquals(140, allOpinionServices.size());
        Assertions.assertEquals(20, allProducerServices.size());
        Assertions.assertEquals(50, allProductServices.size());
        Assertions.assertEquals(300, allPurchaseServices.size());
    }


}
