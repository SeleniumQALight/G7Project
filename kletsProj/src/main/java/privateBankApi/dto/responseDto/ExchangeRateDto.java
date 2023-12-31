package privateBankApi.dto.responseDto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder

public class ExchangeRateDto {

    String baseCurrency;
    String currency;
    Double saleRateNB;
    Double purchaseRateNB;
    Double saleRate;
    Double purchaseRate;

    public static ExchangeRateDto createExRateWithUAHAsDefault(String currency) {
        return ExchangeRateDto.builder()
                .baseCurrency("UAH")
                .currency(currency)
                .build();
    }

//    public ExchangeRateDto() {
//    }
//
//    public ExchangeRateDto(String baseCurrency, String currency) {
//        this.baseCurrency = baseCurrency;
//        this.currency = currency;
//    }

//    public String getBaseCurrency() {
//        return baseCurrency;
//    }
//
//    public void setBaseCurrency(String baseCurrency) {
//        this.baseCurrency = baseCurrency;
//    }
//
//    public String getCurrency() {
//        return currency;
//    }
//
//    public void setCurrency(String currency) {
//        this.currency = currency;
//    }
//
//    public Double getSaleRateNB() {
//        return saleRateNB;
//    }
//
//    public void setSaleRateNB(Double saleRateNB) {
//        this.saleRateNB = saleRateNB;
//    }
//
//    public Double getPurchaseRateNB() {
//        return purchaseRateNB;
//    }
//
//    public void setPurchaseRateNB(Double purchaseRateNB) {
//        this.purchaseRateNB = purchaseRateNB;
//    }
//
//    public Double getSaleRate() {
//        return saleRate;
//    }
//
//    public void setSaleRate(Double saleRate) {
//        this.saleRate = saleRate;
//    }
//
//    public Double getPurchaseRate() {
//        return purchaseRate;
//    }
//
//    public void setPurchaseRate(Double purchaseRate) {
//        this.purchaseRate = purchaseRate;
//    }
//
//    @Override
//    public String toString() {
//        return "ExchangeRateDto{" +
//                "baseCurrency='" + baseCurrency + '\'' +
//                ", currency='" + currency + '\'' +
//                ", saleRateNB=" + saleRateNB +
//                ", purchaseRateNB=" + purchaseRateNB +
//                ", saleRate=" + saleRate +
//                ", purchaseRate=" + purchaseRate +
//                '}';
//    }
}
