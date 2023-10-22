package privatbankApi.responsDto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class ActualCursPrivateDto {
    String ccy;
    String base_ccy;
    String buy;
    String sale;
}
