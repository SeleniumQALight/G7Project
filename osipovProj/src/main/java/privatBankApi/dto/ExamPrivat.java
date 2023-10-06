package privatBankApi.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class ExamPrivat {
    String ccy;
    String base_ccy;
    String buy;
    String sale;
}
