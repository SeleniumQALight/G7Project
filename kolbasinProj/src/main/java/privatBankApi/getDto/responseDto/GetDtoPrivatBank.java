package privatBankApi.getDto.responseDto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class GetDtoPrivatBank {
    String date;
    String bank;
    Integer baseCurrency;
    String baseCurrencyLit;
    ExchangeRateDtoPrivatBank[] exchangeRate;

//    public GetDtoPrivatBank(){};

//    public GetDtoPrivatBank(String date, String bank, Integer baseCurrency, String baseCurrencyLit, ExchangeRateDtoPrivatBank[] exchangeRate) {
//        this.date = date;
//        this.bank = bank;
//        this.baseCurrency = baseCurrency;
//        this.baseCurrencyLit = baseCurrencyLit;
//        this.exchangeRate = exchangeRate;
//    }

//    public String getDate() {
//        return date;
//    }
//
//    public void setDate(String date) {
//        this.date = date;
//    }
//
//    public String getBank() {
//        return bank;
//    }
//
//    public void setBank(String bank) {
//        this.bank = bank;
//    }
//
//    public int getBaseCurrency() {
//        return baseCurrency;
//    }
//
//    public void setBaseCurrency(int baseCurrency) {
//        this.baseCurrency = baseCurrency;
//    }
//
//    public String getBaseCurrencyLit() {
//        return baseCurrencyLit;
//    }
//
//    public void setBaseCurrencyLit(String baseCurrencyLit) {
//        this.baseCurrencyLit = baseCurrencyLit;
//    }
//
//    public ExchangeRateDtoPrivatBank[] getExchangeRate() {
//        return exchangeRate;
//    }
//
//    public void setExchangeRate(ExchangeRateDtoPrivatBank[] exchangeRate) {
//        this.exchangeRate = exchangeRate;
//    }

//    @Override
//    public String toString() {
//        return "GetDto{" +
//                "date='" + date + '\'' +
//                ", bank='" + bank + '\'' +
//                ", baseCurrency=" + baseCurrency +
//                ", baseCurrencyLit='" + baseCurrencyLit + '\'' +
//                ", exchangeRate=" + exchangeRate +
//                '}';
//    }
}
