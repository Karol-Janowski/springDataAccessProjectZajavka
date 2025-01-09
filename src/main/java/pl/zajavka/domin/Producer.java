package pl.zajavka.domin;

import lombok.*;

@With
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Producer {

    private Long id;
    private String producerName;
    private String address;
}