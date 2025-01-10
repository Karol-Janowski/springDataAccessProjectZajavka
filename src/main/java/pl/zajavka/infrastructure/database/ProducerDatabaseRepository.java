package pl.zajavka.infrastructure.database;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.stereotype.Repository;
import pl.zajavka.business.ProducerRepository;
import pl.zajavka.domain.Producer;

@Slf4j
@Repository
@AllArgsConstructor
public class ProducerDatabaseRepository implements ProducerRepository {

    private final SimpleDriverDataSource simpleDriverDataSource;

    @Override
    public Producer create(Producer producer) {
        return null;
    }
}
