package demoQA;

import lombok.*;

import java.util.List;

import static demoQA.ApiHelperDemoQA.getUserInfo;
import static io.restassured.RestAssured.given;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class UserProfileDto {
    String userId;
    String username;
    List<BookDTO> books;
}
