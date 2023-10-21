package privatBankApi.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class ExamCurrencyDetails {
    String ccy;
    String base_ccy;
    Double buy;
    Double sale;
}
