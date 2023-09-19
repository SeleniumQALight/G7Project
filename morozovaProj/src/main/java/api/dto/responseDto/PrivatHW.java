package api.dto.responseDto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString

public class PrivatHW {
    String date;
    String bank;
    int baseCurrency;
    String baseCurrencyLit;
    ExchangeRateCurrencyDto[] exchangeRate;
}
