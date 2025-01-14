package pl.zajavka.business;

import pl.zajavka.domain.Customer;

import java.util.Optional;

public interface CustomerRepository {
    Optional<Customer> find(String email);

    Customer create(Customer customer);

    void removeAll();

    void remove(String email);
}
