package api.dto.responseDto.hwDto;

public class HwDtoPB {

    String date;
    String bank;
    Integer baseCurrency;
    String baseCurrencyLit;
    ExchangeRateDto[] exchangeRate;


    public String getDate() {
        return date;
    }


    public void setDate(String date) {
        this.date = date;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public Integer getBaseCurrency() {
        return baseCurrency;
    }

    public void setBaseCurrency(Integer baseCurrency) {
        this.baseCurrency = baseCurrency;
    }

    public String getBaseCurrencyLit() {
        return baseCurrencyLit;
    }

    public void setBaseCurrencyLit(String baseCurrencyLit) {
        this.baseCurrencyLit = baseCurrencyLit;
    }

    public ExchangeRateDto[] getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(ExchangeRateDto[] exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    @Override
    public String toString() {
        return "HwDtoPB{" +
                "date='" + date + '\n' +
                ", bank='" + bank + '\n' +
                ", baseCurrency=" + baseCurrency +
                ", baseCurrencyLit='" + baseCurrencyLit + '\n' +
                ", exchangeRate=" + exchangeRate +
                '\n' + '}';
    }
}