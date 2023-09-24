package demoQAApi;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder

public class LoginResponseDto {

    String userId;
    String username;
    String password;
    String token;
    String expires;
    String created_date;
    String isActive;

}
