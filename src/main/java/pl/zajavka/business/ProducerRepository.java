package pl.zajavka.business;

import pl.zajavka.domain.Customer;
import pl.zajavka.domain.Producer;

public interface ProducerRepository {
    Producer create(Producer producer);
}
