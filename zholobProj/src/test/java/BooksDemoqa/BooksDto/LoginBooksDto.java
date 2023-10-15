package BooksDemoqa.BooksDto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder

public class LoginBooksDto {
     String userId;
     String username;
     String password;
     String token;
     String expires;
     String created_date;
     String isActive;
}

//GET https://demoqa.com/Account/v1/Login
//        {
//        "userName": "inna",
//        "password": "Nhfvgfvgfv_369*"
//}
// RESPONSE:
//        {
//        "userId": "077b1a12-9196-4ef9-a35b-f14c6dcb0057",
//        "username": "inna",
//        "password": "Nhfvgfvgfv_369*",
//        "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6ImlubmEiLCJwYXNzd29yZCI6Ik5oZnZnZnZnZnZfMzY5KiIsImlhdCI6MTY5NzA0ODcxNn0.iKTnG0UCodxyiJohwLWjXkwAvLMEOno_oT_vzsAvUYY",
//        "expires": "2023-10-18T18:25:16.000Z",
//        "created_date": "2023-09-10T15:56:10.000Z",
//        "isActive": false
//        }

