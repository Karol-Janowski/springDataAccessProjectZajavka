package pl.zajavka.business;

import pl.zajavka.domain.Opinion;

import java.util.List;

public interface OpinionRepository {
    Opinion create(Opinion opinion);

    List<Opinion> findAll();

    void removeAll();

    void remove(String email);

    List<Opinion> findAll(String email);

    List<Opinion> findUnwantedOpinions();

    void removeUnwantedOpinions();

    boolean customerGivesUnwantedOpinions(String email);

    List<Opinion> findAllByProductCode(String productCode);

    void removeAllByProductCode(String productCode);
}
