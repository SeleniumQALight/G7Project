package privateBankApi.dto;

public class ExchangeRateDtoPBExam {
    String ccy;
    String base_ccy;
    String buy;
    String sale;
public ExchangeRateDtoPBExam() {

   }
    public ExchangeRateDtoPBExam(String ccy, String base_ccy) {
        this.ccy = ccy;
        this.base_ccy = base_ccy;
    }

    public String getCcy() {
        return ccy;
    }

    public String getBase_ccy() {
        return base_ccy;
    }

    public String getBuy() {
        return buy;
    }

    public String getSale() {
        return sale;
    }
}
