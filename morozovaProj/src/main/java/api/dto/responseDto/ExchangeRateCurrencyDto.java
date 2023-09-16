package api.dto.responseDto;

import lombok.*;

@NoArgsConstructor //заміняє дефолтний конструктор
@AllArgsConstructor //з усіма філдами
@Builder

@Getter
@Setter
@ToString

public class ExchangeRateCurrencyDto {
    String baseCurrency;
    String currency;
    Double saleRateNB;
    Double purchaseRateNB;
    Double saleRate;
    Double purchaseRate;

    public ExchangeRateCurrencyDto(String baseCurrency, String currency) {
            this.baseCurrency = baseCurrency;
            this.currency = currency;
            this.saleRateNB = saleRateNB;
            this.purchaseRateNB = purchaseRateNB;
        }
    }
