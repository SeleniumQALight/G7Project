package privateBankApi.dto.responseDto;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder

public class PubInfoAllCurrencyDto {
    private String ccy;
    private String base_ccy;
    private String buy;
    private String sale;
    private List<PubInfoDto> pubInfoDtoList;

}
