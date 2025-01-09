package pl.zajavka.domin;

import lombok.*;

import java.time.LocalDate;
import java.time.OffsetDateTime;

@With
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Purchase {

    private Long id;
    private Customer customer;
    private Product product;
    private Integer integer;
    private OffsetDateTime dateTime;

}