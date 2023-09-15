package privatBankApi;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder


public class   ExchangeRateDto {

    String baseCurrency;
    String currency;
    Float saleRateNB;
    Float purchaseRateNB;
    Float saleRate;
    Float purchaseRate;

}
