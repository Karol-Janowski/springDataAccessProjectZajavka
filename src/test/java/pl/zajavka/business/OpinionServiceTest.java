package pl.zajavka.business;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.zajavka.domain.*;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OpinionServiceTest {

    @InjectMocks
    private OpinionService opinionService;

    @Mock
    private PurchaseService purchaseService;

    @Mock
    private OpinionRepository opinionRepository;

    @Test
    @DisplayName("Exercise 5 part 1")
    void thatOpinionCanBeCreatedForProductThatCustomerAlreadyBought() {
        //given
        final var customer = StoreFixtures.someCustomer();
        final var producer = StoreFixtures.someProducer();
        final var product = StoreFixtures.someProduct1(producer);
        final var purchase = StoreFixtures.somePurchase(customer, product);
        final var opinion = StoreFixtures.someOpinion(customer, product);

        when(purchaseService.findAll(customer.getEmail(), product.getProductCode()))
                .thenReturn(List.of(purchase.withId(1L)));
        when(opinionRepository.create(opinion)).thenReturn(opinion.withId(1L));

        //when
        Opinion result = opinionService.create(opinion);

        //then
        verify(opinionRepository).create(opinion);
        assertEquals(opinion.withId(1L), result);
    }

    @Test
    @DisplayName("Exercise 5 part 2")
    void thatOpinionCannotBeCreatedForProductThatCustomerDidNotBuy() {
        //given
        final var customer = StoreFixtures.someCustomer();
        final var producer = StoreFixtures.someProducer();
        final var product = StoreFixtures.someProduct1(producer);
        final var opinion = StoreFixtures.someOpinion(customer, product);

        when(purchaseService.findAll(customer.getEmail(), product.getProductCode()))
                .thenReturn(List.of());

        //when
        Throwable exception = assertThrows(RuntimeException.class, () -> opinionService.create(opinion));
        assertEquals(
                "Customer [%s] wants to give opinion for product: [%s] but there is no purchase"
                        .formatted(customer.getEmail(), product.getProductCode()),
                        exception.getMessage()
                );

        verify(opinionRepository, Mockito.never()).create(any(Opinion.class));

    }
}