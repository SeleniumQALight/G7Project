package demoQaApi.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class AuthorizationDto {
    String userId;
    String username;
    String password;
    String token;
    String expires;
    String created_date;
    Boolean isActive;
}
