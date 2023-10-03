package demoQAApi;

import java.util.List;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder

public class UserProfileDto {
    String userId;
    String username;
    List<BooksDetailsDto> books;

}
