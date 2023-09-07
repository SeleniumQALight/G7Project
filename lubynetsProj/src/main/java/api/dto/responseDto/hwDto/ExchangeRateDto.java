package api.dto.responseDto.hwDto;

public class ExchangeRateDto {

    String baseCurrency;
    String currency;
    Double saleRateNB;
    Double purchaseRateNB;
    Double saleRate;
    Double purchaseRate;


    public ExchangeRateDto() {

    }

    public ExchangeRateDto(String baseCurrency, String currency) {
        this.baseCurrency = baseCurrency;
        this.currency = currency;
        this.saleRateNB = saleRateNB;
        this.purchaseRateNB = purchaseRateNB;
    }

    public String getBaseCurrency() {
        return baseCurrency;
    }

    public String getCurrency() {
        return currency;
    }

    public Double getSaleRateNB() {
        return saleRateNB;
    }

    public void setSaleRateNB(Double saleRateNB) {
        this.saleRateNB = saleRateNB;
    }

    public Double getPurchaseRateNB() {
        return purchaseRateNB;
    }

    public void setPurchaseRateNB(Double purchaseRateNB) {
        this.purchaseRateNB = purchaseRateNB;
    }

    public Double getSaleRate() {
        return saleRate;
    }

    public void setSaleRate(Double saleRate) {
        this.saleRate = saleRate;
    }

    public Double getPurchaseRate() {
        return purchaseRate;
    }

    public void setPurchaseRate(Double purchaseRate) {
        this.purchaseRate = purchaseRate;
    }
}