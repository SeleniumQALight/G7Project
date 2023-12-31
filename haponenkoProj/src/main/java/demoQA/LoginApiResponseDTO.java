package demoQA;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class LoginApiResponseDTO {
    String userId;
    String username;
    String password;
    String token;
    String expires;
    String created_date;
    String isActive;
}
