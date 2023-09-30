/**
 https://api.privatbank.ua/p24api/pubinfo?json&exchange&coursid=5
 {
 "ccy": "EUR",
 "base_ccy": "UAH",
 "buy": "39.80000",
 "sale": "40.80000"
 },
 {
 "ccy": "USD",
 "base_ccy": "UAH",
 "buy": "37.15000",
 "sale": "37.75000"
 }
 */


package api.dto.responseDto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString

public class PrivatGET {
    String ccy;
    String base_ccy;
    String buy;
    String sale;
}
