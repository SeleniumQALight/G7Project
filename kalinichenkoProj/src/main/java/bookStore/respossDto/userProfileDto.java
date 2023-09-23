package bookStore.respossDto;

import lombok.*;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class userProfileDto {
    String userId;
    String username;
    List<AboutBooksDto> books;
}
