package api.dto.responseDto;

import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class CurrencyDto {

    String ccy;
    String base_ccy;
    Float buy;
    Float sale;

}
