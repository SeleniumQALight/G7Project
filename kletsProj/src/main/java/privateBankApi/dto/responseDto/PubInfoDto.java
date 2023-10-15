package privateBankApi.dto.responseDto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder

public class PubInfoDto {
    String ccy;
    String base_ccy;
    String buy;
    String sale;
}
