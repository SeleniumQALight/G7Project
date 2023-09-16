package privatBankApi.dto;

public class ExchangeRateDto {
    String baseCurrency;
    String currency;
    double saleRateNB;
    double purchaseRateNB;
    double saleRate;
    double purchaseRate;

    public ExchangeRateDto (String baseCurrency, String currency) { // конструктор
        this.baseCurrency = baseCurrency;
        this.currency = currency;
    }

    public ExchangeRateDto() { // пустий конструктор
    }

    public String getBaseCurrency() { // гетери і сетери для всіх полів описаних вище
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

    public double getSaleRateNB() {
        return saleRateNB;
    }

    public void setSaleRateNB(double saleRateNB) {
        this.saleRateNB = saleRateNB;
    }

    public double getPurchaseRateNB() {
        return purchaseRateNB;
    }

    public void setPurchaseRateNB(double purchaseRateNB) {
        this.purchaseRateNB = purchaseRateNB;
    }

    public double getSaleRate() {
        return saleRate;
    }

    public void setSaleRate(double saleRate) {
        this.saleRate = saleRate;
    }

    public double getPurchaseRate() {
        return purchaseRate;
    }

    public void setPurchaseRate(double purchaseRate) {
        this.purchaseRate = purchaseRate;
    }

    @Override
    public String toString() {   // перевизначаємо метод toString для виводу в консоль
        return "ExchangeRateDto{" +
                "baseCurrency='" + baseCurrency + '\'' + "\n" +
                ", currency='" + currency + '\'' + "\n" +
                ", saleRateNB=" + saleRateNB + "\n" +
                ", purchaseRateNB=" + purchaseRateNB + "\n" +
                ", saleRate=" + saleRate + "\n" +
                ", purchaseRate=" + purchaseRate + "\n" +
                '}';
    }
}
