package demoQA;

import io.restassured.http.ContentType;
import lombok.*;

import java.awt.print.Book;
import java.util.List;

import static demoQA.ApiHelperDemoQA.getUserInfo;
import static io.restassured.RestAssured.given;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class ProfileDto {
    String userId;
    String username;
    List<BooksDTO> books;
}
