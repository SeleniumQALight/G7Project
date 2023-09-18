package privatBankApi.getDto.responseDto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class ExchangeRateDtoPrivatBank {
    String baseCurrency;
    String currency;
    Double saleRateNB;
    Double purchaseRateNB;
    Double saleRate;
    Double purchaseRate;



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

//    public ExchangeRateDtoPrivatBank(String baseCurrency, String currency) {
//        this.baseCurrency = baseCurrency;
//        this.currency = currency;
//    }
//
////    public ExchangeRateDtoPrivatBank(){};
//
//    public ExchangeRateDtoPrivatBank(String baseCurrency, String currency, Double saleRateNB, Double purchaseRateNB, Double saleRate, Double purchaseRate) {
//        this.baseCurrency = baseCurrency;
//        this.currency = currency;
//        this.saleRateNB = saleRateNB;
//        this.purchaseRateNB = purchaseRateNB;
//        this.saleRate = saleRate;
//        this.purchaseRate = purchaseRate;
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
//    @Override
//    public String toString() {
//        return "ExchangeRateDtoPrivatBank{" +
//                "baseCurrency='" + baseCurrency + '\'' +
//                ", currency='" + currency + '\'' +
//                ", saleRateNB=" + saleRateNB +
//                ", purchaseRateNB=" + purchaseRateNB +
//                ", saleRate=" + saleRate +
//                ", purchaseRate=" + purchaseRate +
//                '}';
//    }
}
