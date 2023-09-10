package privatBankApi;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder


public class PrimaryDto {
    String date;
    String bank;
    int baseCurrency;
    String baseCurrencyLit;
    ExchangeRateDto[] exchangeRate;


}
