package bookStore.respossDto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class TokenResponseDto {
    String userId;
    String token;
    String expires;
    String username;
    String password;
    String created_date;
    Boolean isActive;
}
