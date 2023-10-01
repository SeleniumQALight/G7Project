/**
 * https://demoqa.com/Account/v1/Login
 * {
 * "userName": "marisun",
 * "password": "123456!Qq"
 * }
 * ==
 "userId": "747bfc6c-4006-428b-a45b-1dedd2ad8e46",
 "username": "marisun",
 "password": "123456!Qq",
 "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6Im1hcmlzdW4iLCJwYXNzd29yZCI6IjEyMzQ1NiFRcSIsImlhdCI6MTY5NDk1MTgwOX0.VWgpuDr4irugBtHIzrjEeoHZMqUPW1f8KwDXhEnu0Cw",
 "expires": "2023-09-24T11:56:49.000Z",
 "created_date": "2023-09-17T11:56:08.000Z",
 "isActive": false
 */

package demoqaAPi_hw;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class LoginApiDTO {
    String userId;
    String username;
    String password;
    String token;
    String expires;
    String created_date;
    String isActive;
}
