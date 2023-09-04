package privatBankApi.getDto.responseDto;

public class ExchangeRateDto {
    String baseCurrency;
    String currency;
    int saleRateNB;
    int purchaseRateNB;

    public ExchangeRateDto(){};

    public ExchangeRateDto(String baseCurrency, String currency, int saleRateNB, int purchaseRateNB) {
        this.baseCurrency = baseCurrency;
        this.currency = currency;
        this.saleRateNB = saleRateNB;
        this.purchaseRateNB = purchaseRateNB;
    }

    public String getBaseCurrency() {
        return baseCurrency;
    }

    public void setBaseCurrency(String baseCurrency) {
        this.baseCurrency = baseCurrency;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public int getSaleRateNB() {
        return saleRateNB;
    }

    public void setSaleRateNB(int saleRateNB) {
        this.saleRateNB = saleRateNB;
    }

    public int getPurchaseRateNB() {
        return purchaseRateNB;
    }

    public void setPurchaseRateNB(int purchaseRateNB) {
        this.purchaseRateNB = purchaseRateNB;
    }

    @Override
    public String toString() {
        return "ExchangeRateDto{" +
                "baseCurrency='" + baseCurrency + '\'' +
                ", currency='" + currency + '\'' +
                ", saleRateNB=" + saleRateNB +
                ", purchaseRateNB=" + purchaseRateNB +
                '}';
    }
}
